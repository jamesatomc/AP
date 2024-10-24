// File: app/src/main/java/shop/kanari/shop/utils/SessionManager.kt
package shop.kanari.shop.utils

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import androidx.navigation.NavController

object SessionManager {
    private const val PREF_NAME = "user_session"
    private const val KEY_IS_LOGGED_IN = "is_logged_in"
    private const val KEY_IS_REGISTERED = "is_registered"

    private fun getPreferences(context: Context) = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun isLoggedIn(context: Context) = getPreferences(context).getBoolean(KEY_IS_LOGGED_IN, false)

    fun isRegistered(context: Context) = getPreferences(context).getBoolean(KEY_IS_REGISTERED, false)

    fun setLoggedIn(context: Context, loggedIn: Boolean) {
        getPreferences(context).edit().putBoolean(KEY_IS_LOGGED_IN, loggedIn).apply()
    }

    fun setRegistered(context: Context, registered: Boolean) {
        getPreferences(context).edit().putBoolean(KEY_IS_REGISTERED, registered).apply()
    }

    fun logout(context: Context, navController: NavController) {
        GoogleSignIn.getClient(context, GoogleSignInOptions.DEFAULT_SIGN_IN).signOut().addOnCompleteListener {
            setLoggedIn(context, false)
            setRegistered(context, false)
            navController.navigate("login") {
                popUpTo("home") { inclusive = true }
            }
        }
    }
}