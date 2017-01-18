package com.sword.smvcm.wx.menu.pojo;

import javax.persistence.*;

@Table(name = "tb_menu")
public class TbMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父菜单ID
     */
    private Integer pid;

    @Column(name = "menu_name")
    private String menuName;

    private String type;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 是否末级菜单
     */
    @Column(name = "is_leaf")
    private Integer isLeaf;

    /**
     * 是否有效的
     */
    private Integer valid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父菜单ID
     *
     * @return pid - 父菜单ID
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父菜单ID
     *
     * @param pid 父菜单ID
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return menu_name
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取链接地址
     *
     * @return url - 链接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接地址
     *
     * @param url 链接地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取是否末级菜单
     *
     * @return is_leaf - 是否末级菜单
     */
    public Integer getIsLeaf() {
        return isLeaf;
    }

    /**
     * 设置是否末级菜单
     *
     * @param isLeaf 是否末级菜单
     */
    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * 获取是否有效的
     *
     * @return valid - 是否有效的
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * 设置是否有效的
     *
     * @param valid 是否有效的
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }
}