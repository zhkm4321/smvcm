package com.sword.smvcm.exception;

/**
 * 
 * @author zhenghang E-mail: zhenghang@unitedstone.net
 * @version 创建时间：2017年1月12日 下午1:16:36
 */
public class AjaxException extends SmvcmException {

  private String code;

  private String message;

  public AjaxException(String code, String message) {
    super(code + ":" + message);
    this.message = message;
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
