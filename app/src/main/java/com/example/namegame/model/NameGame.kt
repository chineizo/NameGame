package com.example.namegame.model

data class NameGame(
    val firstName: String,
    val id: String,
    val jobTitle: String,
    val lastName: String,
    val slug: String,
    val type: String,
    val headshot: HeadShot
)

data class HeadShot(
    val alt: String,
    val height: Int,
    val id: String,
    val mimeType: String,
    val type: String,
    val url: String,
    val width: Int
)
