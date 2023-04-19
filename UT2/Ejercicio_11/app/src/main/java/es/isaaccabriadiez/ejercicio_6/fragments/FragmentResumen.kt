package es.isaaccabriadiez.ejercicio_6.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import es.isaaccabriadiez.ejercicio_6.modelo.ReservaZooViewModel
import es.isaaccabriadiez.ejercicio_6.R
import es.isaaccabriadiez.ejercicio_6.databinding.FragmentResumenBinding

class FragmentResumen : Fragment() {
    private lateinit var binding: FragmentResumenBinding
    private val viewModelCompartido: ReservaZooViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResumenBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewModel = viewModelCompartido
        //No hace falta ya que no se modifica ningún dato en la UI
        //binding.lifecycleOwner = viewLifecycleOwner
        binding.botonReservar.setOnClickListener{
            Toast.makeText(context, "Se ha realizado la reserva", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.fragmentInicio)
        }
    }
}