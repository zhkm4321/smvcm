package com.sword.smvcm.users.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user")
public class TbUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 账号(手机号或邮箱)
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 昵称
     */
    private String realname;

    private String password;

    /**
     * 混淆码
     */
    private String salt;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 本次登录IP
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 上次登录的IP
     */
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 上次登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 注册时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 登录次数
     */
    @Column(name = "login_count")
    private Long loginCount;

    /**
     * 用户类型0admin,1member,2anonymous
     */
    private Integer type;

    /**
     * 是否有效用户
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
     * 获取账号(手机号或邮箱)
     *
     * @return username - 账号(手机号或邮箱)
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置账号(手机号或邮箱)
     *
     * @param username 账号(手机号或邮箱)
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取昵称
     *
     * @return realname - 昵称
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置昵称
     *
     * @param realname 昵称
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取混淆码
     *
     * @return salt - 混淆码
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置混淆码
     *
     * @param salt 混淆码
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取本次登录IP
     *
     * @return login_ip - 本次登录IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 设置本次登录IP
     *
     * @param loginIp 本次登录IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * 获取登录时间
     *
     * @return login_time - 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登录时间
     *
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取上次登录的IP
     *
     * @return last_login_ip - 上次登录的IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置上次登录的IP
     *
     * @param lastLoginIp 上次登录的IP
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 获取上次登录时间
     *
     * @return last_login_time - 上次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置上次登录时间
     *
     * @param lastLoginTime 上次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取注册时间
     *
     * @return create_time - 注册时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置注册时间
     *
     * @param createTime 注册时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取登录次数
     *
     * @return login_count - 登录次数
     */
    public Long getLoginCount() {
        return loginCount;
    }

    /**
     * 设置登录次数
     *
     * @param loginCount 登录次数
     */
    public void setLoginCount(Long loginCount) {
        this.loginCount = loginCount;
    }

    /**
     * 获取用户类型0admin,1member,2anonymous
     *
     * @return type - 用户类型0admin,1member,2anonymous
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置用户类型0admin,1member,2anonymous
     *
     * @param type 用户类型0admin,1member,2anonymous
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取是否有效用户
     *
     * @return valid - 是否有效用户
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * 设置是否有效用户
     *
     * @param valid 是否有效用户
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }
}