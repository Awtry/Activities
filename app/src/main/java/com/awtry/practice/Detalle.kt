package com.awtry.practice

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.moshi.Moshi
import java.lang.Exception

class Detalle : AppCompatActivity() {


    private lateinit var Le_Foto: INFO_FOTO
    private var No_Foto: Int = 0
    private var Mi_Fav: Boolean = false


    private val PREFS = "MY_PREFERENCES"
    private val FAVORITE_USER = "FAVORITE_USER"
    private lateinit var preferences: SharedPreferences
    private val moshi = Moshi.Builder().build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        Le_Foto = savedInstanceState?.getParcelable(FAVORITE_USER) ?: INFO_FOTO()

        Le_Foto = Es_Fav()

        Le_Foto = intent.getParcelableExtra("Mi_Fotito") ?: INFO_FOTO()
        No_Foto = intent.getIntExtra("No_Foto", 0)
        Mi_Fav = Le_Foto.Mi_favorito





        initviews()
        Disparador_Boton_Detalle()
    }

    override fun onRestart() {
        super.onRestart()

        saveUserLikes()

    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.run{
            putParcelable(FAVORITE_USER, Le_Foto)
        }
        super.onSaveInstanceState(outState)
    }

    private fun saveUserLikes(FAV: INFO_FOTO? = null){
        preferences.edit().putString(FAVORITE_USER, moshi.adapter(INFO_FOTO::class.java).toJson(FAV)).apply()
    }

    private fun Es_Fav() =
        preferences.getString(FAVORITE_USER, null)?.let{
            return@let try{
                moshi.adapter(INFO_FOTO::class.java).fromJson(it)
            }catch (e: Exception){
                INFO_FOTO()
            }
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