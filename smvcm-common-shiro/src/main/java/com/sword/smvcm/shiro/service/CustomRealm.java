package com.sword.smvcm.shiro.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.sword.smvcm.users.i.UserService;
import com.sword.smvcm.users.pojo.TbRole;
import com.sword.smvcm.users.pojo.TbRolePermission;
import com.sword.smvcm.users.pojo.TbUser;

public class CustomRealm extends AuthorizingRealm {

  UserService userService;

  public UserService getUserService() {
    return userService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  // 设置realm的名称
  @Override
  public void setName(String name) {
    super.setName("customRealm");
  }

  // realm的认证方法，从数据库查询用户信息
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

    // token是用户输入的用户名和密码
    // 第一步从token中取出用户名
    String loginName = (String) token.getPrincipal();

    // 第二步：根据用户输入的userCode从数据库查询
    TbUser user = null;
    try {
      user = userService.getByUsername(loginName);
    }
    catch (Exception e1) {
      e1.printStackTrace();
    }

    if (user == null) {
      return null;
    }

    // 从数据库查询到密码
    String password = user.getPassword();

    // 盐
    String salt = user.getSalt();

    // 如果查询到返回认证信息AuthenticationInfo

    // activeUser就是用户身份信息
    /*
     * ActiveUser activeUser = new ActiveUser();
     * 
     * activeUser.setUserId(user.getId());
     * activeUser.setLoginName(user.getLoginName());
     * activeUser.setUserName(user.getUserName());
     */

    // 将activeUser设置simpleAuthenticationInfo
    SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, password,
        ByteSource.Util.bytes(salt), this.getName());

    return simpleAuthenticationInfo;
  }

  // 用于授权
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    // 从 principals获取主身份信息
    // 将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
    TbUser activeUser = (TbUser) principals.getPrimaryPrincipal();

    // 从数据库获取角色
    List<TbRole> roleList = userService.selectUserRole(activeUser);
    List<TbRolePermission> permissionList = userService.selectUserPermission(activeUser);
    List<String> roles = new ArrayList<String>();
    if (roleList != null) {
      for (TbRole r : roleList) {
        // 将数据库中的权限标签 符放入集合
        roles.add(r.getValue());
      }
    }
    // 根据身份信息获取权限信息
    // 从数据库获取到权限数据

    // 单独定一个集合对象
    List<String> permissions = new ArrayList<String>();
    if (permissionList != null) {
      for (TbRolePermission permission : permissionList) {
        // 将数据库中的权限标签 符放入集合
        permissions.add(permission.getValue());
      }
    }

    // 查到权限数据，返回授权信息(要包括 上边的permissions)
    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
    // 将上边查询到授权信息填充到simpleAuthorizationInfo对象中
    // simpleAuthorizationInfo.addStringPermissions(permissions);
    simpleAuthorizationInfo.addRoles(roles);
    return simpleAuthorizationInfo;
  }

  // 清除缓存
  public void clearCached() {
    PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
    super.clearCache(principals);
  }

}
