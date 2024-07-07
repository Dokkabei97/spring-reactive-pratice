package com.study.flux.user

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface UserRepository : ReactiveCrudRepository<User, String> {
    fun findByName(name: String): Mono<User>
}