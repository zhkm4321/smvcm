package com.sword.smvcm.common.context;

import org.springframework.beans.factory.annotation.Autowired;

import com.sword.smvcm.service.jedis.JedisClient;
import com.sword.smvcm.utils.SerializeUtils;

public class RedisMessage implements MessageService {

  @Autowired
  JedisClient jedisClient;

  private String PREFIX = "MESSAGE_REDIS_";

  @Override
  public void set(String key, MessageInfo value) {
    jedisClient.set(SerializeUtils.serialize(PREFIX + key), SerializeUtils.serialize(value));
  }

  @Override
  public MessageInfo get(String key) {
    byte[] k = SerializeUtils.serialize(PREFIX + key);
    byte[] rawValue = jedisClient.get(k);
    jedisClient.del(k);
    return (MessageInfo) SerializeUtils.deserialize(rawValue);
  }
}
