package es.isaaccabriadiez.ejercicio_6.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.findNavController
import es.isaaccabriadiez.ejercicio_6.R

class FragmentInicio : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val botonVisita = view.findViewById<Button>(R.id.botonVisitaGuiada)
        botonVisita.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentPersonas)
        }
    }

}