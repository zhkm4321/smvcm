package com.sword.smvcm.users.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_member")
public class TbMember {
    /**
     * 会员id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 微信平台联合ID
     */
    @Column(name = "union_id")
    private String unionId;

    /**
     * 开发平台ID
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 会员头像
     */
    private String avatar;

    /**
     * 会员性别
     */
    private Boolean sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 会员邮箱
     */
    private String email;

    /**
     * qq
     */
    private String qq;

    /**
     * 阿里旺旺
     */
    private String ww;

    /**
     * 会员注册时间
     */
    private Date time;

    /**
     * qq互联id
     */
    private String qqopenid;

    /**
     * 会员积分
     */
    private Integer points;

    /**
     * 预存款可用金额
     */
    @Column(name = "available_predeposit")
    private BigDecimal availablePredeposit;

    /**
     * 预存款冻结金额
     */
    @Column(name = "freeze_predeposit")
    private BigDecimal freezePredeposit;

    /**
     * 是否允许举报(1可以/2不可以)
     */
    @Column(name = "inform_allow")
    private Boolean informAllow;

    /**
     * 会员是否有购买权限 1为开启 0为关闭
     */
    @Column(name = "is_buy")
    private Boolean isBuy;

    /**
     * 会员是否有咨询和发送站内信的权限 1为开启 0为关闭
     */
    @Column(name = "is_allowtalk")
    private Boolean isAllowtalk;

    /**
     * 会员的开启状态 1为开启 0为关闭
     */
    @Column(name = "is_vip")
    private Boolean isVip;

    /**
     * 地区ID
     */
    @Column(name = "area_d")
    private Integer areaD;

    /**
     * 城市ID
     */
    @Column(name = "city_id")
    private Integer cityId;

    /**
     * 省份ID
     */
    @Column(name = "province_id")
    private Integer provinceId;

    /**
     * 地区内容
     */
    private String areainfo;

    /**
     * 隐私设定
     */
    private String privacy;

    /**
     * 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     */
    @Column(name = "access_token")
    private String accessToken;

    /**
     * access_token接口调用凭证超时时间，单位（秒）
     */
    @Column(name = "expires_in")
    private Integer expiresIn;

    /**
     * 用户刷新access_token
     */
    @Column(name = "refresh_token")
    private String refreshToken;

    /**
     * 用户授权的作用域，使用逗号（,）分隔
     */
    private String scope;

    /**
     * qq账号相关信息
     */
    private String qqinfo;

    /**
     * 获取会员id
     *
     * @return id - 会员id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置会员id
     *
     * @param id 会员id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取微信平台联合ID
     *
     * @return union_id - 微信平台联合ID
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 设置微信平台联合ID
     *
     * @param unionId 微信平台联合ID
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * 获取开发平台ID
     *
     * @return open_id - 开发平台ID
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置开发平台ID
     *
     * @param openId 开发平台ID
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取真实姓名
     *
     * @return realname - 真实姓名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置真实姓名
     *
     * @param realname 真实姓名
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 获取会员头像
     *
     * @return avatar - 会员头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置会员头像
     *
     * @param avatar 会员头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取会员性别
     *
     * @return sex - 会员性别
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * 设置会员性别
     *
     * @param sex 会员性别
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取会员邮箱
     *
     * @return email - 会员邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置会员邮箱
     *
     * @param email 会员邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取qq
     *
     * @return qq - qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置qq
     *
     * @param qq qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取阿里旺旺
     *
     * @return ww - 阿里旺旺
     */
    public String getWw() {
        return ww;
    }

    /**
     * 设置阿里旺旺
     *
     * @param ww 阿里旺旺
     */
    public void setWw(String ww) {
        this.ww = ww;
    }

    /**
     * 获取会员注册时间
     *
     * @return time - 会员注册时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置会员注册时间
     *
     * @param time 会员注册时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取qq互联id
     *
     * @return qqopenid - qq互联id
     */
    public String getQqopenid() {
        return qqopenid;
    }

    /**
     * 设置qq互联id
     *
     * @param qqopenid qq互联id
     */
    public void setQqopenid(String qqopenid) {
        this.qqopenid = qqopenid;
    }

    /**
     * 获取会员积分
     *
     * @return points - 会员积分
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * 设置会员积分
     *
     * @param points 会员积分
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * 获取预存款可用金额
     *
     * @return available_predeposit - 预存款可用金额
     */
    public BigDecimal getAvailablePredeposit() {
        return availablePredeposit;
    }

    /**
     * 设置预存款可用金额
     *
     * @param availablePredeposit 预存款可用金额
     */
    public void setAvailablePredeposit(BigDecimal availablePredeposit) {
        this.availablePredeposit = availablePredeposit;
    }

    /**
     * 获取预存款冻结金额
     *
     * @return freeze_predeposit - 预存款冻结金额
     */
    public BigDecimal getFreezePredeposit() {
        return freezePredeposit;
    }

    /**
     * 设置预存款冻结金额
     *
     * @param freezePredeposit 预存款冻结金额
     */
    public void setFreezePredeposit(BigDecimal freezePredeposit) {
        this.freezePredeposit = freezePredeposit;
    }

    /**
     * 获取是否允许举报(1可以/2不可以)
     *
     * @return inform_allow - 是否允许举报(1可以/2不可以)
     */
    public Boolean getInformAllow() {
        return informAllow;
    }

    /**
     * 设置是否允许举报(1可以/2不可以)
     *
     * @param informAllow 是否允许举报(1可以/2不可以)
     */
    public void setInformAllow(Boolean informAllow) {
        this.informAllow = informAllow;
    }

    /**
     * 获取会员是否有购买权限 1为开启 0为关闭
     *
     * @return is_buy - 会员是否有购买权限 1为开启 0为关闭
     */
    public Boolean getIsBuy() {
        return isBuy;
    }

    /**
     * 设置会员是否有购买权限 1为开启 0为关闭
     *
     * @param isBuy 会员是否有购买权限 1为开启 0为关闭
     */
    public void setIsBuy(Boolean isBuy) {
        this.isBuy = isBuy;
    }

    /**
     * 获取会员是否有咨询和发送站内信的权限 1为开启 0为关闭
     *
     * @return is_allowtalk - 会员是否有咨询和发送站内信的权限 1为开启 0为关闭
     */
    public Boolean getIsAllowtalk() {
        return isAllowtalk;
    }

    /**
     * 设置会员是否有咨询和发送站内信的权限 1为开启 0为关闭
     *
     * @param isAllowtalk 会员是否有咨询和发送站内信的权限 1为开启 0为关闭
     */
    public void setIsAllowtalk(Boolean isAllowtalk) {
        this.isAllowtalk = isAllowtalk;
    }

    /**
     * 获取会员的开启状态 1为开启 0为关闭
     *
     * @return is_vip - 会员的开启状态 1为开启 0为关闭
     */
    public Boolean getIsVip() {
        return isVip;
    }

    /**
     * 设置会员的开启状态 1为开启 0为关闭
     *
     * @param isVip 会员的开启状态 1为开启 0为关闭
     */
    public void setIsVip(Boolean isVip) {
        this.isVip = isVip;
    }

    /**
     * 获取地区ID
     *
     * @return area_d - 地区ID
     */
    public Integer getAreaD() {
        return areaD;
    }

    /**
     * 设置地区ID
     *
     * @param areaD 地区ID
     */
    public void setAreaD(Integer areaD) {
        this.areaD = areaD;
    }

    /**
     * 获取城市ID
     *
     * @return city_id - 城市ID
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 设置城市ID
     *
     * @param cityId 城市ID
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取省份ID
     *
     * @return province_id - 省份ID
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省份ID
     *
     * @param provinceId 省份ID
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取地区内容
     *
     * @return areainfo - 地区内容
     */
    public String getAreainfo() {
        return areainfo;
    }

    /**
     * 设置地区内容
     *
     * @param areainfo 地区内容
     */
    public void setAreainfo(String areainfo) {
        this.areainfo = areainfo;
    }

    /**
     * 获取隐私设定
     *
     * @return privacy - 隐私设定
     */
    public String getPrivacy() {
        return privacy;
    }

    /**
     * 设置隐私设定
     *
     * @param privacy 隐私设定
     */
    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    /**
     * 获取网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     *
     * @return access_token - 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 设置网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     *
     * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * 获取access_token接口调用凭证超时时间，单位（秒）
     *
     * @return expires_in - access_token接口调用凭证超时时间，单位（秒）
     */
    public Integer getExpiresIn() {
        return expiresIn;
    }

    /**
     * 设置access_token接口调用凭证超时时间，单位（秒）
     *
     * @param expiresIn access_token接口调用凭证超时时间，单位（秒）
     */
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * 获取用户刷新access_token
     *
     * @return refresh_token - 用户刷新access_token
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * 设置用户刷新access_token
     *
     * @param refreshToken 用户刷新access_token
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * 获取用户授权的作用域，使用逗号（,）分隔
     *
     * @return scope - 用户授权的作用域，使用逗号（,）分隔
     */
    public String getScope() {
        return scope;
    }

    /**
     * 设置用户授权的作用域，使用逗号（,）分隔
     *
     * @param scope 用户授权的作用域，使用逗号（,）分隔
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * 获取qq账号相关信息
     *
     * @return qqinfo - qq账号相关信息
     */
    public String getQqinfo() {
        return qqinfo;
    }

    /**
     * 设置qq账号相关信息
     *
     * @param qqinfo qq账号相关信息
     */
    public void setQqinfo(String qqinfo) {
        this.qqinfo = qqinfo;
    }
}