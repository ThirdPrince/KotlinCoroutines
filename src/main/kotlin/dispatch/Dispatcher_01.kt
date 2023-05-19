package dispatch

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import utils.log
import javax.xml.bind.JAXBElement
import kotlin.coroutines.coroutineContext

suspend inline fun Job.Key.currentJob() = coroutineContext[Job]
suspend fun main() {
    GlobalScope.launch(CoroutineName("Hello")) {
        log(coroutineContext[Job])
        log(Job.currentJob())
    }.join()
    log(coroutineContext[Job])
    log(Job.currentJob())

}