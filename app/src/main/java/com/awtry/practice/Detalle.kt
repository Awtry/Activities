package com.awtry.practice

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.moshi.Moshi
import java.lang.Exception
import kotlin.math.absoluteValue

class Detalle : AppCompatActivity() {


    //region DECLARACIÓN DE VARIABLES

    //llamadas
    private lateinit var Le_Foto: INFO_FOTO
    private var No_Foto: Int = 0
    private var Mi_Fav: Boolean = false


    private val PREFS = "MY_PREFERENCES"
    private val FAVORITE_USER = "FAVORITE_USER"
    private lateinit var preferences: SharedPreferences
    private val moshi = Moshi.Builder().build()

    //Elementos visuales
    private lateinit var txtDetalle: TextView
    private lateinit var btnFAV: ImageView
    private lateinit var IMG_Detalle: ImageView


    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)

        initviews()
    }


    private fun initviews() {
        IMG_Detalle = findViewById(R.id.IMG_DETALLE)
        btnFAV = findViewById(R.id.btn_favorito)
        txtDetalle = findViewById(R.id.txv_Detalle)

        Le_Foto = intent.getParcelableExtra("Mi_Fotito") ?: INFO_FOTO()
        No_Foto = intent.getIntExtra("No_Foto", 0)
        Mi_Fav = Le_Foto.Mi_favorito

<<<<<<< Updated upstream
        initviews()
        Mi_Favorito()
        //if(Le_Foto.Mi_favorito)
=======
        Exponer()
        Disparador_Boton_Detalle()
>>>>>>> Stashed changes
    }

    private fun Disparador_Boton_Detalle() {
        IMG_Detalle.setOnClickListener {
            startActivity(Intent(this, Full_Foto::class.java).apply {
                putExtra("Foto_Final", Le_Foto)
            })
        }

        btnFAV.setOnClickListener {
            cambioGusto()
        }
    }

    private fun cambioGusto() {

        !Mi_Fav
        if (Mi_Fav == Le_Foto.Mi_favorito) {
            btnFAV.setImageResource(R.drawable.ic_star_2)
        } else {
            btnFAV.setImageResource(R.drawable.ic_star_8)
        }

        Exponer()
    }

<<<<<<< Updated upstream
    private fun saveUserLikes(Le_Foto: INFO_FOTO? = null){
        preferences.edit().putString(FAVORITE_USER, moshi.adapter(INFO_FOTO::class.java).toJson(Le_Foto)).apply()
=======
    private fun saveUserLikes() {
       //preferences.edit().putString(FAVORITE_USER, moshi.adapter(Le_Foto.Mi_favorito::class.java).toJson()).apply()
>>>>>>> Stashed changes
    }

    private fun Existe_favoito() =
        preferences.getString(FAVORITE_USER, null)?.let {
            return@let try {
                moshi.adapter(Boolean::class.java)
            } catch (e: Exception) {
                false
            }
<<<<<<< Updated upstream
        } ?: INFO_FOTO()


    //region iniciador

    private lateinit var txtDetalle: TextView
    private lateinit var btnFAV: ImageView
    private lateinit var IMG_Detalle: ImageView

    //endregion




    private fun initviews(){
        IMG_Detalle = findViewById(R.id.IMG_DETALLE)
        btnFAV = findViewById(R.id.btn_favorito)
        txtDetalle = findViewById(R.id.txv_Detalle)

        btnFAV.setImageResource(R.drawable.ic_star_2)
=======
        } ?: false
>>>>>>> Stashed changes

    private fun Exponer() {
        //Muestra imagen viajera
        IMG_Detalle.setImageResource(Le_Foto.img)
        txtDetalle.setText(Le_Foto.descripcion.text)

<<<<<<< Updated upstream
        Mi_Favorito()
        Disparador_Boton_Detalle()
    }


    private fun Mi_Favorito(){
        Mi_Fav = !Mi_Fav
        //Le_Foto.Es_Favorito(No_Foto,Mi_Fav)
        saveUserLikes(INFO_FOTO())
        if (!Mi_Fav){
=======

        if (Mi_Fav == Le_Foto.Mi_favorito) {
>>>>>>> Stashed changes
            btnFAV.setImageResource(R.drawable.ic_star_2)
        } else {
            btnFAV.setImageResource(R.drawable.ic_star_8)
        }
    }
<<<<<<< Updated upstream



    private fun Disparador_Boton_Detalle(){
        IMG_Detalle.setOnClickListener{
            startActivity(Intent(this, Full_Foto::class.java).apply{
                putExtra("Foto_Final", Le_Foto)

            })
        }

        btnFAV.setOnClickListener{
           Mi_Favorito()
        }
    }
=======
>>>>>>> Stashed changes
}