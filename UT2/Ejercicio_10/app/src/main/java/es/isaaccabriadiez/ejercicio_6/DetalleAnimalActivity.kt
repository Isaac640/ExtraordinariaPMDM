package es.isaaccabriadiez.ejercicio_6

import android.content.Intent
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

        binding.botonPos.setOnClickListener{
            crearIntentMain(animal, 1);
        }

        binding.botonNeg.setOnClickListener{
            crearIntentMain(animal, -1);
        }
    }


    fun crearIntentMain(animal: Animal, voto: Int)
    {
        val intentDevuelto = Intent()
        intentDevuelto.putExtra("voto", voto)
        intentDevuelto.putExtra("animal", animal.nombre)
        setResult(RESULT_OK, intentDevuelto)
        finish()
    }
}