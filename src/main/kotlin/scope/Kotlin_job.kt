package scope

import javafx.application.Application.launch
import kotlinx.coroutines.*
import utils.log

/**
 * runBlocking
 *
 */
fun main() {
    log(1)
    runBlocking {
        val job1 = launch{
            delay(1000)
            var count = 0;
            while (count < 20000){
                count++
                log(2)
            }

        }

        val job2 = launch {
            delay(2000)
            log(3)
        }
        job1.join()
        job2.join()
        log("All coroutine completed")
    }
}

