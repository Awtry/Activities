package com.awtry.practice

import android.os.Parcelable
import android.widget.ImageView
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize

class INFO_FOTO(
    var img: Int = R.drawable.rojo_y_flores,
    var descripcion: String = ""
): Parcelable {

    companion object{
        val Photos = arrayListOf(
            INFO_FOTO(R.drawable.puesta_de_sol, R.string.text_puesta_sol.toString()),
            INFO_FOTO(R.drawable.estrella_primavera, R.string.text_estrella_primavera.toString()),
            INFO_FOTO(R.drawable.resumen_aprox_1, R.string.text_resumen.toString()),
            INFO_FOTO(R.drawable.rojo_y_flores, R.string.text_rojo_flores.toString()),
            INFO_FOTO(R.drawable.venti, R.string.text_venti.toString()),

            INFO_FOTO(R.drawable.ic_prim, R.string.text_gem_1.toString()),
            INFO_FOTO(R.drawable.ic_seg, R.string.text_gem_2.toString()),
            INFO_FOTO(R.drawable.ic_terc, R.string.text_gem_3.toString()),
            INFO_FOTO(R.drawable.ic_cuar, R.string.text_gem_4.toString()),
            INFO_FOTO(R.drawable.ic_quin, R.string.text_gem_5.toString())

        )
    }

    fun ConteoTotal() = Photos



}