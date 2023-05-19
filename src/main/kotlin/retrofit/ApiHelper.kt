package retrofit

import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ApiHelper {

    fun getUsers(): Flow<Response<List<ApiUser>>>
    fun getMoreUser():Flow<Response<List<ApiUser>>>
    fun getUsersWithError():Flow<Response<List<ApiUser>>>

}