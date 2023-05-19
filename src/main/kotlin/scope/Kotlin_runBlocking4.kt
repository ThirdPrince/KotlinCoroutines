package scope

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import utils.log

/**
 * runBlocking
 * 注意和runBlocking2的区别
 */
fun main() = runBlocking {
   val job = launch {
       delay(2000L)
       log("World")
   }
    log("Hello")
    job.join()
    log("Done")
}



