package com.sword.smvcm.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import com.sword.smvcm.exception.SmvcmException;

public class CaptchaUtils {
  /**
   * 检查验证码是否正确
   * 
   * @param request
   * @return
   */
  public static boolean validCaptcha(HttpServletRequest request) {
    String captcha = request.getParameter("captcha");
    if (StringUtils.isEmpty(captcha)) {
      if (captcha.equals(getGeneratedKey(request))) {
        return true;
      }
    }
    else {
      request.setAttribute("shiroLoginFailure", SmvcmException.class.getName());
    }
    return false;
  }

  private static Object getGeneratedKey(HttpServletRequest request) {
    HttpSession session = request.getSession();
    return (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
  }
}
