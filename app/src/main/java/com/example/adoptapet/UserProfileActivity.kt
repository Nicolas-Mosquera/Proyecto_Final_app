package com.example.adoptapet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class UserProfileActivity : AppCompatActivity() {

    private lateinit var txtNombre: TextView
    private lateinit var txtEmail: TextView
    private lateinit var txtTelefono: TextView
    private lateinit var btnBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        btnBack = findViewById(R.id.btnBack)
        txtNombre = findViewById(R.id.txtNombre)
        txtEmail = findViewById(R.id.txtEmail)
        txtTelefono = findViewById(R.id.txtTelefono)

        // Volver atrás
        btnBack.setOnClickListener {
            finish()
        }

        cargarDatosUsuario()
    }

    private fun cargarDatosUsuario() {
        FirebaseFirestore.getInstance()
            .collection("User")
            .limit(1)   // Tomar solo el primer documento
            .get()
            .addOnSuccessListener { result ->
                if (!result.isEmpty) {
                    val usuario = result.documents[0].toObject(User::class.java)
                    txtNombre.text = usuario?.nombre ?: "No definido"
                    txtEmail.text = usuario?.email ?: "No definido"
                    txtTelefono.text = usuario?.telefono ?: "No definido"
                } else {
                    txtNombre.text = "No definido"
                    txtEmail.text = "No definido"
                    txtTelefono.text = "No definido"
                }
            }
            .addOnFailureListener {
                txtNombre.text = "Error"
                txtEmail.text = "Error"
                txtTelefono.text = "Error"
            }
    }
}

