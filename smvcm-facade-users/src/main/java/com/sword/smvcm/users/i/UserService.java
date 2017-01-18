package com.sword.smvcm.users.i;

import java.util.List;

import com.sword.smvcm.service.IService;
import com.sword.smvcm.users.pojo.TbRole;
import com.sword.smvcm.users.pojo.TbRolePermission;
import com.sword.smvcm.users.pojo.TbUser;

public interface UserService extends IService<TbUser> {

  public TbUser getByUsername(String username);

  public TbUser getByMobile(String mobile);

  public List<TbUser> selectByUser(TbUser user, int page, int row);

  public List<TbRolePermission> selectUserPermission(TbUser user);

  public List<TbRolePermission> selectUserPermission(String username);

  public List<TbRole> selectUserRole(TbUser user);

  public List<TbRole> selectUserRole(String username);

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
}
