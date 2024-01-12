package com.example.hangmanapp

sealed class Routes(val route: String) {
    object LaunchScreen: Routes("com.example.hangmanapp.LaunchScreen")
    object MenuScreen: Routes("com.example.hangmanapp.MenuScreen")
    object GameScreen: Routes("com.example.hangmanapp.GameScreen/{dificultatEscollida}/{musicaOn}") {
        fun createRoute(dificultatEscollida:String, musicaOn: Boolean) = "com.example.hangmanapp.GameScreen/$dificultatEscollida/$musicaOn"
    }
    object ResultScreen: Routes("com.example.hangmanapp.ResultScreen/{victoria}/{tries}/{dificultatEscollida}/{musicaOn}") {
        fun createRoute(victoria: Boolean, tries: Int, dificultatEscollida: String, musicaOn: Boolean) = "com.example.hangmanapp.ResultScreen/$victoria/$tries/$dificultatEscollida/$musicaOn"
    }
}
