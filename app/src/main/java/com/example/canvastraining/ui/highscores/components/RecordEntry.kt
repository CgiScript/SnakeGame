package com.example.canvastraining.ui.highscores.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RecordEntry(userText:String, scoreText:String, dateText:String){
    Row {
        Icon(imageVector = Icons.Default.ThumbUp, contentDescription = "")
        Text(text = userText)
        Text(text = scoreText)
        Text(text = dateText)
    }

}