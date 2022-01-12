package id.co.museum.network

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface ApiHelper {
    suspend fun register(email: String, password: String): Task<AuthResult>
}