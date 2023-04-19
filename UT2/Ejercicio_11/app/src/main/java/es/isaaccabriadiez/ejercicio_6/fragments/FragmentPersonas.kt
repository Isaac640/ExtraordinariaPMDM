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
import es.isaaccabriadiez.ejercicio_6.databinding.FragmentPersonasBinding

class FragmentPersonas : Fragment() {
    private lateinit var binding: FragmentPersonasBinding
    private val viewModelCompartido: ReservaZooViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPersonasBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//Establecemos el viewModel definido en el layout (ver explicación)
        binding.viewModel = viewModelCompartido
        binding.lifecycleOwner = viewLifecycleOwner

        binding.numberPickerAdultos.apply {
            minValue = 0
            maxValue = 5
            value = 1
            wrapSelectorWheel = false
            setOnValueChangedListener { _, _, nuevo
                ->
                viewModelCompartido.setNumeroAdultos(nuevo)
            }
        }
        binding.numberPickerNinos.apply {
            minValue = 0
            maxValue = 5
            value = 1
            wrapSelectorWheel = false
            setOnValueChangedListener { _, _, nuevo
                ->
                viewModelCompartido.setNumeroNinos(nuevo)
            }
        }

        val botonSiguiente = view.findViewById<Button>(R.id.botonSiguiente)
        botonSiguiente.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentFecha)
        }
    }
}