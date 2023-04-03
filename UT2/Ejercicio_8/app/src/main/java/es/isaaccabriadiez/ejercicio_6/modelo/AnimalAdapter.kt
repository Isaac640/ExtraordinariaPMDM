package es.isaaccabriadiez.ejercicio_6.modelo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.isaaccabriadiez.ejercicio_6.R
import es.isaaccabriadiez.ejercicio_6.datos.Animal
import es.isaaccabriadiez.ejercicio_6.datos.datos

class AnimalAdapter(private val onClickAdapter: (Animal) -> Unit) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>()
{
    private val listaAnimales = datos.getDatosAnimales()

    class AnimalViewHolder(view: View,private val onClickHolder: (Int) -> Unit): RecyclerView.ViewHolder(view) {
        val textViewNombreAnimal = view.findViewById<TextView>(R.id.textViewNombreAnimal)
        val imagenAnimal = view.findViewById<ImageView>(R.id.imagenAnimal)

        init {
            view.setOnClickListener { onClickHolder(adapterPosition) }
        }
    }

    //adapta el item_animal.xml que es lo que deberia estar en el recyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)

        //realiza el metodo dependiendo en posicion del recyclerView esta
        return AnimalViewHolder(adapterLayout
        ) { pos -> onClickAdapter(listaAnimales[pos]) }
    }

    //Coloca cada animal en el orden que esta en el ArrayList de los datos de animales
    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = listaAnimales[position]
        holder.textViewNombreAnimal.text = animal.nombre
        holder.imagenAnimal.setImageResource(animal.imagenId)
    }

    //Obtiene la cantidad de animales de la lista
    override fun getItemCount(): Int = listaAnimales.size

    //Metodo de añadir un animal
    fun addAnimal(animal: Animal) {
        listaAnimales.add(animal)
        notifyDataSetChanged()
    }
}
