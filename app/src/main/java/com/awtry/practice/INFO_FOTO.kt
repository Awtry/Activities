package com.awtry.practice

import android.os.Parcelable
import android.widget.ImageView
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize

class INFO_FOTO(
    var img: Int = R.drawable.rojo_y_flores,
    var descripcion: Fotografia = Fotografia.PRIMAVERA
): Parcelable {

    companion object{
        val Photos = arrayListOf(
            INFO_FOTO(R.drawable.puesta_de_sol, Fotografia.PUESTA_SOL),
            INFO_FOTO(R.drawable.estrella_primavera, Fotografia.PRIMAVERA),
            INFO_FOTO(R.drawable.resumen_aprox_1, Fotografia.RESUMEN),
            INFO_FOTO(R.drawable.rojo_y_flores, Fotografia.ROJO_FLOR),
            INFO_FOTO(R.drawable.venti, Fotografia.VENTI),

            INFO_FOTO(R.drawable.ic_prim, Fotografia.LAPISLAZULI),
            INFO_FOTO(R.drawable.ic_seg, Fotografia.RUBI),
            INFO_FOTO(R.drawable.ic_terc, Fotografia.TOPACIO),
            INFO_FOTO(R.drawable.ic_cuar, Fotografia.DIAMANTE),
            INFO_FOTO(R.drawable.ic_quin, Fotografia.PERIDOT)

        )
    }

    fun ConteoTotal() = Photos



}