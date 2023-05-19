package suspend

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import utils.log
import java.util.concurrent.atomic.AtomicInteger

fun main() = runBlocking{
    val number = AtomicInteger(1)
    val maxCount = 10
    val oddJob = launch {
        printOdd(number,maxCount)
    }
    val evenJob = launch {
        printEven(number,maxCount)
    }
   // oddJob.join()
    //evenJob.join()
}

suspend fun printOdd(number: AtomicInteger, maxCount:Int){
    while (number.get() <= maxCount){
        if(number.get() % 2 !=0){
            println("Odd:${number.getAndIncrement()}")
            yield()
        }else{
            log("printOdd-->${number.get()}")
        }
        delay(2000)
    }
}

suspend fun printEven(number: AtomicInteger, maxCount:Int){
    while (number.get() <= maxCount){
        if(number.get() % 2 ==0){
            println("even:${number.getAndIncrement()}")
            yield()

        }else{
            log("printEven-->${number.get()}")
        }
        delay(1000)
    }
}