package com.sword.smvcm.manager.directive;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import com.sword.smvcm.utils.StringUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * HTML文本提取并截断
 * 
 * 需要拦截器com.jeecms.common.web.ProcessTimeFilter支持
 */
public class HtmlCutDirective implements TemplateDirectiveModel {
  public static final String PARAM_S = "s";

  public static final String PARAM_LEN = "len";

  public static final String PARAM_APPEND = "append";

  public static final String PARAM_Q = "q";

  @SuppressWarnings("unchecked")
  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
      throws TemplateException, IOException {
    String s = DirectiveUtils.getString(PARAM_S, params);
    Integer len = DirectiveUtils.getInt(PARAM_LEN, params);
    String append = DirectiveUtils.getString(PARAM_APPEND, params);
    String q = DirectiveUtils.getString(PARAM_Q, params);
    if (s != null) {
      Writer out = env.getOut();
      if (len != null) {
        if (q != null)
          out.append(
              StringUtils.htmlCut(s, len, append).replaceAll(q, "<span class='fd_color_d94d4c'>" + q + "</span>"));
        else
          out.append(StringUtils.htmlCut(s, len, append));
      }
      else {
        out.append(s);
      }
    }
  }
}
