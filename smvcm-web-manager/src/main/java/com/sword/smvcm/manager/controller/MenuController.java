package com.sword.smvcm.manager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sword.smvcm.manager.constans.BaseConstans;
import com.sword.smvcm.manager.utils.TplPathUtils;
import com.sword.smvcm.wx.menu.i.MenuService;
import com.sword.smvcm.wx.menu.pojo.TbMenu;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.mp.api.WxMpService;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {

  private static Logger log = LoggerFactory.getLogger(MenuController.class);

  @Autowired
  private WxMpService wxMpSvc;

  @Autowired
  private MenuService menuSvc;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String listmenu(Integer pid, ModelMap model) {
    List<TbMenu> list = null;
    if (pid == null) {
      list = menuSvc.getRootMenuList();
    }
    else {
      list = menuSvc.getMenuListByPId(pid);
    }
    model.put("menus", list);
    model.put("pid", pid);
    model.put(BaseConstans.POSITION, "menu");
    return TplPathUtils.getBackstageTpl("/menu/list");
  }

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public String getAddMenu(Integer pid, ModelMap model) {
    List<TbMenu> list = menuSvc.getRootMenuList();
    model.put("list", list);
    model.put("pid", pid);
    model.put(BaseConstans.POSITION, "menu");
    return TplPathUtils.getBackstageTpl("/menu/add");
  }

  @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
  public String postSaveOrUpdateMenu(@ModelAttribute TbMenu menu, ModelMap model) {
    if (menu.getValid() == null) {
      menu.setValid(0);
    }
    if (menu.getIsLeaf() == null) {
      menu.setIsLeaf(0);
    }
    if (menu.getId() == null) {
      menuSvc.save(menu);
    }
    else {
      menuSvc.update(menu);
    }
    model.put(BaseConstans.POSITION, "menu");
    model.put("message", "保存成功");
    return listmenu(menu.getPid(), model);
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public String getDeleteMenu(Integer id, Integer pid, ModelMap model) {
    menuSvc.deleteById(id);
    model.put(BaseConstans.POSITION, "menu");
    model.put("message", "删除成功");
    return listmenu(pid, model);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public String getEditMenu(Integer pid, Integer id, ModelMap model) {
    TbMenu menu = menuSvc.findById(id);
    model.put("menu", menu);
    model.put("pid", pid);
    model.put(BaseConstans.POSITION, "menu");
    return TplPathUtils.getBackstageTpl("/menu/edit");
  }

  @RequestMapping(value = "/publish", method = RequestMethod.GET)
  public String menucreate(ModelMap model) {
    List<TbMenu> menuList = menuSvc.getRootMenuList();
    WxMenu menu = new WxMenu();
    for (TbMenu tbMenu : menuList) {
      WxMenuButton button = new WxMenuButton();
      button.setType(tbMenu.getType());
      button.setName(tbMenu.getMenuName());
      button.setUrl(tbMenu.getUrl());
      menu.getButtons().add(button);
      List<TbMenu> subMenu = menuSvc.getMenuListByPId(tbMenu.getId());
      if (!CollectionUtils.isEmpty(subMenu)) {
        for (TbMenu sub : subMenu) {
          WxMenuButton subBtn = new WxMenuButton();
          subBtn.setName(sub.getMenuName());
          subBtn.setType(sub.getType());
          subBtn.setUrl(sub.getUrl());
          button.getSubButtons().add(subBtn);
        }
      }
    }
    model.put("message", "保存成功！");
    try {
      wxMpSvc.getMenuService().menuCreate(menu);
      log.info("【更新微信公众号底部菜单成功】");
      model.put("success", true);
      model.put("message", "修改菜单成功");
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error("【修改微信菜单失败】", e);
      model.put("success", false);
      model.put("message", "修改菜单失败");
    }
    return listmenu(null, model);
  }
}
