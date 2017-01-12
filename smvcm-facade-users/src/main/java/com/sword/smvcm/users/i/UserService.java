package com.sword.smvcm.users.i;

import java.util.List;

import com.sword.smvcm.users.pojo.TbRole;
import com.sword.smvcm.users.pojo.TbUser;

public interface UserService {
  /**
   * 添加用户
   * 
   * @param user
   * @return
   */
  int save(TbUser user);

  int updateByPrimaryKeySelective(TbUser user);

  TbUser findOne(Integer userId);

  TbUser findByUserName(String loginName);

  int delete(Integer userId);

  void updateLoginInfo(TbUser user, String ip);

  List<TbRole> findRoleByUserId(Integer userId);

  int updateByPrimaryKey(TbUser user);

  TbUser selectByPrimaryKey(Integer userId);

  int insert(TbUser user);

}
