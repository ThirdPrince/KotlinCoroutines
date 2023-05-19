package scope

import javafx.application.Application.launch
import kotlinx.coroutines.*
import thread.Task3
import utils.log
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.concurrent.thread

/**
 * 测试线程切换
 */



fun main() {
    Thread(Task3()).start()
    //Thread.sleep(3000)
}



