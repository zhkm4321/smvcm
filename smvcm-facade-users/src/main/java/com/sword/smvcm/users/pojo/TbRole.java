package com.sword.smvcm.users.pojo;

import javax.persistence.*;

@Table(name = "tb_role")
public class TbRole {
    /**
     * 角色ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色字
     */
    private String value;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 是否有效
     */
    private Integer valid;

    /**
     * 获取角色ID
     *
     * @return id - 角色ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置角色ID
     *
     * @param id 角色ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色字
     *
     * @return value - 角色字
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置角色字
     *
     * @param value 角色字
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取是否有效
     *
     * @return valid - 是否有效
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * 设置是否有效
     *
     * @param valid 是否有效
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }
}