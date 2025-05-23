package com.example.canvastraining.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.canvastraining.ui.ForestGreen
import com.example.canvastraining.ui.SandBeige

@Composable
fun ControllerUI(modifier: Modifier, eventList:List<() -> Unit>){

    Box(modifier = modifier) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Button(
                    onClick = {eventList[0]()}, shape = RectangleShape,
                    colors = ButtonColors(
                        contentColor = SandBeige,
                        containerColor = ForestGreen,
                        disabledContentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent
                    ),
                ) {
                    Icon(
                        modifier = Modifier.size(50.dp),
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = ""
                    )
                }
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(
                    onClick = {eventList[1]()}, shape = RectangleShape,
                    colors = ButtonColors(
                        contentColor = SandBeige,
                        containerColor = ForestGreen,
                        disabledContentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent
                    ),
                ) {
                    Icon(
                        modifier = Modifier.size(50.dp).fillMaxWidth(),
                        imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.size(width = 80.dp, height = 20.dp))
                Button(
                    onClick = {eventList[2]()}, shape = RectangleShape,
                    colors = ButtonColors(
                        contentColor = SandBeige,
                        containerColor = ForestGreen,
                        disabledContentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent
                    ),
                ) {
                    Icon(
                        modifier = Modifier.size(50.dp),
                        imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                        contentDescription = ""
                    )
                }
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Button(
                    onClick = {eventList[3]()}, shape = RectangleShape,
                    colors = ButtonColors(
                        contentColor = SandBeige,
                        containerColor = ForestGreen,
                        disabledContentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent
                    ),
                ) {
                    Icon(
                        modifier = Modifier.size(50.dp),
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = ""
                    )
                }
            }

        }

    }
}

