package com.example.adoptapet

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import android.widget.ImageView
import android.widget.TextView

class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val imgDetalle: ImageView = findViewById(R.id.imgDetalle)
        val tvNombre: TextView = findViewById(R.id.tvNombreDetalle)
        val tvRaza: TextView = findViewById(R.id.tvRazaDetalle)
        val tvEdad: TextView = findViewById(R.id.tvEdadDetalle)
        val tvHistoria: TextView = findViewById(R.id.tvHistoria)

        val btnVolver: ImageButton = findViewById(R.id.btnVolver)

        val nombre = intent.getStringExtra("nombre")
        val raza = intent.getStringExtra("raza")
        val edad = intent.getStringExtra("edad")
        val imagen = intent.getStringExtra("imagen")
        val historia = intent.getStringExtra("historia")


        tvNombre.text = nombre
        tvRaza.text = raza
        tvEdad.text = edad
        tvHistoria.text = historia




        // Cargar imagen con Glide (URL o recurso local)
        if (imagen != null) {
            if (imagen.startsWith("http")) {
                Glide.with(this)
                    .load(imagen)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(imgDetalle)
            } else {
                val resId = resources.getIdentifier(imagen, "drawable", packageName)
                if (resId != 0) {
                    imgDetalle.setImageResource(resId)
                } else {
                    imgDetalle.setImageResource(R.drawable.ic_launcher_foreground)
                }

                btnVolver.setOnClickListener {
                    finish()
                }


            }
        }


        }
    }





