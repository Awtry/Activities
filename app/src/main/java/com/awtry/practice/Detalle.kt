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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        Le_Foto = intent.getParcelableExtra("Mi_Fotito") ?: INFO_FOTO()
        No_Foto = intent.getIntExtra("No_Foto", 0)

        initviews()
        Disparador_Boton_Detalle()
    }

    //region iniciador

    private lateinit var ViewDetalle: ConstraintLayout
    private lateinit var txtDetalle: TextView
    private lateinit var btnFAV: ImageButton
    private lateinit var IMG_Detalle: ImageView

    //endregion




    private fun initviews(){
        ViewDetalle = findViewById(R.id.Detalle_View)
        IMG_Detalle = findViewById(R.id.IMG_DETALLE)
        btnFAV = findViewById(R.id.btn_favorito)
        txtDetalle = findViewById(R.id.txv_Detalle)

        //Muestra imagen viajera
        IMG_Detalle.setImageResource(Le_Foto.img)
        txtDetalle.setText(Le_Foto.descripcion.text)
    }

    private fun Disparador_Boton_Detalle(){
        IMG_Detalle.setOnClickListener{
            startActivity(Intent(this, Full_Foto::class.java).apply{
                putExtra("Foto_Final", Le_Foto)

            })
        }
    }
}