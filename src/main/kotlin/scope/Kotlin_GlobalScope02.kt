package scope

import javafx.application.Application
import javafx.application.Application.launch
import kotlinx.coroutines.*
import utils.log

/**
 * GlobalScope
 */
fun main() {
    log(1)
    GlobalScope.launch {
        delay(1000)
        log(2)
    }
    log(3)
    runBlocking {
        delay(2000)
    }
    log(4)

}