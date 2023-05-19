package scope

import javafx.application.Application.launch
import kotlinx.coroutines.*
import utils.log

/**
 * runBlocking
 *
 */
fun main() {

}
suspend fun fetchData(url:String):String{
    delay(2000)
    return "Data from $url"
}


