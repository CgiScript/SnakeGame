package com.example.canvastraining.ui.highscores

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.canvastraining.ui.highscores.components.RecordEntry



@Composable
fun HighScoresPage(){

    val highScoresViewModel: HighScoresViewModel = hiltViewModel()
    val isEmpty = highScoresViewModel.isEmpty.value
    val highScores = highScoresViewModel.recordList.collectAsState()

    Column(modifier = Modifier.fillMaxSize().background(Color.White).padding(50.dp)) {
        if(isEmpty){
            Text(modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "HENÜZ HİÇ OYUN OYNAMAMIŞSIN")
        }else {
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
                onClick = {
                    highScoresViewModel.deleteAllRecords()
                }
            ) { Text("Tüm Skorları Sil") }
        }

    }
}



@Preview
@Composable
fun HighScoresPagePreview(){
    HighScoresPage()
}