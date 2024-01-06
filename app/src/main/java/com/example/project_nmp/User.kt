package com.example.project_nmp

import java.util.Date

data class User (
    val username: String,
    val email: String,
    val urlProfilePicture: String,
    val password: String,
    val dateJoined: Date,
    val totalLikes: Int,
)