import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun coldFlow(): Flow<Int> = flow {
    println("Cold flow start")
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
    println("Cold flow end")
}

fun hotFlow(): Flow<Int> = flow {
    println("Hot flow start")
    var i = 1
    while (true) {
        delay(1000)
        emit(i)
        i++
    }
}

fun main() = runBlocking {
    println("------ Cold Flow ------")
    val cold = coldFlow()

    println("Collector 1")
    cold.collect { value ->
        println("Collector 1: $value")
    }

    delay(2000)

    println("Collector 2")
    cold.collect { value ->
        println("Collector 2: $value")
    }

    println("------ Hot Flow ------")
    val hot = hotFlow()

    val job = launch {
        println("Collector 3")
        hot.collect { value ->
            println("Collector 3: $value")
        }
    }

    delay(2000)

    job.cancel()

    println("Collector 4")
    hot.collect { value ->
        println("Collector 4: $value")
    }
}
