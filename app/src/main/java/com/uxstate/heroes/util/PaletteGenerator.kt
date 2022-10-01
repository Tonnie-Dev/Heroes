package com.uxstate.heroes.util

import android.content.Context
import android.graphics.Bitmap
import coil.ImageLoader

object PaletteGenerator {

    suspend fun convertImageUrlToBitMap(url:String, context: Context):Bitmap?{

        val loader = ImageLoader(context = context)

    }
}