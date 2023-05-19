package flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import utils.log

/**
 * flow 的简单使用
 */
fun main() = runBlocking {
    val numbers = flow {
        for (i in 1..5){
            delay(1000)
            log(i)
            emit(i)
        }
    }

    val doubled = numbers.map { it *2 }.flowOn(Dispatchers.Default)
    doubled.collect {
        log(it)
    }
    log("end")

}