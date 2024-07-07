package com.study.flux.user

import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun saveUser(user: User) = userRepository.save(user)

    fun getUserById(id: String) = userRepository.findById(id)

    fun getUserByName(name: String) = userRepository.findByName(name)
}