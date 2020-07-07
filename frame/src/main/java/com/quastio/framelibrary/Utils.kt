package com.quastio.framelibrary

import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.BitmapFactory
import android.os.Process
import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.net.URL
import java.util.concurrent.ThreadFactory


object Utils {
    suspend fun downloadBitmapFromURL(imageUrl: String): Bitmap? {
        var bitmap:Bitmap?

            val url = URL(imageUrl)
            val inputStream = BufferedInputStream(url.openConnection().getInputStream())

            // Scale Bitmap to Screen Size to store in Cache
            bitmap= scaleBitmap(inputStream, Frame.screenWidth, Frame.screenHeight)
            return bitmap


    }

    suspend fun scaleBitmapForLoad(bitmap: Bitmap, width: Int, height: Int): Bitmap? {

        if(width == 0 || height == 0) return bitmap

        val stream = ByteArrayOutputStream()
        bitmap.compress(CompressFormat.JPEG, 100, stream)
        val inputStream = BufferedInputStream(ByteArrayInputStream(stream.toByteArray()))

        // Scale Bitmap to required ImageView Size
        return scaleBitmap(inputStream,  width, height)
    }

    private suspend fun scaleBitmap(inputStream: BufferedInputStream, width: Int, height: Int) : Bitmap? {
        return BitmapFactory.Options().run {
            inputStream.mark(inputStream.available())

            inJustDecodeBounds = true
            BitmapFactory.decodeStream(inputStream, null, this)

            inSampleSize = calculateInSampleSize(this, width, height)

            inJustDecodeBounds = false
            inputStream.reset()
            BitmapFactory.decodeStream(inputStream, null,  this)
        }
    }

    private  fun calculateInSampleSize(options: BitmapFactory.Options, reqWidth: Int, reqHeight: Int): Int {

        val (height: Int, width: Int) = options.run { outHeight to outWidth }
        var inSampleSize = 1

        if (height > reqHeight || width > reqWidth) {

            val halfHeight: Int = height / 2
            val halfWidth: Int = width / 2
            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) inSampleSize *= 2
        }

        return inSampleSize
    }

}
