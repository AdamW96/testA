package com.onepointapac.userclarice.data.model

data class User(
    val id: Int,
    val name: String
) {

    val getUserName: String get() = name
    val getUserId: Int get() = id
}