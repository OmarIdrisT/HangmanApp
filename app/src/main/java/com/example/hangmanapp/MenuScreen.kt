package com.example.hangmanapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController) {
    var nom by remember { mutableStateOf("") }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    )
    {
        Box(modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .fillMaxHeight()
            .align(Alignment.CenterHorizontally)) {
            Text(
                text = "NEXT STEP",
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Center)
                    .clickable { navController.navigate(GamePhase.Pantalla3.route) })
        }
    }

}