package com.example.actividad1_m5_pm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.actividad1_m5_pm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var mbinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inflar la vista
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)
        mbinding.botonPerfil.setOnClickListener {
            generarPerfil()
        }

    }


    private fun generarPerfil() {

        val nombre = mbinding.editNombre.text.toString().trim()
        val edadTexto = mbinding.editEdad.text.toString().trim()



        if(nombre.isEmpty() || edadTexto.isEmpty()){

            mbinding.textResultado.text ="Por Favor complete todos los campos"
            return
        }
        val edad = edadTexto.toIntOrNull()
        if(edad == null || edad <=0){

            mbinding.textResultado.text ="Edad invalida"
        }

        val profesion  = when (mbinding.radioGrupoProfesion.checkedRadioButtonId){


            R.id.radioEstudiante ->" Estudiante"
            R.id.radioDesarrollador -> "Desarrollador"
            R.id.radioProfesor -> "Profesor/a"
            else -> "Sin Especificar"
        }


        val mensaje = when{


            edad in 16 ..18 -> "Hola $nombre! Eres un/A Joven $profesion "
            edad in 18 .. 25 ->"¡Hola $nombre! ✨ Un/a $profesion en plena formación"
            edad in 26 ..40 -> "¡Hola $nombre! 💼 Profesional activo/a como $profesion"
            else -> "¡Hola $nombre! 🎓 Con experiencia como $profesion"





        }
        mbinding.textResultado.text = mensaje
    }


}




