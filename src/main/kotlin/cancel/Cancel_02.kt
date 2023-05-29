package cancel

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import exception.Callback
import exception.Callback2
import exception.User
import kotlinx.coroutines.*
import kotlinx.coroutines.internal.resumeCancellableWith
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import utils.log
import java.io.IOException
import java.lang.Exception
import java.lang.NullPointerException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * 协程的取消
 */
fun main() = runBlocking {


    val job = launch {
        log(1)
        val user = getUserCoroutine()
        log(2)
        log(user.toString())
    }
    delay(2000)
    log(3)
    job.cancel()
    log(4)

   getUserByOkHttp(object :Callback2<GithubUser>{
       override fun success(value: GithubUser) {

       }

       override fun onError(t: Throwable) {

       }

   })


}



/**
 * 挂起
 */
suspend fun getUserCoroutine() = suspendCancellableCoroutine<GithubUser> { continuation ->
    val call = OkHttpClient().newCall(Request.Builder().get().url("https://api.github.com/users/bennyhuo").build())
    continuation.invokeOnCancellation { // ①
        log("invokeOnCancellation: cancel the request.")
        call.cancel()
    }
    call.enqueue(object : okhttp3.Callback {
        override fun onFailure(call: Call, e: IOException) {
            continuation.resumeWithException(e)
        }

        override fun onResponse(call: Call, response: Response) {
            response.body()?.let {
                try {
                    continuation.resume(GithubUser.from(it.string()))
                } catch (e: Exception) {
                    e.printStackTrace()
                    continuation.resumeWithException(e)
                }
            } ?: continuation.resumeWithException(NullPointerException())
        }

    })
}

/**
 * GitUser
 */
data class GithubUser(val login: String) {
    companion object {
        fun from(str: String): GithubUser {
            val jsonParser = JsonParser().parse(str).asJsonObject
            val login = jsonParser.get("login").asString
            return GithubUser(login)

        }
    }
}

/**
 * 正常回调
 */
fun getUserByOkHttp(callback: Callback2<GithubUser>) {
    val call = OkHttpClient().newCall(Request.Builder().get().url("https://api.github.com/users/bennyhuo").build())
    call.enqueue(object : okhttp3.Callback {
        override fun onFailure(call: Call, e: IOException) {
            callback.onError(e)
        }

        override fun onResponse(call: Call, response: Response) {
            response.body()?.let {
                try {
                    callback.success(GithubUser.from(it.string()))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

    })
}