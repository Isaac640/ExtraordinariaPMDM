package es.isaaccabriadiez.ejercicio_6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import es.isaaccabriadiez.ejercicio_6.datos.Animal
import es.isaaccabriadiez.ejercicio_6.modelo.AnimalAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    private val segundaActivityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if (it.resultCode == Activity.RESULT_OK){
                val voto = it.data?.getIntExtra("voto", 0)?:0
                val nombre = it.data?.getStringExtra("animal")?:""
                (recyclerView.adapter as AnimalAdapter).cambiarVoto(nombre, voto)
                recyclerView.adapter?.notifyDataSetChanged()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAnimales)
        val botonAnadir = findViewById<FloatingActionButton>(R.id.boton_aniadir)

        //Establecer el adapter y layout
        recyclerView.adapter = AnimalAdapter() { animal -> onClickAnimal(animal) }
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Separador en el recyclerView
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        //Añade un animal al pulsarse
        botonAnadir.setOnClickListener {
            dialogoNuevoAnimal()
        }
    }

    //Crea un cuadro de dialogo y pregunta el nombre del animal a añadir
    private fun dialogoNuevoAnimal() {
        val inputEditTextField = EditText(this)
        val dialog = MaterialAlertDialogBuilder(this)
            .setTitle("Nuevo animal")
            .setMessage("Introduce el nombre de un nuevo animal")
            .setView(inputEditTextField)
            .setPositiveButton("Añadir") { _, _ ->
                val nuevoAnimal = Animal(
                    inputEditTextField.text.toString(), R.drawable.desconocido,"No hay detalles para este animal", 0)
                (recyclerView.adapter as AnimalAdapter).addAnimal(nuevoAnimal)
            }
            .setNegativeButton("Cancelar", null)
            .create()
        dialog.show()
    }

    private fun onClickAnimal(animal: Animal) {
        //Toast.makeText(this, animal.descripcion, Toast.LENGTH_LONG).show()
        val intent = Intent(applicationContext, DetalleAnimalActivity::class.java)
        intent.putExtra("animal", animal)
        segundaActivityLauncher.launch(intent)
    }


}

