package com.study.flux.user

import com.study.flux.common.measureExecutionTimeSuspend
import kotlinx.coroutines.withContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.coroutines.coroutineContext

class UserUtils {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    suspend fun makeUserList(): List<User> =
        withContext(coroutineContext) {
            measureExecutionTimeSuspend(logger) {
                (1..10000).map { User.of(name = "user$it", age = it, sex = if (it % 2 == 0) User.Sex.MALE else User.Sex.FEMALE) }
            }
        }
}
