package com.study.flux.user

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserService(
    val redisOps: ReactiveRedisOperations<String, User>,
    val objectMapper: ObjectMapper
) {

    fun saveUser(user: User) = redisOps.opsForValue().set(user.id, user).subscribe()

    fun getUserById(id: String): Mono<User> = redisOps.opsForValue().get(id)
        .flatMap { Mono.just(objectMapper.convertValue(it, User::class.java)) }
}