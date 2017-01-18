package com.sword.smvcm.kaptcha.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;
import com.sword.smvcm.service.jedis.JedisClient;
import com.sword.smvcm.shiro.ShiroConstants;
import com.sword.smvcm.utils.CaptchaUtils;

/**
 * 需要使用验证码的controller需要继承该类
 * 
 * @author zhenghang E-mail: zhenghang@unitedstone.net
 * @version 创建时间：2016年12月1日 下午6:27:33
 */
@Controller
public class KaptchaController {

  private static Properties props = new Properties();

  private static Producer kaptchaProducer = null;

  @Autowired
  private JedisClient jedisClient;

  private static boolean init = false;

  public KaptchaController() {
    if (!KaptchaController.init) {
      ResourceBundle rb = ResourceBundle.getBundle("captcha.config");
      for (Iterator<String> it = rb.keySet().iterator(); it.hasNext();) {
        String key = (String) it.next();
        String value = rb.getString(key);
        KaptchaController.props.put(key, value);
      }

      // Switch off disk based caching.
      ImageIO.setUseCache(false);
      Config config = new Config(KaptchaController.props);
      KaptchaController.kaptchaProducer = config.getProducerImpl();
      ShiroConstants.KAPTCHA_KEY_VALUE = config.getSessionKey();
      String timeoutValue = config.getProperties().getProperty(ShiroConstants.KAPTCHA_TIMEOUT_KEY);
      ShiroConstants.KAPTCHA_TIMEOUT_VALUE = Integer.parseInt(timeoutValue);
      KaptchaController.init = true;
    }
  }

  /**
   * 检查验证码是否正确
   * 
   * @param request
   * @return
   * @throws IOException
   */
  @RequestMapping(value = "/validCaptcha", method = RequestMethod.GET)
  @ResponseBody
  public String validCaptcha(HttpServletRequest request) throws IOException {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("success", CaptchaUtils.validCaptcha(request));
    return JSON.json(map);
  }

  /**
   * map it to the /url/captcha.jpg
   * 
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  @RequestMapping(value = "/captcha", method = RequestMethod.GET)
  public void captcha(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Set standard HTTP/1.1 no-cache headers.
    resp.setHeader("Cache-Control", "no-store, no-cache");

    // return a jpeg
    resp.setContentType("image/jpeg");

    // create the text for the image
    String capText = KaptchaController.kaptchaProducer.createText();

    // create the image with the text
    BufferedImage bi = KaptchaController.kaptchaProducer.createImage(capText);

    ServletOutputStream out = resp.getOutputStream();

    // write the data out
    ImageIO.write(bi, "jpg", out);

    // 将验证码放入缓存中
    jedisClient.set(ShiroConstants.KAPTCHA_KEY_VALUE + req.getSession().getId(), capText,
        ShiroConstants.KAPTCHA_TIMEOUT_VALUE);

  }
}