package thread

import kotlinx.coroutines.*
import utils.log
import java.lang.Runnable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

/**
 * Test thread runBlocking
 */

val executor: ExecutorService = Executors.newCachedThreadPool()

class Task3:Runnable {
    override fun run() {
        runBlocking{
            log(1)
//        thread {
//            log(2)
//        }
            withContext(Dispatchers.IO) {
                log(3)
            }
            log(4)
            val  future = executor.submit(){
                Thread.sleep(200)
                log(5)
            }
            future.get()
        }
        log(6)

    }


}