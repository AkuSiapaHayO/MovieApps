package com.elflin.movieapps.model

//import com.google.gson.annotations.SerializedName

data class User(
    val age: Int = 0,
    val email:String = "",
    val id: Int = 0,
    val name:String = "",
    val password: String = "",
    val phone: String = "",
//    @SerializedName("profile_picture")
    val profile_picture:String = ""
)
