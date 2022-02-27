package co.edu.udea.compumovil.gr10.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity2 : AppCompatActivity() {
    var sugerencias = arrayOf("Argentina", "Bolivia", "Brasil", "Chile", "Colombia", "Costa Rica", "Cuba", "Ecuador", "El Salvador", "Guatemala", "Honduras", "México", "Nicaragua", "Panamá", "Paraguay", "Perú", "Puerto Rico", "República Dominicana", "Uruguay", "Venezuela")
    var ciudades = arrayOf("Bogota", "Medellin", "Cali", "Barranquilla", "Cartagena de indias", "Soacha", "Cucuta", "Soledad", "Bucaramanga", "Bello", "Villavicencio", "Ibagué", "Santa Marta", "Valledupar", "Manizales", "Pereira", "Monteria", "Neiva", "Pasto", "Armenia")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contactdataactivity)

        var adapter = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        var adapterArray = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item, sugerencias)

        adapter.setAdapter(adapterArray)
        adapter.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext,"clicked item = "+sugerencias[position], Toast.LENGTH_SHORT).show()
        })
        var adaptor = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView2)
        var list = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item, ciudades)
        adaptor.setAdapter(list)
        adaptor.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext,"clicked item = "+ciudades[position], Toast.LENGTH_SHORT).show()
        })
    }

    fun siguienteActividad(view: View) {

        var telefono = findViewById<EditText>(R.id.editTextTextPersonName3)
        var dirección = findViewById<EditText>(R.id.editText3)
        var email = findViewById<EditText>(R.id.editTextTextPersonName)
        var pais = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        var ciudad = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView2)
        Log.e(getString(R.string.tel) ,  telefono.text.toString())
        Log.e(getString(R.string.dir), dirección.text.toString())
        Log.e(getString(R.string.email), email.text.toString())
        Log.e(getString(R.string.pais), pais.text.toString())
        Log.e(getString(R.string.ciudad), ciudad.text.toString())

    }

}
