package com.sword.smvcm.wx.menu.i;

import java.util.List;

import com.sword.smvcm.wx.menu.pojo.TbMenu;

public interface MenuService {

  public TbMenu save(TbMenu menu);

  public TbMenu update(TbMenu menu);

  public List<TbMenu> getRootMenuList();

  public List<TbMenu> getMenuListByPId(Integer pid);

  public TbMenu findById(Integer id);

  public int deleteById(Integer id);

}
