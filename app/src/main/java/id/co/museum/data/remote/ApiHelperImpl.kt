package id.co.museum.network

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import id.co.museum.data.models.CollectionResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {

    override suspend fun register(email: String, password: String): Task<AuthResult> =
        Firebase.auth.createUserWithEmailAndPassword(email, password)

}