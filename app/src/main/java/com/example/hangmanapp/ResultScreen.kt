package com.example.hangmanapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun ResultScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Blue)) {
        Text(
            text = "Pantalla 4",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(GamePhase.Pantalla1.route) })
    }
}