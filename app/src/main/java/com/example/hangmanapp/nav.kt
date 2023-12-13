package com.example.hangmanapp

sealed class GamePhase(val route: String) {
    object Pantalla1:GamePhase("LaunchScreen")
    object Pantalla2:GamePhase("MenuScreen")
    object Pantalla3:GamePhase("GameScreen")
    object Pantalla4:GamePhase("ResultScreen")
}