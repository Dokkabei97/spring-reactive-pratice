package com.study.flux.user

import com.study.flux.common.measureExecutionTimeSuspend
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository,
) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @Transactional
    suspend fun save(user: User): User =
        measureExecutionTimeSuspend(logger) {
            userRepository.save(user)
        }

    @Transactional
    suspend fun saveAll() =
        runBlocking {
            val start = System.currentTimeMillis()
            userRepository.saveAll(
                UserUtils().makeUserList(),
            )
            val end = System.currentTimeMillis()
            logger.info("Execution time: ${end - start} ms")
        }

    suspend fun findById(id: Long): User =
        measureExecutionTimeSuspend(logger) {
            userRepository.findById(id) ?: throw NullPointerException("User not found")
        }

    suspend fun findAll(): List<User> =
        measureExecutionTimeSuspend(logger) {
            userRepository
                .findAll()
                .toList()
        }
}
