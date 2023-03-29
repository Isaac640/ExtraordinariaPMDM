package es.isaaccabriadiez.ejercicio_6.modelo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.isaaccabriadiez.ejercicio_6.R
import es.isaaccabriadiez.ejercicio_6.datos.datos

class AnimalAdapter: RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>()
{
    private val listaAnimales = datos.getDatosAnimales()

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val textViewNombreAnimal = view.findViewById<TextView>(R.id.textViewNombreAnimal)

    }

    //adapta el item_animal.xml que es lo que deberia estar en el recyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(adapterLayout)
    }

    //Coloca cada animal en el orden que esta en el ArrayList de los datos de animales
    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = listaAnimales[position]
        holder.textViewNombreAnimal.text = animal
    }

    //Obtiene la cantidad de animales de la lista
    override fun getItemCount(): Int = listaAnimales.size

    //Metodo de añadir un animal
    fun addAnimal(animal: String)
    {
        listaAnimales.add(animal)
        notifyDataSetChanged()
    }
}
