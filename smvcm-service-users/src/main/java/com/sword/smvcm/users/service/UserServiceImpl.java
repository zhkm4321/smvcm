package com.sword.smvcm.users.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.sword.smvcm.exception.SmvcmException;
import com.sword.smvcm.service.base.BaseService;
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

import tk.mybatis.mapper.entity.Example;

@Service("userService")
public class UserServiceImpl extends BaseService<TbUser> implements UserService {

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
  public TbUser getByUsername(String username) {
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
  public TbUser getByMobile(String mobile) {
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
  public List<TbUser> selectByUser(TbUser user, int page, int row) {
    Example example = new Example(TbUser.class);
    Example.Criteria criteria = example.createCriteria();
    if (StringUtil.isNotEmpty(user.getUsername())) {
      criteria.andLike("username", user.getUsername());
    }
    if (StringUtil.isNotEmpty(user.getRealname())) {
      criteria.andLike("realname", user.getRealname());
    }
    if (StringUtil.isNotEmpty(user.getMobile())) {
      criteria.andLike("mobile", user.getMobile());
    }
    if (user.getId() != null) {
      criteria.andEqualTo("id", user.getId());
    }
    // 分页查询
    PageHelper.startPage(page, row);
    return selectByExample(example);
  }

  @Override
  public List<TbRolePermission> selectUserPermission(TbUser user) {
    List<TbRole> role = selectUserRole(user);
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
  public List<TbRolePermission> selectUserPermission(String username) {
    TbUser user = getByUsername(username);
    return selectUserPermission(user);
  }

  @Override
  public List<TbRole> selectUserRole(TbUser user) {
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
  public List<TbRole> selectUserRole(String username) {
    TbUser user = getByUsername(username);
    return selectUserRole(user);
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