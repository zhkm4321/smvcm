package com.sword.smvcm.users.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.sword.smvcm.exception.SmvcmException;
import com.sword.smvcm.shiro.service.PasswordService;
import com.sword.smvcm.users.i.UserService;
import com.sword.smvcm.users.mapper.TbRoleMapper;
import com.sword.smvcm.users.mapper.TbRolePermissionMapper;
import com.sword.smvcm.users.mapper.TbUserMapper;
import com.sword.smvcm.users.mapper.TbUserRoleMapper;
import com.sword.smvcm.users.pojo.TbRole;
import com.sword.smvcm.users.pojo.TbRoleExample;
import com.sword.smvcm.users.pojo.TbRolePermission;
import com.sword.smvcm.users.pojo.TbRolePermissionExample;
import com.sword.smvcm.users.pojo.TbUser;
import com.sword.smvcm.users.pojo.TbUserExample;
import com.sword.smvcm.users.pojo.TbUserRole;
import com.sword.smvcm.users.pojo.TbUserRoleExample;
import com.sword.smvcm.utils.RandomUtils;

@Service("userService")
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
  public TbUser findUserById(Integer userId) {
    return userMapper.selectByPrimaryKey(userId);
  }

  @Override
  public TbUser findUserByUsername(String username) {
    TbUserExample _userexample = new TbUserExample();
    TbUserExample.Criteria criteria = _userexample.createCriteria();
    criteria.andUsernameEqualTo(username);
    List<TbUser> users = userMapper.selectByExample(_userexample);
    if (users.size() == 1) {
      return users.get(0);
    }
    else {
      new SmvcmException("username不唯一:" + _userexample);
    }
    return null;
  }

  @Override
  public TbUser findUserByMobile(String mobile) {
    TbUserExample _userexample = new TbUserExample();
    TbUserExample.Criteria criteria = _userexample.createCriteria();
    criteria.andMobileEqualTo(mobile);
    List<TbUser> users = userMapper.selectByExample(_userexample);
    if (users.size() == 1) {
      return users.get(0);
    }
    else {
      new SmvcmException("mobile不唯一:" + _userexample);
    }
    return null;
  }

  @Override
  public List<TbRolePermission> findUserPermission(TbUser user) {
    List<TbRole> role = findUserRole(user);
    if (CollectionUtils.isEmpty(role)) {
      return null;
    }
    List<Integer> roleIds = new ArrayList<Integer>();
    for (TbRole tbRole : role) {
      roleIds.add(tbRole.getId());
    }
    TbRolePermissionExample example = new TbRolePermissionExample();
    TbRolePermissionExample.Criteria criteria = example.createCriteria();
    criteria.andRoleIdIn(roleIds);
    return permissionMapper.selectByExample(example);
  }

  @Override
  public List<TbRolePermission> findUserPermissionByUsername(String username) {
    TbUser user = findUserByUsername(username);
    return findUserPermission(user);
  }

  @Override
  public List<TbRole> findUserRole(TbUser user) {
    // 先查询关系
    TbUserRoleExample userRoleExample = new TbUserRoleExample();
    TbUserRoleExample.Criteria userRoleCriteria = userRoleExample.createCriteria();
    userRoleCriteria.andUserIdEqualTo(user.getId());
    List<TbUserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
    if (CollectionUtils.isEmpty(userRoles)) {
      return null;
    }
    List<Integer> roleIds = new ArrayList<Integer>();
    for (TbUserRole tbUserRole : userRoles) {
      roleIds.add(tbUserRole.getRoleId());
    }
    // 根据关系查询role
    TbRoleExample roleExample = new TbRoleExample();
    TbRoleExample.Criteria roleCriteria = roleExample.createCriteria();
    roleCriteria.andIdIn(roleIds);
    return roleMapper.selectByExample(roleExample);
  }

  @Override
  public List<TbRole> findUserRoleByUsername(String username) {
    TbUser user = findUserByUsername(username);
    return findUserRole(user);
  }

  @Override
  public boolean isPasswordValid(Integer userId, String origPwd) {
    TbUser user = userMapper.selectByPrimaryKey(userId);
    String dbPwd = user.getPassword();
    String newPwd = passwordService.encryptPassword(origPwd, user.getSalt());
    if (dbPwd.equals(newPwd)) {
      return true;
    }
    return false;
  }

  @Override
  public int isNewPasswordValid(String newpwd) {
    // 复杂（同时包含数字，字母，特殊符号）
    String level3 = "^^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*_-]+$)(?![a-zA-z\\d]+$)(?![a-zA-z!@#$%^&*_-]+$)(?![\\d!@#$%^&*_-]+$)[a-zA-Z\\d!@#$%^&*_-]+$";
    // 中级（包含字母和数字）
    String level2 = "^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*]+$)[a-zA-Z\\d!@#$%^&*]+$";
    // 简单（只包含数字或字母）
    String level1 = "^(?:\\d+|[a-zA-Z]+|[!@#$%^&*]+)$";

    if (newpwd.matches(level3)) {
      return 3;
    }
    else if (newpwd.matches(level2)) {
      return 2;
    }
    else if (newpwd.matches(level1)) {
      return 1;
    }
    else {
      return 0;
    }
  }

  @Override
  public TbUser register(TbUser user) throws Exception {
    if (StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getUsername())) {
      throw new Exception("注册失败，用户名或密码不能为空");
    }

    TbUser _user = userMapper.selectByPrimaryKey(user.getId());
    if (_user != null) {
      throw new Exception("用户已存在");
    }
    user.setCreateTime(new Date());
    user = passwordUser(user);
    userMapper.insert(user);
    return user;
  }

  @Override
  public TbUser update(TbUser user) {
    userMapper.updateByPrimaryKeySelective(passwordUser(user));
    return findUserById(user.getId());
  }

  @Override
  public TbUser saveOrUpdate(TbUser user) {
    if (user.getId() == null) {
      userMapper.insert(user);
    }
    else {
      userMapper.updateByPrimaryKey(user);
    }
    return user;
  }

  @Override
  public TbUser delete(TbUser user) {
    if (user.getId() != null) {
      userMapper.deleteByPrimaryKey(user.getId());
    }
    return user;
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