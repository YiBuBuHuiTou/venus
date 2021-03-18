package com.cxd.venus.auth.config.redis;

import com.cxd.venus.auth.config.AppDefault;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/15 21:31
 * @Version 1.0
 **/
@Configuration
public class RedisConfig {

    private AppDefault appDefault;

    @Autowired
    public RedisConfig(AppDefault appDefault) {
        this.appDefault = appDefault;
    }

    /**
     * 生成redis 配置
     * @param host
     * @param password
     * @param port
     * @param db
     * @return
     */
    private RedisStandaloneConfiguration generateRedisConfig(String host, int port, int db, String password) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(host,port);
        redisStandaloneConfiguration.setDatabase(db);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        return redisStandaloneConfiguration;
    }

    @Bean("redisConfig1")
    public RedisStandaloneConfiguration redisConfig1(@Value("${spring.redis.host}") String host, @Value("${spring.redis.port}") int port,
                                                     @Value("${spring.redis.database}") int db, @Value("${spring.redis.password}") String password) {
        return generateRedisConfig(host, port, db, password);
    }

    @Bean("redisConfig2")
    public RedisStandaloneConfiguration redisConfig2(@Value("${spring.redis2.host}") String host, @Value("${spring.redis2.port}") int port,
                                                     @Value("${spring.redis2.database}") int db, @Value("${spring.redis2.password}") String password) {
        return generateRedisConfig(host, port, db, password);
    }

    /**
     * 配置数据源链接工厂
     * @return
     */
    @Bean("factory1")
    @Primary
    public LettuceConnectionFactory factory1(@Qualifier("redisConfig1") RedisStandaloneConfiguration redisStandaloneConfiguration) {
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }
    @Bean("factory2")
    public LettuceConnectionFactory factory2(@Qualifier("redisConfig2") RedisStandaloneConfiguration redisStandaloneConfiguration) {
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    public RedisTemplate<String, Object> generateRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.WRAPPER_ARRAY);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
        return  redisTemplate;
    }

    @Bean
    public RedisTemplate redisTemplate1(@Qualifier("factory1") RedisConnectionFactory factory) {
        return generateRedisTemplate(factory);
    }
    @Bean
    public RedisTemplate redisTemplate2(@Qualifier("factory2") RedisConnectionFactory factory) {
        return generateRedisTemplate(factory);
    }

    @Bean
    @Primary
    public CacheManager cacheManager(@Qualifier("redisTemplate1") RedisTemplate<String, Object> redisTemplate) {
        RedisCacheConfiguration defaultRedisConfiguration =
                RedisCacheConfiguration
                .defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getStringSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer()))
                .disableCachingNullValues()
                .entryTtl(Duration.ofMinutes(appDefault.getRedisTimeOut()));
        RedisCacheManager redisCacheManager =
                RedisCacheManager.RedisCacheManagerBuilder.
                        fromConnectionFactory(redisTemplate.getConnectionFactory())
                        .cacheDefaults( defaultRedisConfiguration)
                        .transactionAware().build();

        return redisCacheManager;
    }


}
