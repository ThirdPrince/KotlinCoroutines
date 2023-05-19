package coroutines_start

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import utils.log

/**
 * CoroutineStart.LAZY
 */
 fun main() {
    log(1)
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        log(2)
    }
    log(3)
    job.start()
    log(4)
}