package com.cxd.venus.auth.controller;

import com.cxd.venus.auth.bean.AuthBean;
import com.cxd.venus.auth.bean.ResponseBean;
import com.cxd.venus.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    public AuthenticationController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "/auth/check", method = RequestMethod.POST)
    public ResponseBean auth(@RequestBody  AuthBean authBean) {
        boolean isPass = authService.check(authBean);

        return null;
    }

    @RequestMapping(value = "/auth/authWithoutTenant", method = RequestMethod.POST)
    public ResponseBean authWithoutTenant(@RequestBody  AuthBean authBean) {
        boolean isPass = authService.checkWithoutTenant(authBean);

        return null;
    }
}
