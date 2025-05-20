package com.example.canvastraining.ui.highscores

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.canvastraining.ui.highscores.components.RecordEntry


@Composable
fun HighScoresPage(){
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        RecordEntry("Username", "0000", "01/01/01")
    }
}



@Preview
@Composable
fun HighScoresPagePreview(){
    HighScoresPage()
}