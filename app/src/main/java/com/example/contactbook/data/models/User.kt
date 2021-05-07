package com.example.contactbook.data.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    var id: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("email")
    var email: String
)