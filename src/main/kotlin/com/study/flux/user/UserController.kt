package com.study.flux.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService,
) {
    @PostMapping
    suspend fun createUser(
        @RequestBody user: User,
    ): ResponseEntity<User> = ResponseEntity.ok(userService.save(user))
}
