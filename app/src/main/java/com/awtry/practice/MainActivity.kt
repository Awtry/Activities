package com.awtry.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

    private lateinit var le_foto: Fotografia


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initviews()
    }

    //region iniciador

        private lateinit var ViewPrincipal: ConstraintLayout

        private lateinit var btnIZQ: Button
        private lateinit var btnDER: Button
        private lateinit var btnDetalle: Button

        private lateinit var IMG_Principal: ImageView

    //endregion

    private fun initviews(){

        ViewPrincipal = findViewById(R.id.Vista_Principal)

        btnIZQ = findViewById(R.id.btnIZQ)
        btnDER = findViewById(R.id.btnDER)
        btnDetalle = findViewById(R.id.btnAl_Detalle)

        IMG_Principal = findViewById(R.id.IMG_PRINCIPAL)
    }



}