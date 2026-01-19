package bf.amido.sawadogo.boutique.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Test sans layout
        Toast.makeText(this, "MainActivity lancé", Toast.LENGTH_LONG).show()
        
        // Si le Toast s'affiche, le problème est dans les layouts
        // Si crash, le problème est ailleurs
    }
