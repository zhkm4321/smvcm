package com.sword.smvcm.users.i;

import java.util.List;

import com.sword.smvcm.users.pojo.TbRole;
import com.sword.smvcm.users.pojo.TbRolePermission;
import com.sword.smvcm.users.pojo.TbUser;

public interface UserService {
  public TbUser findUserById(Integer userId);

  public TbUser findUserByUsername(String username);

  public TbUser findUserByMobile(String mobile);

  public List<TbRolePermission> findUserPermission(TbUser user);

  public List<TbRolePermission> findUserPermissionByUsername(String username);

  public List<TbRole> findUserRole(TbUser user);

  public List<TbRole> findUserRoleByUsername(String username);

  /**
   * 密码与用户是否对应
   * 
   * @param userId
   * @param origPwd
   * @return
   */
  public boolean isPasswordValid(Integer userId, String origPwd);

  /**
   * 新密码是否满足复杂度要求
   * 
   * @param newpwd
   * @return
   */
  public int isNewPasswordValid(String newpwd);

  public TbUser register(TbUser user) throws Exception;

  public TbUser update(TbUser user);

  public TbUser saveOrUpdate(TbUser user);

  public TbUser delete(TbUser user);
}
