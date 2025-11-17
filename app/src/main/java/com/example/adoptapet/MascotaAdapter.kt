package com.example.adoptapet

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MascotaAdapter(
    private val context: Context,
    private var listaMascotas: List<Mascota>
) : RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_mascota, parent, false)
        return MascotaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        val mascota = listaMascotas[position]

        holder.nombre.text = mascota.nombre
        holder.raza.text = mascota.raza
        holder.edad.text = mascota.edad

        // ✅ Cargar imagen local desde drawable
        val resId = context.resources.getIdentifier(
            mascota.imagen.lowercase(),
            "drawable",
            context.packageName
        )

        Glide.with(context)
            .load(if (resId != 0) resId else R.drawable.ic_paw) // fallback
            .placeholder(R.drawable.ic_paw)
            .error(R.drawable.ic_paw)
            .into(holder.imagen)

        // ✅ Abrir detalle
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetalleActivity::class.java)
            intent.putExtra("nombre", mascota.nombre)
            intent.putExtra("edad", mascota.edad)
            intent.putExtra("raza", mascota.raza)
            intent.putExtra("imagen", mascota.imagen)
            intent.putExtra("historia", mascota.historia)
            context.startActivity(intent)
        }

        // ❤️ Botón de favorito
        holder.btnFavorito.setOnClickListener {
            val isFavorite = it.tag == "favorite"
            if (isFavorite) {
                holder.btnFavorito.setImageResource(R.drawable.ic_favorite_border)
                it.tag = "not_favorite"
            } else {
                holder.btnFavorito.setImageResource(R.drawable.ic_favorite_filled)
                it.tag = "favorite"
            }
        }
    }

    override fun getItemCount(): Int = listaMascotas.size

    fun actualizarLista(nuevaLista: List<Mascota>) {
        listaMascotas = nuevaLista
        notifyDataSetChanged()
    }

    class MascotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.txtNombreMascota)
        val edad: TextView = itemView.findViewById(R.id.tvEdad)
        val raza: TextView = itemView.findViewById(R.id.txtRazaMascota)
        val imagen: ImageView = itemView.findViewById(R.id.imagenMascota)
        val btnFavorito: ImageButton = itemView.findViewById(R.id.btnFavorito)
    }
}

