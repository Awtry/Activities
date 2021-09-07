package com.awtry.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class Full_Foto : AppCompatActivity() {

    private lateinit var Le_Foto: INFO_FOTO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_foto)

        Le_Foto = intent.getParcelableExtra("Foto_Final") ?: INFO_FOTO()

        initview()
    }

    //region iniciador

    private lateinit var IMG_Full: ImageView

    private fun initview(){
        IMG_Full = findViewById(R.id.IMG_FULL)
        IMG_Full.setImageResource(Le_Foto.img)
    }


    //endregion

}