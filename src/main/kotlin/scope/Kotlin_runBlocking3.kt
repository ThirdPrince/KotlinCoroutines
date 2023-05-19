package scope

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import utils.log

/**
 * runBlocking
 * 注意和runBlocking2的区别
 */
fun main() = runBlocking {
    launch {
        doWorld()
    }
    log("Done")
}

suspend fun doWorld() = coroutineScope {
    launch {
        delay(2000L)
        log("world 2")
    }
    launch {
        delay(1000L)
        log("world 1")
    }
    log("hello")
}

