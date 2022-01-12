package id.co.museum.data.datasource

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import id.co.museum.network.ApiHelper
import id.co.museum.utils.Resource
import kotlinx.coroutines.tasks.await
import java.util.concurrent.ExecutionException
import javax.inject.Inject

class AccountDataSource @Inject constructor(
    private val apiHelper: ApiHelper
) {

    suspend fun register(email: String, password: String): Resource<FirebaseUser> {
        val response = apiHelper.register(email, password)
        return getResult(response)
    }

    private suspend fun getResult(task: Task<AuthResult>): Resource<FirebaseUser> {
        try {
            val response = task.await()
            val user = response.user
            if (user != null) return Resource.success(user)
        } catch (e: ExecutionException) {
            return error("${e.message}")
        } catch (e: InterruptedException) {
            return error("${e.message}")
        } catch (e: Exception) {
            return error("${e.message}")
        }
        return error("-", true)
    }

    private fun <T> error(
        message: String,
        networkError: Boolean = false
    ): Resource<T> {
        return Resource.error(
            if (networkError) "Network call has failed for a following reason: $message"
            else message
        )
    }

}