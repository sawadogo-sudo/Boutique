package bf.amido.sawadogo.boutique.data.supabase

import android.content.Context
import android.content.SharedPreferences

class AuthRepository(private val context: Context) {
    
    private val sharedPref: SharedPreferences = 
        context.getSharedPreferences("boutique_prefs", Context.MODE_PRIVATE)
    
    fun login(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        // Simulation simple - À REMPLACER PAR SUPABASE PLUS TARD
        if (email.isNotEmpty() && password.isNotEmpty()) {
            sharedPref.edit()
                .putString("user_email", email)
                .putBoolean("is_logged_in", true)
                .apply()
            
            onResult(true, "Connexion réussie")
        } else {
            onResult(false, "Email ou mot de passe vide")
        }
    }
    
    fun register(email: String, password: String, name: String, onResult: (Boolean, String?) -> Unit) {
        // Simulation simple - À REMPLACER PAR SUPABASE PLUS TARD
        if (email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty()) {
            sharedPref.edit()
                .putString("user_email", email)
                .putString("user_name", name)
                .putBoolean("is_logged_in", true)
                .apply()
            
            onResult(true, "Compte créé avec succès")
        } else {
            onResult(false, "Tous les champs sont requis")
        }
    }
}