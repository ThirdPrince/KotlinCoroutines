package dispatch

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import utils.log
import javax.xml.bind.JAXBElement
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

suspend fun main() {
    GlobalScope.launch(MyContinuationInterceptor()) {
        log(1)
        val job = async {
            log(2)
            delay(1000)
            log(3)
            "hello"
        }
        log(4)
        val result = job.await()
        log("5.$result")
    }.join()
    log(6)
}
class MyContinuationInterceptor:ContinuationInterceptor{
    override val key = ContinuationInterceptor
    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> = MyContinuation(continuation)

}
class MyContinuation<T>(private val continuation: Continuation<T>):Continuation<T>{
    override val context =  continuation.context

    override fun resumeWith(result: Result<T>) {
        log("<MyContinuation> $result")
        continuation.resumeWith(result)

    }

}