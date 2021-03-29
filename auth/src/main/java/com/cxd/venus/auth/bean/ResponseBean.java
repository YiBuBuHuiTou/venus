package com.cxd.venus.auth.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 19:29
 * @Version 1.0
 **/
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Component
public class ResponseBean implements Serializable {
    // 序列化类版本号
    private static final long serialVersionUID = 1L;

    // 动作
    private String action;

    //状态码
    private String statusCode;


    //说明信息
    private String message;

    //结果
    private String result;

    public String getStatusCode() {
        return statusCode;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void clear() {
        this.action = null;
        this.statusCode = null;
        this.message = null;
        this.result = null;
    }
}
