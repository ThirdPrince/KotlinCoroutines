package thread

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import utils.log

/**
 * Test thread runBlocking
 */
class Task:Runnable {
    override fun run() {
        runBlocking{
            fetchData {
                log(it)
            }
        }

    }

    private suspend fun fetchData(): String {
        return withContext(Dispatchers.IO) {
            delay(1000)
            "Data from server"
        }
    }

    private suspend fun fetchData(callback: (String) -> Unit) {
        val data = fetchData();
        callback(data)
    }
}