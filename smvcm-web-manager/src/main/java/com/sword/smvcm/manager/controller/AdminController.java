package com.sword.smvcm.manager.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.sword.smvcm.exception.SmvcmException;
import com.sword.smvcm.manager.constans.BaseConstans;
import com.sword.smvcm.manager.utils.TplPathUtils;
import com.sword.smvcm.manager.utils.UserUtils;
import com.sword.smvcm.shiro.ShiroConstants;
import com.sword.smvcm.users.pojo.TbUser;
import com.sword.smvcm.utils.CaptchaUtils;

@Controller
public class AdminController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String signup(HttpSession session, ModelMap model) {
    CaptchaUtils.addCaptcha(session, model);
    // 注销后返回登录页
    TbUser user = UserUtils.currentUser();
    if (null != user) {
      UserUtils.logout();
      return "redirect:/wxbackstage/login.do";
    }
    return TplPathUtils.getBackstageTpl("login/login");
  }

  /**
   * 用户登陆
   * 
   * @throws IOException
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public String login(ModelMap model, HttpServletRequest request, HttpSession session) throws IOException {
    Map<String, Object> result = new HashMap<String, Object>();
    // 如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
    String exceptionClassName = (String) request.getAttribute(ShiroConstants.shiroLoginFailure);
    // 根据shiro返回的异常类路径判断，抛出指定异常信息
    String authticationError = null;
    String returnUrl = request.getContextPath() + "/login";
    if (StringUtils.hasText(exceptionClassName)) {
      if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
        // 最终会抛给异常处理器
        authticationError = "账号不存在!";
      }
      else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
        authticationError = "用户名/密码错误!";
      }
      else if (SmvcmException.class.getName().equals(exceptionClassName)) {
        authticationError = "验证码错误!";
      }
      else if (LockedAccountException.class.getName().equals(exceptionClassName)) {
        authticationError = "账号已被锁定，请与系统管理员联系!";
      }
      else if (AuthenticationException.class.getName().equals(exceptionClassName)) {
        authticationError = "您没有授权！";
      }
      else {
        authticationError = "未知异常！";
      }
    }
    if (null != authticationError) {
      result.put(BaseConstans.RETURN_URL, returnUrl);
      BaseConstans.wrapError(authticationError, result);
    }
    else {
      BaseConstans.wrapSuccess(true, result);
    }
    return JSON.json(result);
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logoutAndRedirect(String returnUrl, HttpSession session, ModelMap mav) {
    try {
      UserUtils.logout();
    }
    catch (Exception e) {
      BaseConstans.wrapError("注销失败", mav);
    }
    return "redirect:/admin/login";
  }
}
