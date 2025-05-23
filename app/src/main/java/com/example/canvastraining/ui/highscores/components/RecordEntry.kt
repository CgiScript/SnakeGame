package com.example.canvastraining.ui.highscores.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.canvastraining.ui.ForestGreen
import com.example.canvastraining.ui.SandBeige

@Composable
fun RecordEntry(rank:Int, userText:String, scoreText:String, dateText:String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .border(
            border = BorderStroke(0.dp, Color.Black),
            shape = RectangleShape
        )
        .background(ForestGreen).padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = (rank).toString(), color = SandBeige)
        Text(text = userText,  color = SandBeige,modifier = Modifier.width(50.dp))
        Spacer(Modifier.size(10.dp))
        Text(text = scoreText, color = SandBeige)
        Text(text = dateText, color = SandBeige)
    }

}