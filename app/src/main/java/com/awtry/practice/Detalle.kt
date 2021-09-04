package com.awtry.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class Detalle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)
    }

    //region iniciador

    private lateinit var ViewDetalle: ConstraintLayout

    private lateinit var btnFAV: Button

    private lateinit var IMG_Detalle: ImageView

    //endregion




    private fun initviews(){

    }

}