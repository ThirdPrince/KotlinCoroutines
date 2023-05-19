package cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import utils.log

fun main() = runBlocking {
    val job1 = launch {
        log(1)
        delay(1000)
        log(2)
    }
    delay(100)
    log(3)
    job1.cancel()
    log(4)
}