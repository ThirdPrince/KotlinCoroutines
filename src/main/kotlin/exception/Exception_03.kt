package exception

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import utils.log

suspend fun main() {
    val exceptionHandler = CoroutineExceptionHandler{
        coroutineContext, throwable ->
        log("Throws an exception with message:${throwable.message}")
    }
    log(1)
    GlobalScope.launch(exceptionHandler) {
        throw ArithmeticException("Hey")
    }.join()
    log(2)
}