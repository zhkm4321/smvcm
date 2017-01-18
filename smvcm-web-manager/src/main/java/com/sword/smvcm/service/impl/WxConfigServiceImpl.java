package com.sword.smvcm.service.impl;

import static com.sword.smvcm.config.i.IConfigService.GROUP_WXCONFIG;
import static com.sword.smvcm.config.i.IConfigService.WXCONFIG_AES_KEY;
import static com.sword.smvcm.config.i.IConfigService.WXCONFIG_APPID;
import static com.sword.smvcm.config.i.IConfigService.WXCONFIG_PARTNER_ID;
import static com.sword.smvcm.config.i.IConfigService.WXCONFIG_PARTNER_KEY;
import static com.sword.smvcm.config.i.IConfigService.WXCONFIG_SECRET;
import static com.sword.smvcm.config.i.IConfigService.WXCONFIG_TOKEN;

import com.sword.smvcm.config.i.IConfigService;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;

public class WxConfigServiceImpl extends WxMpInMemoryConfigStorage {

  private IConfigService configSvc;

  public void setConfigSvc(IConfigService configSvc) {
    this.configSvc = configSvc;
  }

  /**
   * 从数据库中加载配置信息
   */
  public void init() {
    this.setAppId(configSvc.getValue(GROUP_WXCONFIG, WXCONFIG_APPID));
    this.setSecret(configSvc.getValue(GROUP_WXCONFIG, WXCONFIG_SECRET));
    this.setToken(configSvc.getValue(GROUP_WXCONFIG, WXCONFIG_TOKEN));
    this.setAesKey(configSvc.getValue(GROUP_WXCONFIG, WXCONFIG_AES_KEY));
    this.setPartnerId(configSvc.getValue(GROUP_WXCONFIG, WXCONFIG_PARTNER_ID));
    this.setPartnerKey(configSvc.getValue(GROUP_WXCONFIG, WXCONFIG_PARTNER_KEY));
  }
}
