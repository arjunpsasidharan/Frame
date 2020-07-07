package com.quastio.framelibrary.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Data(
    @SerializedName("modhash")
    @Expose
    private val modhash: String,

    @SerializedName("dist")
    @Expose
    private val dist: Int,

    @SerializedName("children")
    @Expose
     val children: List<Child>,

    @SerializedName("after")
    @Expose
    private val after: String,

    @SerializedName("before")
    @Expose
    private val before: Any
) {


}