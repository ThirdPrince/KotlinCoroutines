package sequence

import utils.log

fun main() {
    fib1()
}
fun fib1(){
    val fibonacci = sequence {
        yield(1L)
        val cur = 1L
        var next = 1L
        while (true){
            yield(next)
            val tmp = cur +next
            next = tmp
        }
    }
  fibonacci.take(5).forEach(::log)
}