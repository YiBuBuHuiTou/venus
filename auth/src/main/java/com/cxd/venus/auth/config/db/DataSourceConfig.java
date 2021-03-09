package com.cxd.venus.auth.config.db;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/9 23:29
 * @Version 1.0
 **/

@Configuration
public class DataSourceConfig {

    //主数据源配置 ds1数据源
    @Primary
    @Bean(name = "ds1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSourceProperties ds1DataSourceProperties(){
        return new DataSourceProperties();
    }
    //主数据源 ds1数据源
    public DataSource ds1DataSource(@Qualifier("ds1DataSource") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

}
