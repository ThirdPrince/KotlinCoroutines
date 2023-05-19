package dispatch

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import utils.log
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

suspend fun main() {
    val dispatcher = Executors.newSingleThreadExecutor{
        Thread(it,"MyThread")
    }.asCoroutineDispatcher()
    GlobalScope.launch(dispatcher) {
        log(1)
    }
    log(2)
    //dispatcher.close()
}