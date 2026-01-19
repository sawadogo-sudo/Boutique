package bf.amido.sawadogo.boutique 
 
import android.os.Bundle 
import android.widget.Toast 
import androidx.appcompat.app.AppCompatActivity 
 
class MainActivity : AppCompatActivity() { 
    override fun onCreate(savedInstanceState: Bundle?) { 
        super.onCreate(savedInstanceState) 
        setContentView(R.layout.activity_main) 
 
        // Affiche un message de confirmation 
        Toast.makeText(this, "Boutique App Lancée!", Toast.LENGTH_LONG).show() 
    } 
} 
