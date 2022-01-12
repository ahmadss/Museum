package id.co.museum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.museum.base.BaseActivity
import id.co.museum.ui.home.HomeActivity
import id.co.museum.ui.login.LoginActivity
import id.co.museum.ui.main.MainFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoLogout = false
    }

    override fun onStart() {
        super.onStart()
        runBlocking { delay(1000) }
        val currentUser = auth.currentUser
        startActivity(
            Intent(
                this,
                if (currentUser != null)
                    HomeActivity::class.java
                else
                    LoginActivity::class.java
            )
        )
        finish()
    }
}