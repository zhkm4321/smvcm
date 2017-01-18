package com.sword.smvcm.utils;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.sword.smvcm.exception.SmvcmException;
import com.sword.smvcm.service.jedis.JedisClient;
import com.sword.smvcm.service.jedis.JedisClientSingleImpl;
import com.sword.smvcm.shiro.ShiroConstants;

@Component
public class CaptchaUtils {

  private static Logger log = LoggerFactory.getLogger(CaptchaUtils.class);

  private static JedisClient jedisClient = null;

  @Autowired
  private JedisClientSingleImpl jedisClientSingleImpl;

  @PostConstruct
  public void init() {
    if (CaptchaUtils.jedisClient == null) {
      CaptchaUtils.jedisClient = jedisClientSingleImpl;
    }
  }

  public static void addCaptcha(HttpSession session, ModelMap mav) {
    String cp = session.getServletContext().getContextPath();
    mav.put("captcha", "<img border='0' id='codeimage' name='codeimage' src='" + cp + "/captcha.jpg' alt='captcha'/>");
  }

  /**
   * 设置captcha的值为验证码的html代码
   * 
   * @param session
   * @param mav
   */
  public void addCaptcha(HttpSession session, Map<String, String> mav) {
    String cp = session.getServletContext().getContextPath();
    mav.put("captcha", "<img border='0' id='codeimage' name='codeimage' src='" + cp + "/captcha.jpg' alt='captcha'/>");
  }

  /**
   * 检查验证码是否正确
   * 
   * @param request
   * @return
   */
  public static boolean validCaptcha(HttpServletRequest request) {
    String captcha = request.getParameter("captcha");
    if (!StringUtils.isEmpty(captcha) && captcha.equals(getGeneratedKey(request))) {
      return true;
    }
    else {
      request.setAttribute(ShiroConstants.shiroLoginFailure, SmvcmException.class.getName());
    }
    return false;
  }

  /**
   * 从缓存中获取验证码
   * 
   * @param req
   * @return
   */
  public static String getGeneratedKey(HttpServletRequest request) {
    String capText = jedisClient.get(ShiroConstants.KAPTCHA_KEY_VALUE + request.getSession().getId());
    return capText;
  }
}
