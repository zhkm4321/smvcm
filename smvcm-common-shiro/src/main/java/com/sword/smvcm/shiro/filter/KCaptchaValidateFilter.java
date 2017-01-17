package com.sword.smvcm.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.sword.smvcm.exception.SmvcmException;
import com.sword.smvcm.shiro.ShiroConstants;
import com.sword.smvcm.utils.CaptchaUtils;

public class KCaptchaValidateFilter extends AccessControlFilter {

  private boolean captchaEbabled = true;// 是否开启验证码支持

  public void setCaptchaEbabled(boolean captchaEbabled) {
    this.captchaEbabled = captchaEbabled;
  }

  @Override
  protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
      throws Exception {
    // 1、设置验证码是否开启属性，页面可以根据该属性来决定是否显示验证码
    request.setAttribute("captchaEbabled", captchaEbabled);
    HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
    // 2、判断验证码是否禁用 或不是表单提交（允许访问）
    if (captchaEbabled == false || !"post".equalsIgnoreCase(httpServletRequest.getMethod())) {
      return true;
    }
    // 3、此时是表单提交，验证验证码是否正确
    CaptchaUtils.validCaptcha(httpServletRequest);
    return true;
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    // 如果验证码失败了，存储失败key属性
    request.setAttribute(ShiroConstants.shiroLoginFailure, SmvcmException.class.getName());
    return true;
  }

}
