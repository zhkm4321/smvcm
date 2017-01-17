package com.sword.smvcm.service;

import java.util.List;

import com.sword.smvcm.pojo.TbConfig;

/**
 * 微信服务端配置服务
 * 
 * @author zhenghang
 * @version 创建时间：2016年12月11日 下午5:31:24
 */
public interface ConfigService {

  public static String GLOBAL_CONFIG_PREFIX = "GLOBAL_CONFIG_";

  public static String GROUP_WXCONFIG = "wxconfig";

  public static String GROUP_USERCONFIG = "userconfig";

  public static String GROUP_SMSCONFIG = "smsconfig";

  public static String GROUP_SYSCONFIG = "sysconfig";

  public static String GROUP_JSAPI = "jsapi";

  public static String WXCONFIG_TOKEN = "token";

  public static String WXCONFIG_APPID = "appID";

  public static String WXCONFIG_SECRET = "secret";

  public static String WXCONFIG_AES_KEY = "aesKey";

  /**
   * 用于支付接口的
   */
  public static String WXCONFIG_PARTNER_KEY = "partnerKey";

  public static String WXCONFIG_PARTNER_ID = "partnerId";

  public static String WXCONFIG_WXSERVER_DOMAIN = "wxserver_domain";

  public static String WXCONFIG_GET_ACCESS_TOKEN_URL = "get_access_token_url";

  public static String WXCONFIG_ACCESS_TOKEN = "access_token";

  public static String WXCONFIG_EXPIRES_IN = "expires_in";

  public static String WXCONFIG_MENU_CREATE_URL = "menu_create_url";

  public static String WXCONFIG_MENU_CONFIG = "menu_config";

  public static String USERCONFIG_SNSAPI_USERINFO_URL = "snsapi_userinfo_url";

  public static String USERCONFIG_GET_USERINFO_URL = "get_userinfo_url";

  public static String USERCONFIG_CHECK_TOKEN_URL = "check_token_url";

  public static String SMSCONFIG_SMS_SEND_URL = "sms_send_url";

  public static String SMSCONFIG_SMS_TIMEOUT = "sms_timeout";

  /**
   * 获取用户access_token的URL
   */
  public static String USERCONFIG_GET_TOKEN_URL = "get_token_url";

  /**
   * 更新用户access_token的URL
   */
  public static String USERCONFIG_REFRESH_TOKEN_URL = "refresh_token_url";

  /**
   * 注册重定向页面
   */
  public static String USERCONFIG_REDIRECT_REG_URL = "redirect_reg_url";

  /**
   * jsapi_ticket临时票据
   */
  public static String WXCONFIG_JSAPI_TICKET = "jsapi_ticket";

  /**
   * 湖获取jsapi_ticket的地址
   */
  public static String WXCONFIG_GET_JSAPI_TICKET_URL = "get_jsapi_ticket_url";

  /**
   * 上传文件路径
   */
  public static String SYSCONFIG_UPLOAD_PATH = "upload_path";

  /**
   * 时间戳
   */
  public static String TIMESTAMP = "timestamp";

  /**
   * 签名
   */
  public static String SIGNATURE = "signature";

  /**
   * 返回字符串
   */
  public static String NONCESTR = "noncestr";

  /**
   * 刷新缓存
   */
  public void reload();

  /**
   * 获取所有数据库中的配置
   */
  public List<TbConfig> listAll();

  /**
   * 根据分组获取配置
   * 
   * @param groupName
   * @return
   */
  public List<TbConfig> getByGroup(String groupName);

  /**
   * 根据分组和key获取配置实体
   * 
   * @param groupWxconfig
   * @param wxconfigExpiresIn
   * @return
   */
  public TbConfig getByGroupAndKey(String group, String key);

  /**
   * 获取配置信息
   * 
   * @param groupName
   * @param key
   * @return
   */
  public String getValue(String groupName, String key);

  /**
   * 更新数据库和缓存中的值
   * 
   * @param groupName
   * @param key
   * @param value
   * @return
   */
  public void setValue(String groupName, String key, String value);

  /**
   * 强制更新数据库和缓存中的值
   * 
   * @param groupName
   * @param key
   * @param value
   * @param forceUpdate
   */
  public void setValue(String groupName, String key, String value, boolean forceUpdate);

}
