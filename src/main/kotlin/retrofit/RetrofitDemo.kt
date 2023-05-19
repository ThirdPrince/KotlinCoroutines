package retrofit

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import utils.log

/**
 * https://amitshekhar.me/blog/retrofit-with-kotlin-flow
 */

fun main() = runBlocking {
    val apiHelper = ApiHelperIml(RetrofitBuilder.apiService)

    apiHelper.getUsers().collect {
        if(it.isSuccessful){
            log(it.body())
        }

    }

    apiHelper.getMoreUser().collect {9
        if(it.isSuccessful){
            log(it.body())
        }
    }

    apiHelper.getUsersWithError().collect {
        if(it.isSuccessful){
            log(it)
        }else{
            log(it.message())
        }
    }



}