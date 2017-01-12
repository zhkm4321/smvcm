package com.sword.smvcm.users.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sword.smvcm.exception.MapperException;
import com.sword.smvcm.exception.SmvcmException;
import com.sword.smvcm.shiro.service.PasswordService;
import com.sword.smvcm.users.i.UserService;
import com.sword.smvcm.users.mapper.TbRoleMapper;
import com.sword.smvcm.users.mapper.TbRolePermissionMapper;
import com.sword.smvcm.users.mapper.TbUserMapper;
import com.sword.smvcm.users.mapper.TbUserRoleMapper;
import com.sword.smvcm.users.pojo.TbRole;
import com.sword.smvcm.users.pojo.TbRoleExample;
import com.sword.smvcm.users.pojo.TbUser;
import com.sword.smvcm.users.pojo.TbUserExample;
import com.sword.smvcm.utils.RandomUtils;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  TbUserMapper userMapper;

  @Autowired
  TbUserRoleMapper userRoleMapper;

  @Autowired
  TbRoleMapper roleMapper;

  @Autowired
  TbRolePermissionMapper permissionMapper;

  @Autowired
  PasswordService passwordService;

  @Override
  public int save(TbUser user) {
    TbUser userDataBase = this.findByUserName(user.getUsername());
    if (userDataBase != null) {
      throw new MapperException("登录名称重复");
    }
    return userMapper.insertSelective(passwordUser(user));
  }

  @Override
  public int updateByPrimaryKeySelective(TbUser user) {
    return userMapper.updateByPrimaryKeySelective(passwordUser(user));
  }

  @Override
  public TbUser findOne(Integer userId) {
    return userMapper.selectByPrimaryKey(userId);
  }

  @Override
  public TbUser findByUserName(String username) {
    TbUserExample _userexample = new TbUserExample();
    TbUserExample.Criteria criteria = _userexample.createCriteria();
    criteria.andUsernameEqualTo(username);
    List<TbUser> users = userMapper.selectByExample(_userexample);
    if (users.size() == 1) {
      return findOne(users.get(0).getId());
    }
    else {
      new SmvcmException("用户名不唯一:" + _userexample);
    }
    return null;
  }

  @Override
  public int delete(Integer userId) {
    return userMapper.deleteByPrimaryKey(userId);
  }

  @Override
  public void updateLoginInfo(TbUser user, String ip) {
    TbUser loginTbUserInfo = new TbUser();
    loginTbUserInfo.setId(user.getId());
    loginTbUserInfo.setLoginCount(user.getLoginCount() + 1);
    loginTbUserInfo.setLoginIp(ip);
    loginTbUserInfo.setLastLoginIp(user.getLoginIp());
    loginTbUserInfo.setLoginTime(new Timestamp(System.currentTimeMillis()));
    loginTbUserInfo.setLastLoginTime(user.getLoginTime());
    userMapper.updateByPrimaryKey(loginTbUserInfo);
  }

  @Override
  public List<TbRole> findRoleByUserId(Integer userId) {
    TbRoleExample _userRoleExample = new TbRoleExample();
    TbRoleExample.Criteria criteria = _userRoleExample.createCriteria();
    criteria.andIdEqualTo(userId);
    return roleMapper.selectByExample(_userRoleExample);
  }

  @Override
  public int updateByPrimaryKey(TbUser user) {
    return userMapper.updateByPrimaryKey(user);
  }

  @Override
  public TbUser selectByPrimaryKey(Integer userId) {
    return userMapper.selectByPrimaryKey(userId);
  }

  @Override
  public int insert(TbUser user) {
    return userMapper.insert(user);
  }

  /**
   * 将密码加密
   * 
   * @param user
   * @return
   */
  private TbUser passwordUser(TbUser user) {

    if (StringUtils.hasText(user.getPassword())) {
      String salt = RandomUtils.generateString(5);
      user.setPassword(passwordService.encryptPassword(user.getPassword(), salt));
      user.setSalt(salt);
    }
    return user;
  }
}