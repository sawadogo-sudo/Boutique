package bf.amido.sawadogo.boutique.ui.auth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import bf.amido.sawadogo.boutique.R
import bf.amido.sawadogo.boutique.data.supabase.AuthRepository
import android.widget.EditText
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    
    private lateinit var authRepository: AuthRepository
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val tvRegister: TextView = findViewById(R.id.tvRegister)
        
        authRepository = AuthRepository(this)
        
        btnLogin.setOnClickListener { login() }
        tvRegister.setOnClickListener {
            // Ouvrir RegisterActivity
            startActivity(android.content.Intent(this, RegisterActivity::class.java))
        }
    }
    
    private fun login() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString()
        
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
            return
        }
        
        authRepository.login(email, password) { success, message ->
            runOnUiThread {
                if (success) {
                    Toast.makeText(this, "Connexion réussie!", Toast.LENGTH_SHORT).show()
                    // Rediriger vers l'activité principale
                    // startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Erreur: $message", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}