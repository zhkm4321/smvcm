package com.sword.smvcm.shiro.tag;

import freemarker.template.SimpleHash;

/**
 * Shortcut for injecting the tags into Freemarker
 * <p>
 * Usage: cfg.setSharedVeriable("shiro", new ShiroTags());
 * </p>
 * 
 * @author zhenghang E-mail: zhenghang@unitedstone.net
 * @version 创建时间：2017年1月12日 下午4:22:56
 */
public class ShiroTags extends SimpleHash {
  public ShiroTags() {
    put("authenticated", new AuthenticatedTag());
    put("guest", new GuestTag());
    put("hasAnyRoles", new HasAnyRolesTag());
    put("hasPermission", new HasPermissionTag());
    put("hasRole", new HasRoleTag());
    put("lacksPermission", new LacksPermissionTag());
    put("lacksRole", new LacksRoleTag());
    put("notAuthenticated", new NotAuthenticatedTag());
    put("principal", new PrincipalTag());
    put("user", new UserTag());
  }
}