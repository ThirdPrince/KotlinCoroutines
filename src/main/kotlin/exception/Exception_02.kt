package exception

import java.lang.ArithmeticException

fun main() {
    Thread.setDefaultUncaughtExceptionHandler{
        t:Thread,e:Throwable ->
        println("Thread -->${t.name} throws an exception with message ${e.message}")

    }
    throw ArithmeticException("Hey!")
}