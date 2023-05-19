package coroutines_start

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import utils.log

/**
 * CoroutineStart.DEFAULT
 */
suspend fun main() {
    log(1)
    val job = GlobalScope.launch {
        log(2)
    }
    log(3)
    job.join()
    log(4)

}