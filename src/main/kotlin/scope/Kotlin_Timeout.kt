package scope

import javafx.application.Application.launch
import kotlinx.coroutines.*
import utils.log

/**
 * runBlocking
 * launch 在 RunBlocking 下本质上是延迟执行
 *
 */
fun main() = runBlocking{
  val result = withTimeoutOrNull(5000){
      delay(7000)
      "Operation"
  }
    log(result)

}



