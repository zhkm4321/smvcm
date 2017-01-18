package com.sword.smvcm.config.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_config")
public class TbConfig {
    /**
     * 配置
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "config_group")
    private String configGroup;

    @Column(name = "config_key")
    private String configKey;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "config_value")
    private String configValue;

    /**
     * 获取配置
     *
     * @return id - 配置
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置配置
     *
     * @param id 配置
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return config_group
     */
    public String getConfigGroup() {
        return configGroup;
    }

    /**
     * @param configGroup
     */
    public void setConfigGroup(String configGroup) {
        this.configGroup = configGroup;
    }

    /**
     * @return config_key
     */
    public String getConfigKey() {
        return configKey;
    }

    /**
     * @param configKey
     */
    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return config_value
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * @param configValue
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
}