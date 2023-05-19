package retrofit

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiHelperIml(private val apiService: ApiService):ApiHelper{

    override fun getUsers() = flow {
        emit(apiService.getUsers())
    }

    override fun getMoreUser() = flow {
        emit(apiService.getMoreUsers())
    }

    override fun getUsersWithError() = flow {
        emit(apiService.getUserWithError())
    }

}