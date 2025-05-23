package com.example.canvastraining.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.canvastraining.R
import com.example.canvastraining.ui.ForestGreen
import com.example.canvastraining.ui.OliveGreen
import com.example.canvastraining.ui.SageGreen
import com.example.canvastraining.ui.SandBeige
import com.example.canvastraining.ui.home.components.MenuButton

val snakeFont = FontFamily(Font(R.font.snake_font))


@Composable
fun HomePage(
    goToGameArea: ()->Unit,
    goToHighScores: ()->Unit,
    goToSettings: ()->Unit
    ){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(SageGreen)
        .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = " YILAN ",
            fontFamily = snakeFont,
            fontSize = 76.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF014421)
        )

        Spacer(modifier = Modifier.height(50.dp))

        MenuButton(onClick = {goToGameArea()}, text = "Oyna")

        MenuButton(onClick = {goToHighScores()}, text = "Yüksek Skorlar")

        MenuButton(onClick = {goToSettings()}, text = "Ayarlar")
    }

}

