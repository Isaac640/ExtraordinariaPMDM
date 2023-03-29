package es.isaaccabriadiez.ejercicio_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import es.isaaccabriadiez.ejercicio_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val switchIVA = findViewById<Switch>(R.id.switch_IVA)
        val imageDestino = findViewById<ImageView>(R.id.imageViewDestino)
        val botonMostrar = findViewById<Button>(R.id.botonMostrar)

        precioRadio(radioGroup.checkedRadioButtonId, switchIVA.isChecked)

        radioGroup.setOnCheckedChangeListener { radioGroup, opcion ->
            precioRadio(opcion, switchIVA.isChecked)
        }

        //Se usa el checkedRadioButtonId del radioGroup para que devuelva el id de RADIOBUTTON
        botonMostrar.setOnClickListener{
            imagenDeDestino(radioGroup.checkedRadioButtonId, imageDestino)
        }

        switchIVA.setOnCheckedChangeListener { compoundButton, b ->
            precioRadio(radioGroup.checkedRadioButtonId, switchIVA.isChecked)
        }
    }


    private fun precioRadio(radioButtonId: Int, iva: Boolean){
        val precioFinalText = findViewById<TextView>(R.id.precio_final)
        val precio = calcularPrecio(radioButtonId, iva)
        //Formatear a 1.00
        precioFinalText.text = "${String.format("%.2f", precio)} €"

        //En funcion de si el precio es mayor al presupuesto que se ha dado, se cambia el color
        val presupuestoEditText = findViewById<EditText>(R.id.presupuesto)
        val presupuesto = presupuestoEditText.text.toString().toDoubleOrNull()

        if (presupuesto != null) {
            if(presupuesto>precio)
                precioFinalText.setTextColor(getColor(R.color.verde))
            else
                precioFinalText.setTextColor(getColor(R.color.rojo))
        }
    }

    private fun imagenDeDestino(radioButtonId: Int, imageView: ImageView){
        when(radioButtonId){
            R.id.opcion_peninsula -> imageView.setImageResource(R.drawable.costa_peninsular)
            R.id.opcion_islas -> imageView.setImageResource(R.drawable.costa_insular)
            R.id.opcion_interior -> imageView.setImageResource(R.drawable.turismo_interior)
        }
    }

    private fun calcularPrecio(radioButtonId: Int, iva: Boolean): Double{
        var precio: Double = when(radioButtonId){
            R.id.opcion_peninsula -> 600.00
            R.id.opcion_islas -> 900.00
            else -> 520.00
        }
        //Si tiene iva se multiplica el precio por 1.21
        if (iva)
            precio *= 1.21

        return precio

    }

}