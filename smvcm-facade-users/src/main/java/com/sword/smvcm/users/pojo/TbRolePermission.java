package com.sword.smvcm.users.pojo;

import javax.persistence.*;

@Table(name = "tb_role_permission")
public class TbRolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 权限字
     */
    private String value;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 关联角色ID
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 是否有效
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
     * 获取权限字
     *
     * @return value - 权限字
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置权限字
     *
     * @param value 权限字
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取权限名称
     *
     * @return name - 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限名称
     *
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取关联角色ID
     *
     * @return role_id - 关联角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置关联角色ID
     *
     * @param roleId 关联角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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