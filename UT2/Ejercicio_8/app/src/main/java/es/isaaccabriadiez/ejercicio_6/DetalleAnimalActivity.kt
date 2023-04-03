package es.isaaccabriadiez.ejercicio_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.isaaccabriadiez.ejercicio_6.databinding.ActivityDetalleAnimalBinding
import es.isaaccabriadiez.ejercicio_6.datos.Animal

class DetalleAnimalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleAnimalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animal = intent.extras?.get("animal") as Animal

        binding.apply {
            textViewNombreAnimal.text = animal.nombre
            textViewDescripcionAnimal.text = animal.descripcion
            imageView.setImageResource(animal.imagenId)
        }
    }
}