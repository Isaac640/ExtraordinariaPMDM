package es.isaaccabriadiez.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import es.isaaccabriadiez.myapplication.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    var contador: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonContar.setOnClickListener {
            val contador = contador++
            binding.textView.text = contador.toString()
            Toast.makeText(this, "Se ha  pulsado el botón " +
            "$contador veces", Toast.LENGTH_SHORT).show()
        }

    }
}

