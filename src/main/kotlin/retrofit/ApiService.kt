package retrofit

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers():Response<List<ApiUser>>

    @GET("more-users")
    suspend fun getMoreUsers():Response<List<ApiUser>>

    @GET("error")
    suspend fun getUserWithError():Response<List<ApiUser>>
}