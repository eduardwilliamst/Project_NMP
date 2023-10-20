package com.example.project_nmp

data class Genre (
    val id: Int,
    val name: String,
) {
    override fun toString(): String {
        return name
    }
}
