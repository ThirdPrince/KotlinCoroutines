package dispatch

import kotlinx.coroutines.*
import utils.log
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

suspend fun main() {
    Executors.newFixedThreadPool(10).asCoroutineDispatcher().use {
        GlobalScope.launch(it) {
            log(1)
            val job = async {
                log(2)
                delay(1000)
                log(3)
                "hello"
            }
            log(4)
            val result = job.await()
            log("5.$result")
        }.join()
        log(6)
    }
}