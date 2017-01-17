package com.sword.smvcm.manager.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.sword.smvcm.users.pojo.TbUser;

public class UserUtils {
  public static final int CAR_OWNER = 1;

  public static final int TECHNICIAN = 2;

  public static final int REPAIR_SHOP = 3;

  public static final int ADMIN = 0;

  public static final int CUSTOMER_SERVICE = 8;

  /**
   * 获取当前登录用户
   * 
   * @return
   */
  public static TbUser currentUser() {
    Subject subject = SecurityUtils.getSubject();
    Object principal = subject.getPrincipal();
    if (principal != null) {
      if (principal instanceof TbUser)
        return (TbUser) principal;
      else
        return null;
    }
    else {
      return null;
    }
  }

  public static void logout() {
    if (null != SecurityUtils.getSubject()) {
      SecurityUtils.getSubject().logout();
    }
  }
}
