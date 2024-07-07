package com.study.flux.user

import org.springframework.data.redis.core.RedisHash

@RedisHash("User")
data class User(
    val id: String,
    val name: String,
    val age: Int,
    val sex: SEX
) {
    enum class SEX {
        MALE, FEMALE
    }
}
