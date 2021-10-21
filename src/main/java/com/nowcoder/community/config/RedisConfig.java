package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {
    @Bean//定义第三方Bean，Bean名字为redisTemplate
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){//注入连接工厂才能链接数据库
        RedisTemplate<String,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);//可以访问数据库了
        //设置key的序列化方式
        template.setKeySerializer(RedisSerializer.string());
        //设置value的序列化方式
        template.setValueSerializer(RedisSerializer.json());
        //设置hash的key的序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
        //设置hash的value的序列化方式
        template.setHashValueSerializer(RedisSerializer.json());

        template.afterPropertiesSet();//设置完之后，触发生效
        return template;
    }
}
