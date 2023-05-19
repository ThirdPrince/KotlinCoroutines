package flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import utils.log
import java.io.IOException
import java.lang.IndexOutOfBoundsException

/**
 * flow 的简单使用
 */
fun main() = runBlocking {
    doLongRunningTask().flowOn(Dispatchers.Default).retry(retries = 3) {
        if (it is IOException) {
            delay(2000)
            log("retry")
            return@retry true
        } else {
            log("retry false")
            return@retry false
        }
    }.catch {
        log(it)
    }.collect {
        log(it)
    }

}

fun doLongRunningTask(): Flow<Int> {
    return flow {
        log("flow")
        delay(2000)
        val randomNum = (0..2).random()
        if (randomNum == 0) {
            throw IOException()
        } else if (randomNum == 1) {
            throw IndexOutOfBoundsException()
        }
       // delay(2000)
        emit(0)

    }
}