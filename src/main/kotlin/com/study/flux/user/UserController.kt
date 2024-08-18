package com.study.flux.user

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService,
) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    suspend fun createUser(
        @RequestBody user: User,
    ): ResponseEntity<User> = ResponseEntity.ok(userService.save(user))

    @Suppress("ktlint:standard:no-consecutive-comments")

    // FIXME : Not work
    @PostMapping("/all")
    suspend fun createAllUsers(): ResponseEntity<Unit> {
        userService.saveAll()
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{id}")
    suspend fun findUserById(
        @PathVariable id: Long,
    ): ResponseEntity<User> = ResponseEntity.ok(userService.findById(id))

    @GetMapping
    suspend fun findAllUsers(): ResponseEntity<List<User>> = ResponseEntity.ok(userService.findAll())

    @GetMapping("all")
    suspend fun makeUserList(): ResponseEntity<List<User>> = ResponseEntity.ok(UserUtils().makeUserList())
}
