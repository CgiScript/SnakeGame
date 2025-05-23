package com.example.canvastraining.ui.highscores

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.canvastraining.ui.ForestGreen
import com.example.canvastraining.ui.OliveGreen
import com.example.canvastraining.ui.SageGreen
import com.example.canvastraining.ui.SandBeige
import com.example.canvastraining.ui.highscores.components.RecordEntry



@Composable
fun HighScoresPage(){

    val highScoresViewModel: HighScoresViewModel = hiltViewModel()
    val isEmpty = highScoresViewModel.isEmpty.value
    val highScores = highScoresViewModel.recordList.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().background(SageGreen).padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(isEmpty){
            Text(
                text = "Upps... Henüz Hiç Oyun Oynamamışsın.",

                color = ForestGreen,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.size(10.dp))
            Text(" \uD83D\uDE10", fontSize = 32.sp)
        }else {
            Text(
                text = "YÜKSEK SKORLAR",
                fontSize = 32.sp,
                color = ForestGreen,
                fontWeight = FontWeight.ExtraBold
            )
            HorizontalDivider(Modifier.padding(0.dp,20.dp), thickness = 5.dp, color = ForestGreen)
            highScores.value.sortedByDescending { it.highScore }.forEach {
                RecordEntry(
                    highScores.value.size - highScores.value.indexOf(it),
                    it.userName,
                    it.highScore.toString(),
                    it.recordDate
                )
                Spacer(Modifier.size(10.dp))
            }
            Spacer(Modifier.size(50.dp))
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                shape = RectangleShape,
                colors = ButtonColors(
                    contentColor = Color.White,
                    containerColor = ForestGreen,
                    disabledContentColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent
                ),
                onClick = {
                    highScoresViewModel.deleteAllRecords()
                }
            ) { Text("Tüm Skorları Sil", fontSize = 20.sp, color = SandBeige) }
        }

    }
}



@Preview
@Composable
fun HighScoresPagePreview(){
    HighScoresPage()
}