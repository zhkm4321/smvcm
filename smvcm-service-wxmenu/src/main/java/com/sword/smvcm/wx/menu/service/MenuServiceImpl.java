package com.sword.smvcm.wx.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sword.smvcm.wx.menu.i.MenuService;
import com.sword.smvcm.wx.menu.mapper.TbMenuMapper;
import com.sword.smvcm.wx.menu.pojo.TbMenu;
import com.sword.smvcm.wx.menu.pojo.TbMenuExample;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
  @Autowired
  private TbMenuMapper menuMapper;

  @Override
  public List<TbMenu> getRootMenuList() {
    TbMenuExample example = new TbMenuExample();
    TbMenuExample.Criteria criteria = example.createCriteria();
    criteria.andPidIsNull();
    List<TbMenu> list = menuMapper.selectByExample(example);
    return list;
  }

  @Override
  public List<TbMenu> getMenuListByPId(Integer pid) {
    TbMenuExample example = new TbMenuExample();
    TbMenuExample.Criteria criteria = example.createCriteria();
    criteria.andPidEqualTo(pid);
    List<TbMenu> list = menuMapper.selectByExample(example);
    return list;
  }

  @Override
  public TbMenu save(TbMenu menu) {
    menuMapper.insert(menu);
    return menu;
  }

  @Override
  public TbMenu update(TbMenu menu) {
    menuMapper.updateByPrimaryKey(menu);
    return menu;
  }

  @Override
  public TbMenu findById(Integer id) {
    TbMenu result = menuMapper.selectByPrimaryKey(id);
    return result;
  }

  @Override
  public int deleteById(Integer id) {
    return menuMapper.deleteByPrimaryKey(id);
  }
}