package dispatch

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import utils.log
import java.util.concurrent.Executors

suspend fun main() {
    var i = 0
    Executors.newFixedThreadPool(1).asCoroutineDispatcher().use {
        dispatch ->
            List(100000){
                GlobalScope.launch(dispatch){
                    i++
            }
        }.forEach{
                it.join()
            }
    }
    log(i)
}