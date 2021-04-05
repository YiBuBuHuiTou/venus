package com.cxd.venus.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/29 23:10
 * @Version 1.0
 **/
@RestController
public class AccountController {

    @RequestMapping(value = "/auth/account/new", method = RequestMethod.POST)
    public String addAccount() {
        return null;
    }

    @RequestMapping(value = "/auth/account/update", method = RequestMethod.POST)
    public String updateAccount() {
        return null;
    }
    @RequestMapping(value = "/auth/account/del", method = RequestMethod.POST)
    public String delAccount() {
        return null;
    }
}
