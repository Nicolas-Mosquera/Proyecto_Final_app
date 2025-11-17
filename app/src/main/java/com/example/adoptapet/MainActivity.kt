package com.example.adoptapet

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore
import android.content.Intent
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerMascotas: RecyclerView
    private lateinit var searchBar: EditText
    private lateinit var adapter: MascotaAdapter
    private val db = FirebaseFirestore.getInstance()
    private var listaMascotas = mutableListOf<Mascota>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerMascotas = findViewById(R.id.recyclerMascotas)
        searchBar = findViewById(R.id.searchBar)
        recyclerMascotas.layoutManager = LinearLayoutManager(this)

        val btnProfile = findViewById<ImageView>(R.id.btnPerfil)
        btnProfile.setOnClickListener {
            val intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }

        cargarMascotas()

        // Filtrar mientras escribe
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filtrarMascotas(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun cargarMascotas() {
        db.collection("mascotas")
            .get()
            .addOnSuccessListener { result ->
                listaMascotas = result.toObjects(Mascota::class.java)
                adapter = MascotaAdapter(this, listaMascotas)
                recyclerMascotas.adapter = adapter
            }
    }

    private fun filtrarMascotas(texto: String) {
        val filtradas = listaMascotas.filter {
                it.nombre.contains(texto, ignoreCase = true) ||
                    it.raza.contains(texto, ignoreCase = true)
        }
        adapter.actualizarLista(filtradas)
    }
}

