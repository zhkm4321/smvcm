package com.sword.smvcm.wx.menu.pojo;

import java.io.Serializable;

public class TbMenu implements Serializable {

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column tb_menu.id
   * @mbg.generated
   */
  private Integer id;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column tb_menu.pid
   * @mbg.generated
   */
  private Integer pid;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column tb_menu.menu_name
   * @mbg.generated
   */
  private String menuName;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column tb_menu.type
   * @mbg.generated
   */
  private String type;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column tb_menu.url
   * @mbg.generated
   */
  private String url;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column tb_menu.is_leaf
   * @mbg.generated
   */
  private Integer isLeaf;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column tb_menu.valid
   * @mbg.generated
   */
  private Integer valid;
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database table tb_menu
   * @mbg.generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column tb_menu.id
   * @return  the value of tb_menu.id
   * @mbg.generated
   */
  public Integer getId() {
    return id;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column tb_menu.id
   * @param id  the value for tb_menu.id
   * @mbg.generated
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column tb_menu.pid
   * @return  the value of tb_menu.pid
   * @mbg.generated
   */
  public Integer getPid() {
    return pid;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column tb_menu.pid
   * @param pid  the value for tb_menu.pid
   * @mbg.generated
   */
  public void setPid(Integer pid) {
    this.pid = pid;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column tb_menu.menu_name
   * @return  the value of tb_menu.menu_name
   * @mbg.generated
   */
  public String getMenuName() {
    return menuName;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column tb_menu.menu_name
   * @param menuName  the value for tb_menu.menu_name
   * @mbg.generated
   */
  public void setMenuName(String menuName) {
    this.menuName = menuName == null ? null : menuName.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column tb_menu.type
   * @return  the value of tb_menu.type
   * @mbg.generated
   */
  public String getType() {
    return type;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column tb_menu.type
   * @param type  the value for tb_menu.type
   * @mbg.generated
   */
  public void setType(String type) {
    this.type = type == null ? null : type.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column tb_menu.url
   * @return  the value of tb_menu.url
   * @mbg.generated
   */
  public String getUrl() {
    return url;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column tb_menu.url
   * @param url  the value for tb_menu.url
   * @mbg.generated
   */
  public void setUrl(String url) {
    this.url = url == null ? null : url.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column tb_menu.is_leaf
   * @return  the value of tb_menu.is_leaf
   * @mbg.generated
   */
  public Integer getIsLeaf() {
    return isLeaf;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column tb_menu.is_leaf
   * @param isLeaf  the value for tb_menu.is_leaf
   * @mbg.generated
   */
  public void setIsLeaf(Integer isLeaf) {
    this.isLeaf = isLeaf;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column tb_menu.valid
   * @return  the value of tb_menu.valid
   * @mbg.generated
   */
  public Integer getValid() {
    return valid;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column tb_menu.valid
   * @param valid  the value for tb_menu.valid
   * @mbg.generated
   */
  public void setValid(Integer valid) {
    this.valid = valid;
  }
}