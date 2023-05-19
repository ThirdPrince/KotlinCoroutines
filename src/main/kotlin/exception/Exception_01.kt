package exception

import com.google.gson.JsonObject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import utils.log
import java.lang.Exception
import java.lang.IllegalArgumentException
import javax.jws.soap.SOAPBinding
import javax.xml.bind.JAXBElement
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


typealias Callback<T> = (User) -> Unit

suspend fun main() {

    GlobalScope.launch {
        try {
            log(1)
            println(getUserCoroutine().name)
            println(getUserCoroutine2().name)
            //println(getUser2(getUserCoroutine2().name))
            log(2)
        }catch (e:Exception){
            e.printStackTrace()
        }

    }.join()
    log(3)
}

fun getUser(callback: Callback<Any?>) {
    thread {
        callback(User("charlie"))
    }
}

fun getUser2(callback2: Callback2<User>){
    thread {
       // callback2.success(User("charlie2"))
        callback2.onError(IllegalArgumentException("回调失败"))
    }

}

suspend fun getUserCoroutine() = suspendCoroutine<User> { continuation ->
    getUser {
        log(3)
        continuation.resume(it)
        log(4)
    }
}
suspend fun getUserCoroutine2() = suspendCoroutine<User> {
    getUser2(object :Callback2<User>{
        override fun success(value: User) {
            it.resume(value)
        }

        override fun onError(t: Throwable) {
          it.resumeWithException(t)
        }

    })
}
data class User(val name: String){


}

interface Callback2<T>{
    fun success(value:T)
    fun onError(t:Throwable)
}