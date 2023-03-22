package es.isaaccabriadiez.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val botonContar = findViewById<Button>(R.id.botonContar)
    var contador: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.botonContar.setOnClickListener {
            contador++
            binding.textView.text = contador.toString()
        }

    fun contar(texto: String){
        contador = contador+1
        Toast.makeText(this, "Has pulsado el boton $texto", Toast.LENGTH_SHORT).show()
    }

    fun contador
}

