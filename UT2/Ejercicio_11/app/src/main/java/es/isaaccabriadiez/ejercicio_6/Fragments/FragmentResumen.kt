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
import es.isaaccabriadiez.ejercicio_6.databinding.FragmentResumenBinding

class FragmentResumen : Fragment() {
    private lateinit var binding: FragmentResumenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResumenBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val botonReservar = view.findViewById<Button>(R.id.botonReservar)
        botonReservar.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentInicio)
        }
    }
}