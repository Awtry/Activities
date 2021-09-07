package com.awtry.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet



class MainActivity : AppCompatActivity() {

    //private lateinit var le_foto: Fotografia
    private lateinit var Le_Foto: INFO_FOTO
    private var centinela = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Le_Foto = INFO_FOTO()

        initviews()
        Rotacion_IMG()
        Disparador_Boton()
    }

    //region iniciador

        private lateinit var ViewPrincipal: ConstraintLayout

        private lateinit var btnIZQ: Button
        private lateinit var btnDER: Button
        private lateinit var btnDetalle: Button

        private lateinit var IMG_Principal: ImageView

        private lateinit var mis_imagenes: ArrayList<INFO_FOTO>

    //endregion

    private fun initviews(){

        ViewPrincipal = findViewById(R.id.Vista_Principal)

        btnIZQ = findViewById(R.id.btnIZQ)
        btnDER = findViewById(R.id.btnDER)
        btnDetalle = findViewById(R.id.btnAl_Detalle)

        IMG_Principal = findViewById(R.id.IMG_PRINCIPAL)

        mis_imagenes = Le_Foto.ConteoTotal()

    }

    private fun Rotacion_IMG(){
        IMG_Principal.setImageResource(mis_imagenes[centinela].img)
    }

    private fun Disparador_Boton(){
        btnDER.setOnClickListener{
            if (centinela == mis_imagenes.size - 1){
                centinela = 0
            }else{
                centinela ++
            }

            Rotacion_IMG()
        }

        btnIZQ.setOnClickListener{
            if (centinela == 0){
                centinela = mis_imagenes.size -1
            }else{
                centinela --
            }
            Rotacion_IMG()
        }

        btnDetalle.setOnClickListener{
            startActivity(Intent(this, Detalle::class.java).apply{
                putExtra("Mi_Fotito", mis_imagenes[centinela])
                putExtra("No_Foto", centinela)
            })
        }


    }

}