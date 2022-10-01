package com.uxstate.heroes.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult

object PaletteGenerator {

    suspend fun convertImageUrlToBitmap(url: String, context: Context): Bitmap? {

        //loader class from the Coil Library
        val loader = ImageLoader(context = context)
        val request = ImageRequest.Builder(context = context)
                .data(url)

                /*Allow the use of Bitmap.Config.HARDWARE.

If false, any use of Bitmap.Config.HARDWARE will be treated as
Bitmap.Config.ARGB_8888.

NOTE: Setting this to false this will reduce performance on
API 26 and above. Only disable this if necessary.

Default: true*/
                .allowHardware(false)
                .build()

        val imageResult = loader.execute(request)

        return if (imageResult is SuccessResult) {
            (imageResult.drawable as BitmapDrawable).bitmap

        } else {

            null
        }

    }


    private fun parseColorSwatch(color: Palette.Swatch?): String {

        return if (color != null) {
            //convert color to hex
            val parsedColor = Integer.toHexString(color.rgb)

            //concatenate #
            "#$parsedColor"

        } else {

            //else return black color
            "#000000"
        }


    }
}