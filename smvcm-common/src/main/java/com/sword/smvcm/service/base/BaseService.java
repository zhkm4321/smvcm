package com.sword.smvcm.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sword.smvcm.service.IService;

import tk.mybatis.mapper.common.Mapper;

public abstract class BaseService<T> implements IService<T> {

  @Autowired
  protected Mapper<T> mapper;

  public Mapper<T> getMapper() {
    return mapper;
  }

  public T getById(Object key) {
    return mapper.selectByPrimaryKey(key);
  }

  public int save(T entity) {
    return mapper.insert(entity);
  }

  public int deleteById(Object key) {
    return mapper.deleteByPrimaryKey(key);
  }

  public int updateById(T entity) {
    return mapper.updateByPrimaryKey(entity);
  }

  public int updateNotNullById(T entity) {
    return mapper.updateByPrimaryKeySelective(entity);
  }

  public List<T> selectByExample(Object example) {
    return mapper.selectByExample(example);
  }
}