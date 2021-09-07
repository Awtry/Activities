package com.awtry.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class Detalle : AppCompatActivity() {


    private lateinit var Le_Foto:INFO_FOTO
    private var No_Foto: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        Le_Foto = intent.getParcelableExtra("Mi_Fotito") ?: INFO_FOTO()
        No_Foto = intent.getIntExtra("No.Foto", 0)

    }

    //region iniciador

    private lateinit var ViewDetalle: ConstraintLayout

    private lateinit var btnFAV: Button

    private lateinit var IMG_Detalle: ImageView

    //endregion




    private fun initviews(){

    }

}