package com.cxd.venus.auth.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/29 22:32
 * @Version 1.0
 **/
@Configuration
public class AutoConfig {

    // jackson Bean
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
