package scope

import kotlinx.coroutines.*
import utils.log

/**
 * runBlocking
 * 试试把 Job() 去掉
 *
 * When a coroutine is launched in another coroutine,
 * it inherits the context of the outer coroutine and the job becomes the child job of the outer coroutine.
 * Then when the parent job is cancelled, all children jobs are cancelled, too.
 * If you want to make the child job independent from the parent job, then you could either define a different scope explicitly i.e
 * GlobalScope.launch or you could pass a new Job as a context to the child coroutine which will override the parent Job. In the Job1 ,
 * a new Job is passed to the coroutine, so it is not cancelled when the outer coroutine is cancelled.
 *
 */
fun main() = runBlocking<Unit> {

    val request = launch {
        launch(Job()) {
            log("job1a")
            delay(1000)
            log("joblb")
        }
        launch(Job()) {
            delay(100)
            log("job2a")
            delay(1000)
            log("job2b")
        }
    }
    delay(500)
    request.cancel()
    log("main who has survived request cancellation ")
    delay(1000)

}



