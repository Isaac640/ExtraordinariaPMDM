package es.isaaccabriadiez.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val datos = linkedMapOf<String, Int>(
        "Isaac" to R.drawable.avatar3,
        "María" to R.drawable.avatar1,
        "Rosa" to R.drawable.avatar2,
        "Pepe" to R.drawable.avatar4
    )

    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boton = findViewById<Button>(R.id.button)
        val texto = findViewById<TextView>(R.id.textView)
        val imagen = findViewById<ImageView>(R.id.imageView)
        boton.setOnClickListener{
            cambiaImagenTexto(texto, imagen)
        }
    }

    private fun cambiaImagenTexto(textView: TextView, imageView: ImageView){
        contador++;
        contador%datos.size
        val texto = datos.keys.elementAt(contador)
        textView.text = texto
        imageView.setImageResource(datos[texto]!!)

        if(contador == 3){
            contador = 0
        }
        Toast.makeText(this, "Has cambiado el valor a $texto", Toast.LENGTH_SHORT).show()
    }
}