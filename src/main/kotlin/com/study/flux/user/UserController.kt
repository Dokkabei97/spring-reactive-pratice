package com.study.flux.user

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/user")
class UserController(
    val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody user: User) = userService.saveUser(user)

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String): Mono<User> = userService.getUserById(id)
}