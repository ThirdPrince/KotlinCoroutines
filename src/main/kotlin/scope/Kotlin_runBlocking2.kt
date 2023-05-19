package scope

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import utils.log

/**
 * runBlocking
 */
fun main() = runBlocking{
    dowWorld()
    log("done")
}

suspend fun dowWorld()= coroutineScope {
    launch {
        delay(2000L)
        log("World 2")
    }
    launch {
        delay(1000L)
        log("World 1")
    }
    log("Hello")
}