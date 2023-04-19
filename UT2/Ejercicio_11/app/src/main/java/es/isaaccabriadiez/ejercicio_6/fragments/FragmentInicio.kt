package es.isaaccabriadiez.ejercicio_6.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import es.isaaccabriadiez.ejercicio_6.modelo.ReservaZooViewModel
import es.isaaccabriadiez.ejercicio_6.R
import es.isaaccabriadiez.ejercicio_6.databinding.FragmentInicioBinding

class FragmentInicio : Fragment() {
    private lateinit var binding: FragmentInicioBinding
    private val viewModelCompartido: ReservaZooViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            botonZoologico.setOnClickListener { tipoVisita("Zoológico") }
            botonReptario.setOnClickListener { tipoVisita("Reptario") }
            botonVisitaGuiada.setOnClickListener { tipoVisita("Visita guiada") }
        }

        val botonVisita = view.findViewById<Button>(R.id.botonVisitaGuiada)
        botonVisita.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentPersonas)
        }
    }

    fun tipoVisita(tipo: String)
    {
        viewModelCompartido.setTipoReserva(tipo)
        findNavController().navigate(R.id.action_fragmentInicio_to_fragmentPersonas)
    }


}