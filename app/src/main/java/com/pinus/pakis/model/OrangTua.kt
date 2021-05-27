package com.pinus.pakis.model

data class OrangTua(
    val id: String?,
    val nama: String,
    val email: String,
    val password: String
) {
    constructor(): this("", "", "", "")
}
