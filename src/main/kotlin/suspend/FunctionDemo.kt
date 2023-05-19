package suspend

import kotlinx.coroutines.AbstractCoroutine
import utils.log
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


val executor: ExecutorService = Executors.newCachedThreadPool()

fun main() {
    //functionA(1)

     val fun1 =   functionA(1)
    coroutineFun({ fun1 })
//    coroutineFun {
//      fun1
//    }
    println("------")
}
fun functionA(case:Int){
   // println("parm =$case")
    when(case){
        1 -> {
            taskA1()
            functionB(1)
        }
        2 -> {
            taskA2()
            functionB(2)
        }
        3 -> {
            taskA3()
            functionB(3)
        }
        4 -> {
            taskA4()
            functionB(4)
        }
    }
}


fun taskA1() {
    log("taskA1")
}
fun taskA2() {
    log("taskA2")
}
fun taskA3() {
    log("taskA3")
}
fun taskA4() {
    log("taskA4")
}

fun functionB(case:Int){
    when(case){
        1 -> {
            taskB1()
        }
        2 -> {
            taskB2()

        }
        3 -> {
            taskB3()
        }
        4 -> {
            taskB4()
        }
    }
}

fun taskB1() {
    executor.execute {
        println("taskB1")
        functionA(2)
    }

}

fun taskB2() {
    executor.execute{
        println("taskB2")
        functionA(3)
    }

}

fun taskB3() {
    executor.execute{
        println("taskB3")
        functionA(4)
    }

}

fun taskB4() {
    executor.execute{
        println("taskB4")
    }
}

fun coroutineFun(coroutine:() -> Unit){
    coroutine()
}
