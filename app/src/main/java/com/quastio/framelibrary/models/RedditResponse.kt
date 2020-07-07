package com.quastio.framelibrary.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class RedditResponse(
    @SerializedName("kind")
    @Expose
    private val kind: String,
    @SerializedName("data")
    @Expose
     val data: Data

) {

}