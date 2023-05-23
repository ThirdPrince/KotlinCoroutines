package scope

import javafx.application.Application
import javafx.application.Application.launch
import kotlinx.coroutines.*
import utils.log

/**
 * coroutineScope
 * coroutineScope 函数提供了一种简单的方式创建协程作用域，管理子协程执行，并在所有子协程完车后继续执行
 * 父协程的代码，这有助于协程之间的协调和控制，确保以期望的顺序和方式执行
 */
 fun main()  = runBlocking{
    coroutineScope {
        launch {
            delay(1000)
            log("Coroutine 1 completed")
        }
        launch {
            delay(300)
            log("Coroutine 2 completed")
        }
    }
    log("All coroutine completed")

}