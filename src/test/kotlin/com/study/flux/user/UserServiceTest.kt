package com.study.flux.user

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest :
    FunSpec({
        val userRepository = mockk<UserRepository>()
        val userService = UserService(userRepository)

        context("UserService") {
            test("save should return saved user") {
                // given
                val user = User(1, "홍길동", 20, User.Sex.MALE)
                coEvery { userRepository.save(user) } returns user

                // when
                val result = userService.save(user)

                // then
                result shouldBe user
                coVerify(exactly = 1) { userRepository.save(user) }
            }

            test("findById should return user when exists") {
                // Given
                val userId = 1L
                val user = User(1, "홍길동", 20, User.Sex.MALE)
                coEvery { userRepository.findById(userId) } returns user

                // When
                val result = userService.findById(userId)

                // Then
                result shouldBe user
                coVerify(exactly = 1) { userRepository.findById(userId) }
            }

//            test("findById should return null when user does not exist") {
//                // Given
//                val userId = 1L
//                coEvery { userRepository.findById(userId) } returns null
//
//                // When
//                val result = userService.findById(userId)
//
//                // Then
//                result shouldBe null
//                coVerify(exactly = 1) { userRepository.findById(userId) }
//            }

            test("findAll should return list of all users") {
                // Given
                val users =
                    listOf(
                        User(1, "홍길동", 20, User.Sex.MALE),
                        User(2, "김길동", 24, User.Sex.FEMALE),
                    )
                coEvery { userRepository.findAll() } returns flowOf(*users.toTypedArray())

                // When
                val result = userService.findAll()

                // Then
                result shouldBe users
                coVerify(exactly = 1) { userRepository.findAll() }
            }
        }
    })
