package com.cxd.venus.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author YiBuBuHuiTou
 * 自定义配置类
 */
@Component
@PropertySource(value = {"classpath:application-custom.yml"})
@ConfigurationProperties(prefix = "spring.custom")
public class AppDefault {

    private String defaultTenant;

    private int defaultPrivilege;

    private int redisTimeOut;

    public String getDefaultTenant() {
        return defaultTenant;
    }

    public void setDefaultTenant(String defaultTenant) {
        this.defaultTenant = defaultTenant;
    }

    public int getDefaultPrivilege() {
        return defaultPrivilege;
    }

    public void setDefaultPrivilege(int defaultPrivilege) {
        this.defaultPrivilege = defaultPrivilege;
    }

    public int getRedisTimeOut() {
        return redisTimeOut;
    }

    public void setRedisTimeOut(int redisTimeOut) {
        this.redisTimeOut = redisTimeOut;
    }
}
