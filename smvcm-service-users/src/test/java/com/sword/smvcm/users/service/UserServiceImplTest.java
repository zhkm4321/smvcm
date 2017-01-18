package com.sword.smvcm.users.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.sword.smvcm.users.i.UserService;
import com.sword.smvcm.users.pojo.TbUser;
import com.sword.smvcm.utils.RandomUtils;

/**
 * Created by Administrator on 2016/6/15.
 */
public class UserServiceImplTest extends SpringBaseTest {

  @Autowired
  UserService userService;

  @Test
  @Rollback(true)
  public void testSave() throws Exception {
    TbUser user = new TbUser();
    String r = RandomUtils.generateString(8);
    String loginName = "admin_" + r;
    user.setUsername(loginName);
    user.setRealname("管理员_" + r);
    user.setPassword("1111");
    int i = userService.save(user);
    assertThat("保存失败", i, is(1));

    TbUser userDataBase = userService.getByUsername(loginName);
    assertNotNull("读数据错误", userDataBase);
  }

  @Test
  public void testFindByLoginName() throws Exception {
    TbUser user = userService.getByUsername("admin");
    assertNotNull("读数据错误", user);
  }
}