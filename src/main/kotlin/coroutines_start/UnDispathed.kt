package coroutines_start

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import utils.log

/**
 * UnDispatched
 */
suspend fun main() {
    log(1)
    val job = GlobalScope.launch(start = CoroutineStart.UNDISPATCHED) {
        log(2)
        delay(100)
        log(3)
    }
    log(4)
    job.join()
    log(5)
}