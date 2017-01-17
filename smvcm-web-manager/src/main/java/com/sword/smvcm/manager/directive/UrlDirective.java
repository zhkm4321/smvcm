package com.sword.smvcm.manager.directive;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.springframework.util.StringUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 资源文件路径处理标签
 */
public class UrlDirective implements TemplateDirectiveModel {

  public static final String PARAM_URL = "url";

  public static final String PARAM_DEFAULT = "default";

  @SuppressWarnings("unchecked")
  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
      throws TemplateException, IOException {
    String url = DirectiveUtils.getString(PARAM_URL, params);
    String defaultUrl = DirectiveUtils.getString(PARAM_DEFAULT, params);
    if (StringUtils.isEmpty(url)) {
      url = defaultUrl;
    }
    TemplateModel cpModel = env.getDataModel().get("cp");
    String contextPath = cpModel.toString();
    if (!url.startsWith("http://")) {
      if (!url.startsWith(contextPath)) {
        url = contextPath + url;
      }
    }
    Writer out = env.getOut();
    out.append(url);
  }
}
