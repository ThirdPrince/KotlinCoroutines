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
fun main()  {
    startLongRunningTask()

}

fun doLongRunningTaskOne():Flow<String>{
    return flow {
        delay(1000)
        emit("one")
    }
}

fun doLongRunningTaskTwo():Flow<String>{
    return flow {
        delay(5000)
        emit("Two")
    }
}

fun startLongRunningTask() = runBlocking{
    doLongRunningTaskOne().zip(doLongRunningTaskTwo()){
            resultOne,resultTwo ->
        return@zip resultOne + resultTwo
    }.flowOn(Dispatchers.Default).collect {
        log(it)
    }
}