package com.sword.smvcm.manager.utils;

public class TplPathUtils {
  /**
   * 前台模板路径前缀
   */

  public static String getBackstageTpl(String path) {
    if (!path.startsWith("/")) {
      path = "/" + path;
    }
    return path;
  }
}
