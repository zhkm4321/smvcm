package com.sword.smvcm.manager.directive;

import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sword.smvcm.manager.directive.exception.MustNumberException;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;

/**
 * 执行时间标签
 * 
 * 需要拦截器com.jeecms.common.web.ProcessTimeFilter支持
 */
public class ProcessTimeDirective implements TemplateDirectiveModel {
  private static final Logger log = LoggerFactory.getLogger(ProcessTimeDirective.class);

  private static final DecimalFormat FORMAT = new DecimalFormat("0.0000");

  @SuppressWarnings("rawtypes")
  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
      throws TemplateException, IOException {
    long time = getStartTime(env);
    if (time != -1) {
      time = System.currentTimeMillis() - time;
      Writer out = env.getOut();
      out.append("Processed in " + FORMAT.format(time / 1000F) + " second(s)");
    }
  }

  private long getStartTime(Environment env) throws TemplateModelException {
    TemplateModel startTime = env.getGlobalVariable(com.sword.smvcm.manager.interceptor.EvnInterceptor.START_TIME);
    if (startTime == null) {
      log.warn("Variable '{}' not found in GlobalVariable",
          com.sword.smvcm.manager.interceptor.EvnInterceptor.START_TIME);
      return -1;
    }
    if (startTime instanceof TemplateNumberModel) {
      return ((TemplateNumberModel) startTime).getAsNumber().longValue();
    }
    else {
      throw new MustNumberException("startTime：" + startTime.toString() + "不是数字");
    }
  }

}
