package scope

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import utils.log

/**
 * runBlocking
 */
fun main() = runBlocking{
   val request = launch {
       repeat(3){
           launch {
               delay((it+1)*200L)
               log("coroutine $it is done")
           }
       }
       log("request:I am done and i dont explicitly join my children that are still active")

   }
    request.join()
    log("Now processing of the request is complete")
}

