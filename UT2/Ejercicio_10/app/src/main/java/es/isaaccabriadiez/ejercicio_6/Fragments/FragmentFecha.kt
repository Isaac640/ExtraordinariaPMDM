package es.isaaccabriadiez.ejercicio_6.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import es.isaaccabriadiez.ejercicio_6.R
import es.isaaccabriadiez.ejercicio_6.databinding.FragmentFechaBinding
import java.util.Calendar

class FragmentFecha : Fragment() {

    private lateinit var binding: FragmentFechaBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val hoy = Calendar.getInstance()
        binding.datePicker.init(
            hoy.get(Calendar.YEAR), hoy.get(Calendar.MONTH),
            hoy.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val mensaje = "Fecha: $day/${month + 1}/$year"
            Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
        }

        val botonSiguiente = view.findViewById<Button>(R.id.botonSiguiente)
        botonSiguiente.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentPersonas)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fecha, container, false)
    }


}