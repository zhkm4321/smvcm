package com.sword.smvcm.manager.utils;

public class TplPathUtils {
  /**
   * 前台模板路径前缀
   */
  public static String FRONT_PREFIX = "/views";

  public static String getBackstageTpl(String path) {
    if (!path.startsWith("/")) {
      path = "/" + path;
    }
    return FRONT_PREFIX + path;
  }
}
