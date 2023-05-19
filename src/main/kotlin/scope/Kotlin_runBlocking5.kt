package scope

import kotlinx.coroutines.*
import utils.log

/**
 * runBlocking
 */
fun main() = runBlocking {
    launch(Dispatchers.Unconfined) {
        log("Unconfined Im working in thread")
        delay(500)
        log("Unconfined after delay in thread")
    }

    launch {
        log("runBlocking Im working in thread")
        delay(1000)
        log("runBlocking after delay in thread")
    }
    log("end")

}



