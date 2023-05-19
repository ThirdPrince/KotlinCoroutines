package scope

import javafx.application.Application.launch
import kotlinx.coroutines.*
import utils.log

/**
 * runBlocking
 * launch 在 RunBlocking 下本质上是延迟执行
 *
 */
fun main() = runBlocking {

    val task1 = async {
        fetchUserData()
    }
    val task2 = async {
        fetchNews()
    }

    val userData = task1.await()
    val news = task2.await()
    log("User data :$userData")
    log("news $news")
}

suspend fun fetchUserData(): String {
    delay(1000)
    return "User data"
}

suspend fun fetchNews(): String {
    delay(3000)
    return "Latest news"
}