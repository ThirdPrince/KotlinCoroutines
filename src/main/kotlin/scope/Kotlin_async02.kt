package scope

import javafx.application.Application.launch
import kotlinx.coroutines.*
import utils.log

/**
 * runBlocking
 * launch 在 RunBlocking 下本质上是延迟执行
 *
 */
fun main() {
    log(1)
    val deferred = GlobalScope.async {
        delay(1000)
        "Hello from coroutine"
    }

    runBlocking {
        val result = deferred.await()
        log("result:$result")
    }
}

