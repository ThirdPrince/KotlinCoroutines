package flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import utils.log

/**
 * flow 的简单使用
 */
suspend fun main() {
   // stateFlow()
   // shareFlow()
    //zipFlow()
    startLongRunningTask()
}

suspend fun stateFlow(){
    val stateFlow = MutableStateFlow(10)
    stateFlow.value = 160
    stateFlow.collect {
        log(it)
    }
}
suspend fun shareFlow(){
    val sharedFlow = MutableSharedFlow<Int>(3)
    sharedFlow.emit(3)
    sharedFlow.collect {
        log(it)
    }
}

suspend fun zipFlow(){
    val flowOne = flowOf(1,2,3)
    val flowTwo = flowOf("A","B","C")
    flowOne.zip(flowTwo){
        intValue, stringValue ->  "$intValue$stringValue"
    }.collect {
        log(it)
    }
}

