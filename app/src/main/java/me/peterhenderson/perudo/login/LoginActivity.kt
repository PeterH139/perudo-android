package me.peterhenderson.perudo.login

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import me.peterhenderson.perudo.R
import me.peterhenderson.perudo.core.BaseActivity
import me.peterhenderson.perudo.core.ContentView
import me.peterhenderson.perudo.game.GameActivityIntent

@ContentView(R.layout.activity_login)
class LoginActivity : BaseActivity() {
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onStart() {
        super.onStart()
        auth.signInAnonymously()
                .addOnCompleteListener {
                    Toast.makeText(this, "Logged in anonymously as ${it.result.user.uid}.", Toast.LENGTH_LONG).show()
                    startActivity(GameActivityIntent())
                }
    }
}
