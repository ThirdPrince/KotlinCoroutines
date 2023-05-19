package scope

import javafx.application.Application
import javafx.application.Application.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import utils.log

/**
 * GlobalScope
 */
fun main() {
    GlobalScope.launch(Dispatchers.IO) {
        log("1")
        // delay(1000)
        log("world")
        log("2")
    }
    log("3")
    log("hello")
    Thread.sleep(2000)

}