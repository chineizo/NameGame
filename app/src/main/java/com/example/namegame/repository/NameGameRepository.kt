package com.example.namegame.repository

import com.example.namegame.model.NameGame
import com.example.namegame.service.NameMatchService

class NameGameRepository (private val nameMatchService: NameMatchService){
    suspend  fun getNameGame (): List<NameGame> {
        return nameMatchService.getMatch()
    }
}