package com.nicolasrf.botoneraperu.utils

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.IOException


object Utils {

    @Throws(IOException::class)
    fun getBitmapFromAssets(fileName: String?, context: Context): Bitmap? {
        val assetManager = context.assets
        val istr = assetManager.open(fileName!!)
        val bitmap = BitmapFactory.decodeStream(istr)
        istr.close()
        return bitmap
    }

}