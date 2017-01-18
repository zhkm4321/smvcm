package com.sword.smvcm.manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sword.smvcm.manager.constans.BaseConstans;
import com.sword.smvcm.manager.utils.TplPathUtils;
import com.sword.smvcm.users.i.UserService;

import me.chanjar.weixin.mp.api.WxMpService;

@Controller
public class IndexController {

  private static Logger log = LoggerFactory.getLogger(IndexController.class);

  @Autowired
  UserService userService;

  @Autowired
  WxMpService wxMpSvc;

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public String index(HttpServletRequest request, HttpSession session, ModelMap model) {
    model.put(BaseConstans.POSITION, "index");
    return TplPathUtils.getBackstageTpl("index");
  }
}
