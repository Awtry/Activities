package com.awtry.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Detalle : AppCompatActivity() {


    private lateinit var Le_Foto: INFO_FOTO
    private var No_Foto: Int = 0
    private var Mi_Fav: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        Le_Foto = intent.getParcelableExtra("Mi_Fotito") ?: INFO_FOTO()
        No_Foto = intent.getIntExtra("No_Foto", 0)
        Mi_Fav = Le_Foto.Mi_favorito

        initviews()
        Disparador_Boton_Detalle()
    }

    //region iniciador

    private lateinit var txtDetalle: TextView
    private lateinit var btnFAV: ImageView
    private lateinit var IMG_Detalle: ImageView

    //endregion




    private fun initviews(){
        IMG_Detalle = findViewById(R.id.IMG_DETALLE)
        btnFAV = findViewById(R.id.btn_favorito)
        txtDetalle = findViewById(R.id.txv_Detalle)

        //Muestra imagen viajera
        IMG_Detalle.setImageResource(Le_Foto.img)
        txtDetalle.setText(Le_Foto.descripcion.text)

        if (!Mi_Fav){
            btnFAV.setImageResource(R.drawable.ic_star_2)
        }else{
            btnFAV.setImageResource(R.drawable.ic_star_8)
        }
    }

    private fun Disparador_Boton_Detalle(){
        IMG_Detalle.setOnClickListener{
            startActivity(Intent(this, Full_Foto::class.java).apply{
                putExtra("Foto_Final", Le_Foto)

            })
        }

        btnFAV.setOnClickListener{
            Mi_Fav = !Mi_Fav
            //Le_Foto.Es_Favorito(No_Foto,Mi_Fav)
            INFO_FOTO().Es_Favorito(No_Foto,Mi_Fav)
            if (!Mi_Fav){
                btnFAV.setImageResource(R.drawable.ic_star_2)
            }else{
                btnFAV.setImageResource(R.drawable.ic_star_8)
            }
        }
    }
}