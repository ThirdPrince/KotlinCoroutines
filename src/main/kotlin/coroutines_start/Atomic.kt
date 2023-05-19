package coroutines_start

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import utils.log

/**
 *
 */
suspend fun main() {
    log(1)
    val job = GlobalScope.launch(start = CoroutineStart.ATOMIC) {
        log(2)
        delay(1000)
        log(3)
    }
    job.cancel()
    log(4)
    job.join()
}