package com.study.flux.common

import org.slf4j.Logger
import org.springframework.util.StopWatch

inline fun <T> measureExecutionTime(
    logger: Logger,
    block: () -> T,
): T {
    val stopWatch = StopWatch()
    stopWatch.start()
    try {
        return block()
    } finally {
        stopWatch.stop()
        logger.info("Execution time: ${stopWatch.totalTimeMillis} ms")
    }
}

suspend inline fun <T> measureExecutionTimeSuspend(
    logger: Logger,
    crossinline block: suspend () -> T,
): T {
    val stopWatch = StopWatch()
    stopWatch.start()
    try {
        return block()
    } finally {
        stopWatch.stop()
        logger.info("Execution time: ${stopWatch.totalTimeMillis} ms")
    }
}
