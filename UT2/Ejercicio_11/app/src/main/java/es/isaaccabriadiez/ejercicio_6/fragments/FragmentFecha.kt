package es.isaaccabriadiez.ejercicio_6.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import es.isaaccabriadiez.ejercicio_6.modelo.ReservaZooViewModel
import es.isaaccabriadiez.ejercicio_6.R
import es.isaaccabriadiez.ejercicio_6.databinding.FragmentFechaBinding
import java.util.Calendar

class FragmentFecha : Fragment() {

    private lateinit var binding: FragmentFechaBinding
    private val viewModelCompartido: ReservaZooViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFechaBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModelCompartido
        binding.lifecycleOwner = viewLifecycleOwner
        val hoy = Calendar.getInstance()
        binding.datePicker.init(hoy.get(Calendar.YEAR), hoy.get(Calendar.MONTH),
            hoy.get(Calendar.DAY_OF_MONTH))
        { _, year, month, day ->
            var fecha = Calendar.getInstance()
            fecha.set(year, month, day)
            viewModelCompartido.setFecha(fecha)
        }

        val botonSiguiente = view.findViewById<Button>(R.id.botonSiguiente)
        botonSiguiente.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentResumen)
        }
    }


}