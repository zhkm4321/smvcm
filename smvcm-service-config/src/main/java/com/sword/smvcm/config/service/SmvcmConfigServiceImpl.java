package com.sword.smvcm.config.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sword.smvcm.config.i.IConfigService;
import com.sword.smvcm.config.mapper.TbConfigMapper;
import com.sword.smvcm.config.pojo.TbConfig;
import com.sword.smvcm.config.pojo.TbConfigExample;
import com.sword.smvcm.service.jedis.JedisClient;
import com.sword.smvcm.utils.StringUtils;

@Service("smvcmConfigService")
public class SmvcmConfigServiceImpl implements IConfigService {

  private static Logger log = LoggerFactory.getLogger(SmvcmConfigServiceImpl.class);

  private TbConfigMapper configMapper;

  @Autowired
  @Qualifier("jedisClient")
  JedisClient jedisClient;

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.configMapper = beanFactory.getBean("tbConfigMapper", TbConfigMapper.class);
  }

  @PostConstruct
  public void initCache() {
    log.info("【缓存服务器配置开始】");
    List<TbConfig> list = listAll();
    if (!CollectionUtils.isEmpty(list)) {
      for (TbConfig tbConfig : list) {
        jedisClient.hset(GLOBAL_CONFIG_PREFIX + tbConfig.getConfigGroup(), tbConfig.getConfigKey(),
            tbConfig.getConfigValue());
      }
    }
    log.info("【缓存服务器配置完成】");
  }

  @Override
  public List<TbConfig> listAll() {
    TbConfigExample example = new TbConfigExample();
    return configMapper.selectByExample(example);
  }

  @Override
  public void reload() {
    Set keys = jedisClient.keys(GLOBAL_CONFIG_PREFIX + "*");
    System.out.println(keys.toString());
    initCache();
    log.info("【缓存服务器配置reload】");
  }

  @Override
  public List<TbConfig> getByGroup(String groupName) {
    TbConfigExample example = new TbConfigExample();
    TbConfigExample.Criteria criteria = example.createCriteria();
    criteria.andConfigGroupEqualTo(groupName);
    return configMapper.selectByExample(example);
  }

  @Override
  public TbConfig getByGroupAndKey(String groupName, String key) {
    TbConfigExample example = new TbConfigExample();
    TbConfigExample.Criteria criteria = example.createCriteria();
    criteria.andConfigGroupEqualTo(groupName);
    criteria.andConfigKeyEqualTo(key);
    List<TbConfig> beanList = configMapper.selectByExample(example);
    if (!CollectionUtils.isEmpty(beanList)) {
      return beanList.get(0);
    }
    return null;
  }

  @Override
  public String getValue(String groupName, String key) {
    String value = jedisClient.hget(GLOBAL_CONFIG_PREFIX + groupName, key);
    if (StringUtils.isNullOrEmpty(value)) {// 降权
      value = getValueFromDB(groupName, key);
      if (!StringUtils.isNullOrEmpty(value)) {
        jedisClient.hset(GLOBAL_CONFIG_PREFIX + groupName, key, value);
      }
    }
    return value;
  }

  public String getValueFromDB(String groupName, String key) {
    TbConfig config = getByGroupAndKey(groupName, key);
    return config.getConfigValue();
  }

  @Override
  public void setValue(String groupName, String key, String value) {
    setValue(groupName, key, value, false);
  }

  @Override
  public void setValue(String groupName, String key, String value, boolean force2DB) {
    if (force2DB) {
      saveOrUpdate(groupName, key, value);
    }
    else {
      TbConfig config = getByGroupAndKey(groupName, key);
      if (!config.getConfigValue().equals(value)) {
        saveOrUpdate(groupName, key, value);
      }
    }
    jedisClient.hset(GLOBAL_CONFIG_PREFIX + groupName, key, value);
  }

  private void saveOrUpdate(String groupName, String key, String value) {
    TbConfig config = getByGroupAndKey(groupName, key);
    if (null != config) {// 更新缓存
      config.setConfigValue(value);
      config.setUpdateTime(new Date());
      TbConfigExample example = new TbConfigExample();
      TbConfigExample.Criteria criteria = example.createCriteria();
      criteria.andConfigGroupEqualTo(groupName);
      criteria.andConfigKeyEqualTo(key);
      configMapper.updateByExample(config, example);
      log.info("更新系统配置数据【{},{},{}】 更新时间：{}", new Object[] { config.getConfigGroup(), config.getConfigKey(),
          config.getConfigValue(), config.getUpdateTime() });
    }
    else {// 新建缓存
      config = new TbConfig();
      config.setConfigGroup(groupName);
      config.setConfigKey(key);
      config.setConfigValue(value);
      config.setUpdateTime(new Date());
      configMapper.insert(config);
      log.info("添加新的系统配置数据【{},{},{}】添加时间：{}", new Object[] { config.getConfigGroup(), config.getConfigKey(),
          config.getConfigValue(), config.getUpdateTime() });
    }
    jedisClient.hset(GLOBAL_CONFIG_PREFIX + groupName, key, value);
  }

}
