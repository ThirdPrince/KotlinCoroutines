package flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import utils.log
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * flow 的简单使用
 */

val executor: ExecutorService = Executors.newCachedThreadPool()

suspend fun main() {

    //flow1()
    //flow2()
    //flow3()
    //flow4()
    //flow5()
    flow6()

}

/**
 * flow
 */
suspend fun flow1(){
    flow {
        (0..10).forEach { emit(it) }
    }.map { it * it }.collect {
        log(it)
    }
    log("end")
}

/**
 * flow2
 */
suspend fun flow2(){
    flowOf(4,2,5,1,7).collect{
        log(it)
    }
}

/**
 * asflow
 */
suspend fun flow3(){
    (1..5).asFlow().collect{
        log(it)
    }

}

/**
 * channelFlow
 */
suspend fun flow4(){
    channelFlow {
        (0..10).forEach {
            send(it)
        }
    }.collect{
        log(it)
    }
}

suspend fun flow5(){
    val flow = flow{
        (0..10).forEach {
            delay(500)
            log("emit $it")
            emit(it)
        }
    }.flowOn(Dispatchers.Default)
    GlobalScope.launch((executor.asCoroutineDispatcher())) {
        flow.collect{
            log(it)
        }
    }

}

suspend fun flow6(){
    val result = (1..5).asFlow().reduce{
        a,b -> a+b
    }
    log("result= $result")
}