package com.sword.smvcm.manager.directive;

import java.io.IOException;
import java.util.Map;

import com.sword.smvcm.manager.utils.RandomUtil;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * UUID生成器
 */
public class UUIDDirective implements TemplateDirectiveModel {
  @SuppressWarnings("unchecked")
  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
      throws TemplateException, IOException {
    String uuid = RandomUtil.genUUID();
    env.getOut().append(uuid);
  }
}
