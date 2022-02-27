package co.edu.udea.compumovil.gr10.lab1

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // access the items of the list
        val languages = resources.getStringArray(R.array.Languages)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View?, position: Int, id: Long) {

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        val textView: TextView  = findViewById(R.id.txtFecha)
        val btn: Button = findViewById(R.id.btnCambiarFecha)
        textView.text = getString(R.string.nacido)

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            textView.text = sdf.format(cal.time)

        }

        btn.setOnClickListener {
            DatePickerDialog(this@MainActivity, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    fun nextActivity(view: android.view.View?) {
        val nombre = findViewById<TextView>(R.id.txtNombre)
        val apellido = findViewById<TextView>(R.id.txtApellido)
        val sexo_fem = findViewById<RadioButton>(R.id.radio_femenino)
        val sexo_mas = findViewById<RadioButton>(R.id.radio_masculino)
        val fecha = findViewById<TextView>(R.id.txtFecha)
        val grado = findViewById<Spinner>(R.id.spinner)
        var sexo = ""
        if (sexo_fem.isChecked){
            sexo = getString(R.string.m)
        }else if (sexo_mas.isChecked){
            sexo = getString(R.string.h)
        }

        Log.e("a",getString(R.string.info))
        Log.e("a",nombre.text.toString()+" "+apellido.text.toString())
        if(sexo != ""){
            Log.e("a",sexo)
        }
        Log.e("a",getString(R.string.nacio)+" "+fecha.text.toString())
        if(grado.selectedItem.toString() != ""){
            Log.e("a", grado.selectedItem.toString())
        }

        val intent = Intent(this, MainActivity2::class.java)
        //intent.putExtra("key", value)
        startActivity(intent)
    }
}
