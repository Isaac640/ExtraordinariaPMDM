package es.isaaccabriadiez.ejercicio_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import es.isaaccabriadiez.ejercicio_6.modelo.AnimalAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAnimales)
        val botonAnadir = findViewById<FloatingActionButton>(R.id.boton_aniadir)

        //Establecer el adapter y layout
        recyclerView.adapter = AnimalAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Separador en el recyclerView
        recyclerView.addItemDecoration(
            DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
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
                val nuevoAnimal = inputEditTextField.text.toString()
                (recyclerView.adapter as AnimalAdapter).addAnimal(nuevoAnimal)
            }
            .setNegativeButton("Cancelar", null)
            .create()
        dialog.show()
    }

}