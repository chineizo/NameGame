package com.example.namegame.service

import com.example.namegame.model.NameGame
import retrofit2.http.GET

interface NameMatchService {
    @GET("/api/v1.0/profiles")
    suspend fun getMatch(): List<NameGame>
}