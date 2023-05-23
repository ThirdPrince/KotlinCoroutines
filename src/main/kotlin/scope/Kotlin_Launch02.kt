package scope

import javafx.application.Application
import javafx.application.Application.launch
import kotlinx.coroutines.*
import utils.log

/**
 * launch02
 */
suspend fun main() {
    log(1)
    coroutineScope {
        launch {
            log(2)
        }
    }
    log(3)
}