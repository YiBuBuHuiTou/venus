package com.cxd.venus.auth.constant;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 19:24
 * @Version 1.0
 **/
public enum  STATUS {

    DEFAULT("UNKNOWN"),

    SUCCESS("SUCCESS"),

    ERROR("ERROR"),

    ACCOUNT_NOT_FOUND("ACCOUNT_NOT_FOUND"),

    PASSWORD_NOT_MATCH("PASSWORD_NOT_MATCH"),

    SECURITY_KEY_NOT_FOUND("SECURITY_KEY_NOT_FOUND"),

    TENANT_NOT_FOUND("TENANT_NOT_FOUND");

    private String name;

    STATUS(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}