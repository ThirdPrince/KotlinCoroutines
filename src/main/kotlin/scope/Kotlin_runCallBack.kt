package scope

import javafx.application.Application.launch
import kotlinx.coroutines.*
import thread.Task
import utils.log

/**
 * runBlocking
 * launch 在 RunBlocking 下本质上是延迟执行
 *
 */
fun main() = runBlocking {

    val task = Thread(Task())
    task.start()
    fetchData {
        log(it)
    }

}

suspend fun fetchData(): String {
    return withContext(Dispatchers.IO) {
        delay(1000)
        "Data from server"
    }
}

suspend fun fetchData(callback: (String) -> Unit) {
    val data = fetchData();
    callback(data)
}



