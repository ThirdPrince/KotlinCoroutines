package scope

import javafx.application.Application.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import utils.log

/**
 * runBlocking
 * launch 在 RunBlocking 下本质上是延迟执行
 *
 */
fun main(){
    singleCoroutine()
    multiCoroutine()


}

/**
 * 单线程协程
 */
 fun singleCoroutine() = runBlocking {
     launch {
         delay(1000)
         log("world")
     }
     log("hello")
}

/**
 * 多线程协程
 */
fun multiCoroutine() = runBlocking {
    // 创建一个新的协程，并将它分配到不同的线程中执行
    launch(Dispatchers.IO) {
        delay(1000)
        log("world")
    }
    log("hello")
}