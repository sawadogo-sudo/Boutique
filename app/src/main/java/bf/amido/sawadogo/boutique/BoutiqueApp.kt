package bf.amido.sawadogo.boutique

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        Toast.makeText(this, "Bienvenue!", Toast.LENGTH_SHORT).show()
        
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        
        btnLogin.setOnClickListener {
            Toast.makeText(this, "Login à venir...", Toast.LENGTH_SHORT).show()
        }
        
        btnRegister.setOnClickListener {
            // Naviguer vers RegisterActivity
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}