package com.cxd.venus.auth;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/2/28 19:51
 * @Version 1.0
 **/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//开启缓存
@EnableCaching
@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
