package me.peterhenderson.perudo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.firebase.ui.auth.ResultCodes
import com.google.firebase.auth.FirebaseAuth
import me.peterhenderson.perudo.game.GameActivityIntent

class SplashActivity : AppCompatActivity() {
    private val RC_SIGN_IN = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (FirebaseAuth.getInstance().currentUser != null) {
            loggedInSuccessfully()
        } else {
            startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(listOf(
                            AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                            AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build(),
                            AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                    .setIsSmartLockEnabled(false)
                    .build(), RC_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            // Successfully signed in
            if (resultCode == ResultCodes.OK) {
                loggedInSuccessfully()
            } else {
                // Sign in failed
                if (response == null) {
                    // User pressed back button
//                    showSnackbar(R.string.sign_in_cancelled)
                } else if (response.errorCode == ErrorCodes.NO_NETWORK) {
//                    showSnackbar(R.string.no_internet_connection)
                } else if (response.errorCode == ErrorCodes.UNKNOWN_ERROR) {
//                    showSnackbar(R.string.unknown_error)
                } else {
//                    showSnackbar(R.string.unknown_sign_in_response)
                }
            }
        }
    }

    private fun loggedInSuccessfully() {
        startActivity(GameActivityIntent())
        finish()
    }
}
