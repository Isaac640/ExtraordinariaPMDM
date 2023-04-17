package es.isaaccabriadiez.ejercicio_6.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import es.isaaccabriadiez.ejercicio_6.R
import es.isaaccabriadiez.ejercicio_6.databinding.FragmentPersonasBinding
import es.isaaccabriadiez.ejercicio_6.databinding.FragmentPersonasBinding.inflate

class FragmentPersonas : Fragment() {
    private lateinit var binding: FragmentPersonasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.numberPickerAdultos.apply {
            minValue = 0
            maxValue = 5
            value = 1
            wrapSelectorWheel = false
        }
        binding.numberPickerNinos.apply {
            minValue = 0
            maxValue = 5
            value = 0
            wrapSelectorWheel = false
        }

        val botonSiguiente = view.findViewById<Button>(R.id.botonSiguiente)
        botonSiguiente.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentFecha)
        }
    }
}