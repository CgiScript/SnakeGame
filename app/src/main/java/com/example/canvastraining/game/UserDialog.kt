package com.example.canvastraining.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModel
import com.example.canvastraining.data.Record
import kotlinx.coroutines.flow.forEach
import java.time.LocalDate


@Composable
fun getUserName(on: MutableState<Boolean>, vM: GameViewModel, score:Int){
    val userText = remember { mutableStateOf("") }
    val tempList = mutableListOf<Record>()

    if(on.value){
        Dialog(onDismissRequest = {on.value = false}) {
            Column(modifier = Modifier
                .size(width = 400.dp, height = 200.dp)
                .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Yeni Rekor !")
                Row {
                    Text("Kullanıcı Adınız: ")
                    TextField(onValueChange = {userText.value = it}, value = userText.value)
                }
                Button(onClick = {
                    vM.recordList.value.forEach { tempList.add(it) }
                    tempList.add(
                        Record(
                        userName = userText.value,
                        highScore = score,
                        recordDate = LocalDate.now().toString()
                        )
                    )
                    tempList.sortedByDescending { it.highScore }.take(5)
                    vM.deleteAllRecords()
                    tempList.forEach {
                        vM.addNewRecord(it.userName, it.highScore)
                    }

                    on.value = false
                }) {
                    Text("Kayıt Et")
                }
            }
        }
    }




}



