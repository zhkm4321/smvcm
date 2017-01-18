package com.sword.smvcm.manager.interceptor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sword.smvcm.manager.constans.BaseConstans;
import com.sword.smvcm.manager.utils.UserUtils;
import com.sword.smvcm.users.i.UserService;
import com.sword.smvcm.users.pojo.TbRolePermission;
import com.sword.smvcm.users.pojo.TbUser;

public class EvnInterceptor extends HandlerInterceptorAdapter {

  private static Logger log = LoggerFactory.getLogger(EvnInterceptor.class);

  public static String START_TIME = "start_time";

  @Autowired
  private UserService userSvc;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    request.setAttribute("start_time", System.currentTimeMillis());
    return super.preHandle(request, response, handler);
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    String cp = request.getSession().getServletContext().getContextPath();
    if (null != modelAndView) {
      TbUser curUser = UserUtils.currentUser();
      if (null != curUser) {
        modelAndView.addObject(BaseConstans.USER_KEY, curUser);
        modelAndView.addObject(BaseConstans.PERMISSION_KEY, getUserPermission(curUser));
      }
      modelAndView.addObject(BaseConstans.CTX_PATH, cp);
      modelAndView.addObject(BaseConstans.RES, cp + "/static");
      modelAndView.addObject(BaseConstans.SYSRES, cp + "/static");// cp +
                                                                  // "/backstage"
      Long stime = (Long) request.getAttribute("start_time");
      modelAndView.addObject(BaseConstans.START_TIME, stime);
    }
    super.postHandle(request, response, handler, modelAndView);
  }

  private Set<String> getUserPermission(TbUser user) {
    List<TbRolePermission> perms = userSvc.selectUserPermission(user);
    Set<String> permSet = new HashSet<String>();
    if (!CollectionUtils.isEmpty(perms)) {
      for (TbRolePermission permi : perms) {
        permSet.add(permi.getValue());
      }
      if (log.isDebugEnabled()) {
        log.debug("用户权限 {}", Arrays.toString(permSet.toArray()));
      }
    }
    else {
      if (log.isDebugEnabled()) {
        log.debug("用户没有获取到权限");
      }
    }
    return permSet;
  }
}
