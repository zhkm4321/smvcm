package com.sword.smvcm.manager.constans;

import java.util.Map;

import org.springframework.ui.ModelMap;

public class BaseConstans {

  public static final boolean SUCCESS = true;

  public static final boolean FAILE = false;

  public static final String FLAG = "success";

  public static final String MSG = "message";

  public static final String DATA = "data";

  public static final String CTX_PATH = "cp";

  /**
   * 前台资源路径s
   */
  public static final String RES = "res";

  /**
   * 后台资源路径s
   */
  public static final String SYSRES = "sysres";

  public static final String START_TIME = "stime";

  /**
   * 当前登录用户存放在model中的key
   */
  public static final String USER_KEY = "user";

  public static final String PERMISSION_KEY = "_permission_key";

  /**
   * 存放在session中的用户短信验证码
   */
  public static final String USER_SMS_KEY = "_user_sms_key";

  /**
   * 前台模板路径
   */
  public static final String FRONT_TPL_DIR = "/front";

  /**
   * 后台模板路径
   */
  public static final String BACKSTAGE_TPL_DIR = "/admin";

  /**
   * 当前位置
   */
  public static final String POSITION = "position";

  public static void wrapError(String message, ModelMap map) {
    map.put(FLAG, FAILE);
    map.put(MSG, message);
  }

  public static void wrapError(String message, Map map) {
    map.put(FLAG, FAILE);
    map.put(MSG, message);
  }

  public static void wrapSuccess(Object data, ModelMap map) {
    map.put(FLAG, SUCCESS);
    map.put(DATA, data);
  }

  public static void wrapSuccess(Object data, Map map) {
    map.put(FLAG, SUCCESS);
    map.put(DATA, data);
  }

}