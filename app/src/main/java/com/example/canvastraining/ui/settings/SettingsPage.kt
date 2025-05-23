package com.example.canvastraining.ui.settings

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.canvastraining.DataStoreManager
import com.example.canvastraining.ui.ForestGreen
import com.example.canvastraining.ui.OliveGreen
import com.example.canvastraining.ui.SageGreen
import com.example.canvastraining.ui.SandBeige
import kotlinx.coroutines.launch


@Composable
fun SettingsPage(ctx:Context){
    val dataStore = remember { DataStoreManager(ctx) }
    val scope = rememberCoroutineScope()


    var sliderPosition1 = dataStore.difficultyLevel.collectAsState(initial = 10f)
    var sliderPosition2 = dataStore.gridSize.collectAsState(initial = 10f)

    Column(
        modifier = Modifier.fillMaxSize().background(SageGreen).padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Column{
            Text(modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Zorluk Seviyesi",
                fontSize = 24.sp,
                color = ForestGreen,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.size(24.dp))
            Slider(
                value = sliderPosition1.value,
                onValueChange = {scope.launch { dataStore.saveDifficulty(it) }},
                valueRange = 10f..30f,
                steps = 1,
                colors = SliderColors(
                    thumbColor = ForestGreen,
                    activeTrackColor = ForestGreen,
                    activeTickColor = ForestGreen,
                    inactiveTrackColor = SandBeige,
                    inactiveTickColor = SandBeige,
                    disabledThumbColor = ForestGreen,
                    disabledActiveTrackColor = OliveGreen.copy(alpha = 0.4f),
                    disabledActiveTickColor = SageGreen.copy(alpha = 0.3f),
                    disabledInactiveTrackColor = ForestGreen,
                    disabledInactiveTickColor = ForestGreen
                )
            )
            Text(modifier = Modifier.align(Alignment.CenterHorizontally),
                text = sliderPosition1.value.toInt().toString(),
                fontSize = 20.sp,
                color = ForestGreen,
                fontWeight = FontWeight.W900
            )
        }

        Spacer(Modifier.size(50.dp))

        Column{
            Text(modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Izgara Büyüklüğü",
                fontSize = 24.sp,
                color = ForestGreen,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.size(20.dp))
            Slider(
                value = sliderPosition2.value,
                onValueChange = {scope.launch { dataStore.saveSize(it) }},
                valueRange = 10f..20f,
                steps = 1,
                colors = SliderColors(
                    thumbColor = ForestGreen,
                    activeTrackColor = ForestGreen,
                    activeTickColor = ForestGreen,
                    inactiveTrackColor = SandBeige,
                    inactiveTickColor = SandBeige,
                    disabledThumbColor = ForestGreen,
                    disabledActiveTrackColor = OliveGreen.copy(alpha = 0.4f),
                    disabledActiveTickColor = SageGreen.copy(alpha = 0.3f),
                    disabledInactiveTrackColor = ForestGreen,
                    disabledInactiveTickColor = ForestGreen
                )
            )
            Text(modifier = Modifier.align(Alignment.CenterHorizontally),
                text = sliderPosition2.value.toInt().toString(),
                fontSize = 20.sp,
                color = ForestGreen,
                fontWeight = FontWeight.W900
            )
        }

        Spacer(Modifier.size(150.dp))



    }

}

