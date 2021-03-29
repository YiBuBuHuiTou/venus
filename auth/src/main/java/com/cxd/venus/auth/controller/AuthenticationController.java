package com.cxd.venus.auth.controller;

import com.cxd.venus.auth.bean.AccountBean;
import com.cxd.venus.auth.bean.ResponseBean;
import com.cxd.venus.auth.constant.ACTION;
import com.cxd.venus.auth.constant.STATUS;
import com.cxd.venus.auth.service.AuthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 19:24
 * @Version 1.0
 **/
@RestController
public class AuthenticationController {

    // 认证service
    private AuthService authService;

    private ResponseBean responseBean;

    private ObjectMapper objectMapper;

    @Autowired
    public AuthenticationController(AuthService authService, ResponseBean responseBean, ObjectMapper objectMapper) {
        this.authService = authService;
        this.responseBean = responseBean;
        this.objectMapper = objectMapper;
    }

    @RequestMapping(value = "/auth/check", method = RequestMethod.POST)
    public String auth(@RequestBody AccountBean accountBean) throws JsonProcessingException {
        boolean isPass = authService.check(accountBean);
        responseBean.setAction(ACTION.AUTH.getName());
        if (isPass) {
            responseBean.setResult(STATUS.SUCCESS.getName());
            responseBean.setStatusCode("VENUS200");
        } else {
            responseBean.setResult(STATUS.ERROR.getName());
            responseBean.setStatusCode("VENUS400");
        }
        return objectMapper.writeValueAsString(responseBean);
    }

    @RequestMapping(value = "/auth/authWithoutTenant", method = RequestMethod.POST)
    public String authWithoutTenant(@RequestBody AccountBean accountBean) throws JsonProcessingException {
        boolean isPass = authService.checkWithoutTenant(accountBean);
        responseBean.setAction(ACTION.AUTH.getName());
        if (isPass) {
            responseBean.setResult(STATUS.SUCCESS.getName());
            responseBean.setStatusCode("VENUS201");
        } else {
            responseBean.setResult(STATUS.ERROR.getName());
            responseBean.setStatusCode("VENUS401");
        }
        return objectMapper.writeValueAsString(responseBean);
    }
}
