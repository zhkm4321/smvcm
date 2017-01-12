package com.sword.smvcm.shiro.tag;

import java.io.IOException;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.TemplateException;

/**
 * 
 * @author zhenghang E-mail: zhenghang@unitedstone.net
 * @version 创建时间：2017年1月12日 下午4:22:21
 */
public class ShiroTagFreeMarkerConfigurer extends FreeMarkerConfigurer {
  @Override
  public void afterPropertiesSet() throws IOException, TemplateException {
    super.afterPropertiesSet();
    this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
  }

}
