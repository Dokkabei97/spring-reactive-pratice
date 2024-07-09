package com.study.flux.config

import com.study.flux.user.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfiguration {

    @Bean
    fun userRedisTemplate(redisConnectionFactory: ReactiveRedisConnectionFactory): ReactiveRedisOperations<String, User> {
        val serializer = Jackson2JsonRedisSerializer(User::class.java)
        val context = RedisSerializationContext.newSerializationContext<String, User>(StringRedisSerializer())
            .value(serializer)
            .hashValue(serializer)
            .hashKey(serializer)
            .build()

        return ReactiveRedisTemplate(redisConnectionFactory, context)
    }

}