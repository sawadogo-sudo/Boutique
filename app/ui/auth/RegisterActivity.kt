package bf.amido.sawadogo.boutique.ui.auth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import bf.amido.sawadogo.boutique.R
import bf.amido.sawadogo.boutique.data.supabase.AuthRepository

class RegisterActivity : AppCompatActivity() {
    
    private lateinit var authRepository: AuthRepository
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        
        authRepository = AuthRepository(this)
        
        val etName = findViewById<android.widget.EditText>(R.id.etName)
        val etEmail = findViewById<android.widget.EditText>(R.id.etEmail)
        val etPassword = findViewById<android.widget.EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<android.widget.EditText>(R.id.etConfirmPassword)
        val btnRegister = findViewById<android.widget.Button>(R.id.btnRegister)
        val tvLogin = findViewById<android.widget.TextView>(R.id.tvLogin)
        
        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()
            
            if (validateInput(
                    etName, etEmail, etPassword, etConfirmPassword,
                    name, email, password, confirmPassword
                )) {
                authRepository.register(email, password, name) { success, message ->
                    runOnUiThread {
                        if (success) {
                            Toast.makeText(this, "Compte créé!", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            Toast.makeText(this, "Erreur: $message", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
        
        tvLogin.setOnClickListener { finish() }
    }
    
    private fun validateInput(
        etName: android.widget.EditText,
        etEmail: android.widget.EditText,
        etPassword: android.widget.EditText,
        etConfirmPassword: android.widget.EditText,
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        var isValid = true
        
        etName.error = null
        etEmail.error = null
        etPassword.error = null
        etConfirmPassword.error = null
        
        if (name.isEmpty()) {
            etName.error = "Nom requis"
            isValid = false
        }
        
        if (email.isEmpty()) {
            etEmail.error = "Email requis"
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.error = "Email invalide"
            isValid = false
        }
        
        if (password.isEmpty()) {
            etPassword.error = "Mot de passe requis"
            isValid = false
        } else if (password.length < 6) {
            etPassword.error = "6 caractères minimum"
            isValid = false
        }
        
        if (confirmPassword.isEmpty()) {
            etConfirmPassword.error = "Confirmation requise"
            isValid = false
        } else if (password != confirmPassword) {
            etConfirmPassword.error = "Mots de passe différents"
            isValid = false
        }
        
        return isValid
    }
}