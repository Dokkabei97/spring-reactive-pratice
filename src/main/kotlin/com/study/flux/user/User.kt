package com.study.flux.user

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.redis.core.RedisHash

@RedisHash("User")
data class User @JsonCreator constructor(
    @JsonProperty("id") val id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("age") val age: Int,
    @JsonProperty("sex") val sex: SEX
) {
    enum class SEX {
        MALE, FEMALE
    }
}
