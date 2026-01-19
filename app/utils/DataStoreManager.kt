package bf.amido.sawadogo.boutique.utils

import android.content.Context
import android.content.SharedPreferences

class DataStoreManager private constructor(context: Context) {
    
    companion object {
        @Volatile
        private var INSTANCE: DataStoreManager? = null
        
        fun getInstance(context: Context): DataStoreManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: DataStoreManager(context.applicationContext).also {
                    INSTANCE = it
                }
            }
        }
    }
    
    private val sharedPref: SharedPreferences = 
        context.getSharedPreferences("boutique_prefs", Context.MODE_PRIVATE)
    
    fun saveUserData(userId: String, email: String, name: String? = null) {
        with(sharedPref.edit()) {
            putString("user_id", userId)
            putString("user_email", email)
            name?.let { putString("user_name", it) }
            putBoolean("is_logged_in", true)
            apply()
        }
    }
    
    fun getUserEmail(): String? {
        return sharedPref.getString("user_email", null)
    }
    
    fun isLoggedIn(): Boolean {
        return sharedPref.getBoolean("is_logged_in", false)
    }
    
    fun clearUserData() {
        with(sharedPref.edit()) {
            remove("user_id")
            remove("user_email")
            remove("user_name")
            putBoolean("is_logged_in", false)
            apply()
        }
    }
}