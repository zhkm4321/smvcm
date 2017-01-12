package com.sword.smvcm.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

  private static Logger log = LoggerFactory.getLogger(CustomFormAuthenticationFilter.class);

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue)
      throws Exception {
    if (request.getAttribute(getFailureKeyAttribute()) != null) {
      return true;
    }
    return super.onAccessDenied(request, response, mappedValue);
  }

  @Override
  protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
      ServletResponse response) throws Exception {
    // TODO 登录成功后允许拦截器继续向后走
    return true;
  }

  @Override
  protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
      ServletResponse response) {
    return super.onLoginFailure(token, e, request, response);
  }
}
