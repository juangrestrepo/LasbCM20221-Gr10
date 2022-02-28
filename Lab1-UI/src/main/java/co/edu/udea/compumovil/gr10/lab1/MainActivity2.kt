package co.edu.udea.compumovil.gr10.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.View.OnKeyListener
import android.widget.*

class MainActivity2 : AppCompatActivity() {
    var sugerencias = arrayOf("Argentina", "Bolivia", "Brasil", "Chile", "Colombia", "Costa Rica", "Cuba", "Ecuador", "El Salvador", "Guatemala", "Honduras", "México", "Nicaragua", "Panamá", "Paraguay", "Perú", "Puerto Rico", "República Dominicana", "Uruguay", "Venezuela")
    var ciudades = arrayOf("Bogota", "Medellin", "Cali", "Barranquilla", "Cartagena de indias", "Soacha", "Cucuta", "Soledad", "Bucaramanga", "Bello", "Villavicencio", "Ibagué", "Santa Marta", "Valledupar", "Manizales", "Pereira", "Monteria", "Neiva", "Pasto", "Armenia")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contactdataactivity)

        var adapterPaises = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        var adapterArrayPaises = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item, sugerencias)
        var botonSiguiente = findViewById<Button>(R.id.button)

        adapterPaises.setAdapter(adapterArrayPaises)
        adapterPaises.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext,"escogió Pais = "+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
        })

        var adapterCiudades = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView2)
        var adapterArrayCiudades = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item, ciudades)
        adapterCiudades.setAdapter(adapterArrayCiudades)
        adapterCiudades.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext,"escogió ciudad = "+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
        })

        adapterPaises.setOnKeyListener(OnKeyListener { _, i, keyEvent ->
            if(i == KeyEvent.KEYCODE_ENTER && keyEvent.action == KeyEvent.ACTION_UP){
                adapterCiudades.requestFocus()
                return@OnKeyListener true
            }
            false
        })

        adapterCiudades.setOnKeyListener(OnKeyListener { _, i, keyEvent ->
            if(i == KeyEvent.KEYCODE_ENTER && keyEvent.action == KeyEvent.ACTION_UP){
                siguienteActividad(botonSiguiente)
                return@OnKeyListener true
            }
            false
        })

    }

    fun siguienteActividad(view: View) {


        var telefono = findViewById<EditText>(R.id.editTextTextPersonName3)
        var direccion = findViewById<EditText>(R.id.editText3)
        var email = findViewById<EditText>(R.id.editTextTextPersonName)
        var pais = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        var ciudad = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView2)

// validaciones de los campos de texto en donde saca mensaje por medio de toats
        if (telefono.text.trim().isEmpty()) {

            Toast.makeText(applicationContext, getString(R.string.escribatelefono), Toast.LENGTH_SHORT).show()
            telefono.requestFocus()
            return
        }
        if (direccion.text.trim().isEmpty()) {

            Toast.makeText(applicationContext, getString(R.string.escribadireccion), Toast.LENGTH_SHORT).show()
            direccion.requestFocus()
            return
        }
        if (email.text.trim().isEmpty()) {

            Toast.makeText(applicationContext, getString(R.string.escribaemail), Toast.LENGTH_SHORT).show()
            email.requestFocus()
            return
        }
        if (pais.text.trim().isEmpty() || !sugerencias.contains(pais.text.toString())) {
            Toast.makeText(applicationContext, getString(R.string.copiarpais), Toast.LENGTH_SHORT).show()
            pais.requestFocus()
            return
        }
        if (ciudad.text.trim().isEmpty() || !ciudades.contains(ciudad.text.toString())) {
            Toast.makeText(applicationContext, getString(R.string.copiarciudad), Toast.LENGTH_SHORT).show()

            ciudad.requestFocus()
            return
        }
        Toast.makeText(applicationContext, "Procesando...", Toast.LENGTH_SHORT).show()
//muestra en la terminal logcat la informacion ingresada por el usuario
        Log.e(getString(R.string.tel) ,  telefono.text.toString())
        Log.e(getString(R.string.dir), direccion.text.toString())
        Log.e(getString(R.string.email), email.text.toString())
        Log.e(getString(R.string.pais), pais.text.toString())
        Log.e(getString(R.string.ciudad), ciudad.text.toString())

    }

}
