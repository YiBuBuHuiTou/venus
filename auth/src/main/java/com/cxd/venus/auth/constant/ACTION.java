package com.cxd.venus.auth.constant;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 19:24
 * @Version 1.0
 **/
public enum ACTION {
    AUTH("AUTH"),

    //用户
    ADD_ACCOUNT("ADD_ACCOUNT"),
    UPDATE_ACCOUNT("UPDATE_ACCOUNT"),
    DEL_ACCOUNT("DEL_ACCOUNT"),
    DESTROY_ACCOUNT("DESTROY_ACCOUNT"),

    //租户
    ADD_TENANT("ADD_TENANT"),
    UPDATE_TENANT("UPDATE_TENANT"),
    DEL_TENANT("DEL_TENANT"),
    DESTROY_TENANT("DESTROY_TENANT");


    private String name;

    ACTION(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}