package com.quastio.framelibrary

import android.content.ComponentCallbacks2
import android.content.ComponentCallbacks2.TRIM_MEMORY_BACKGROUND
import android.content.ComponentCallbacks2.TRIM_MEMORY_MODERATE
import android.content.Context
import android.content.res.Configuration
import android.graphics.Bitmap
import android.util.Log
import android.util.LruCache
import android.widget.ImageView
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import java.util.*
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit


class Frame (context: Context) :ComponentCallbacks2 {

    private val maxCacheSize: Int = (Runtime.getRuntime().maxMemory() / 1024).toInt()/8
    private val memoryCache: LruCache<String, Bitmap>

    private lateinit var job:CompletableJob

    private val imageViewMap = Collections.synchronizedMap(WeakHashMap<ImageView, String>())

    init {
        memoryCache = object : LruCache<String, Bitmap>(maxCacheSize) {
            override fun sizeOf(key: String, bitmap: Bitmap): Int {
                return bitmap.byteCount / 1024
            }
        }

        val metrics = context.resources.displayMetrics
        screenWidth = metrics.widthPixels
        screenHeight = metrics.heightPixels


    }

    companion object {

        private var INSTANCE: Frame? = null

        internal var screenWidth = 0
        internal var screenHeight = 0

        @Synchronized
        fun with(context: Context): Frame {

            require(context != null) {
                "Context should not be null."
            }

            return INSTANCE ?: Frame(context).also {
                INSTANCE = it
            }

        }
    }

     fun load(imageView: ImageView, imageUrl: String) {
        job= Job()

        require(imageView != null) {
            "ImageView should not be null."
        }

        require(imageUrl != null && imageUrl.isNotEmpty()) {
            "Image Url should not be empty"
        }

        imageView.setImageResource(0)
        imageViewMap[imageView] = imageUrl
        CoroutineScope(IO+job).launch {
            val bitmap = checkImageInCache(imageUrl)
            bitmap?.let {
                    loadIntoImageView(imageView, it, imageUrl)


            } ?: run {

                imageLoader(imageUrl,imageView)


            }
        }
    }

    private suspend  fun loadIntoImageView(imageView: ImageView, bitmap: Bitmap?, imageUrl: String) {
        require(bitmap != null) {
            "Bitmap should not be null"
        }

        val scaledBitmap = Utils.scaleBitmapForLoad(bitmap, imageView.width, imageView.height)

        scaledBitmap?.let {
            if(!isReused(imageUrl, imageView)) {
                withContext(Main) {
                    imageView.setImageBitmap(scaledBitmap)
                }
            }
        }
    }

    private fun isReused(imageUrl: String, imageView: ImageView): Boolean {
        val tag = imageViewMap[imageView]
        return tag == null || tag != imageUrl
    }

    private  fun checkImageInCache(imageUrl: String): Bitmap? = memoryCache.get(imageUrl)

    private suspend fun displayBitmap(imageUrl: String,imageView: ImageView){
        if(!isReused(imageUrl, imageView)){
            loadIntoImageView(imageView, checkImageInCache(imageUrl), imageUrl)
        }
    }


    private suspend fun imageLoader( imgUrl: String,  imageView: ImageView){
        if(isReused(imgUrl,imageView)) return

        val bitmap = Utils.downloadBitmapFromURL(imgUrl)
        bitmap?.let {
            memoryCache.put(imgUrl, bitmap)


            if (isReused(imgUrl, imageView)) return

            displayBitmap(imgUrl, imageView)
        }

    }


    override fun onLowMemory() {

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
    }

    override fun onTrimMemory(level: Int) {
        if (level >= TRIM_MEMORY_MODERATE) {
            memoryCache.evictAll();
        }
        else if (level >= TRIM_MEMORY_BACKGROUND) {
            memoryCache.trimToSize(memoryCache.size() / 2);
        }
    }
}


