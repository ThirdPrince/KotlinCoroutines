package scope

import javafx.application.Application
import javafx.application.Application.launch
import kotlinx.coroutines.*
import utils.log

/**
 * coroutineScope 定义了一组关联的协程，并管理他们的生命周期。在协程作用域内
 * 可以启动新的协程，并使用协程构建器创建新的协程。协程作用域还可以提供异常处理和取消协程的机制。
 * coroutineScope 函数主要是创建一个新的协程作用域，并等待其中所有的子协程完成后才继续执行。
 *
 *
 */
suspend fun main() {
    log(1)
    coroutineScope {
        launch {
            log(2)
        }
    }
    log(3)
}