package com.cxd.venus.auth.bean;

import java.io.Serializable;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 19:29
 * @Version 1.0
 **/
public class ResponseBean implements Serializable {
    // 序列化类版本号
    private static final long serialVersionUID = 1L;

    //状态码
    private String statusCode;

    //说明信息
    private String message;

    //结果
    private String result;

    public String getStatusCode() {
        return statusCode;
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
}
