package com.study.flux.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody user: User) = userService.saveUser(user)

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String) = userService.getUserById(id)

    @GetMapping("/name")
    fun getUserByName(@RequestParam name: String) = userService.getUserByName(name)
}