package com.example.canvastraining.game

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.canvastraining.DataStoreManager
import com.example.canvastraining.ui.ForestGreen
import com.example.canvastraining.ui.SageGreen
import com.example.canvastraining.ui.SandBeige
import kotlinx.coroutines.delay
import kotlin.math.min


@Composable
fun GameArea(size:Int, difficulty:Int){

    val gridSize = size
    var difficulty = when(difficulty){10->300 20->100 30->50 else->300}

    val snakeActionList = remember { mutableStateOf(listOf<()->Unit>()) }
    val gameViewModel: GameViewModel = hiltViewModel()
    val openDialog = remember { mutableStateOf(false) }
    val recordScore = remember {mutableStateOf(0) }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(SageGreen)
        .systemBarsPadding()
    ){

        BoxWithConstraints(modifier = Modifier
            .weight(0.60f)
            .fillMaxWidth()
            .background(SageGreen)
            .padding(10.dp)
        ) {

            val width = constraints.maxWidth
            val height = constraints.maxHeight

            val rows = gridSize
            val cols = gridSize

            val areaSize = min(width, height).dp / LocalDensity.current.density
            val cellSize = (min(width, height)/rows).toFloat()

            val game = remember { mutableStateOf(true) }
            val headX = remember { mutableStateOf(rows/2) }
            val headY = remember { mutableStateOf(rows/2) }
            val tail = remember { mutableStateOf(mutableListOf<Pair<Int, Int>>()) }
            val headSize = cellSize
            val score = remember { mutableStateOf(0) }
            val direction = remember { mutableStateOf("right") }
            val promptText = remember{ mutableStateOf("Puan: ${score.value}") }

            val food = remember {
                mutableStateOf(
                    generateRandomFood(headX, headY, tail.value, rows)
                )
            }

            val onRightClick = { if (direction.value != "left") direction.value = "right"}
            val onLeftClick = { if (direction.value != "right") direction.value = "left"}
            val onUpClick = { if (direction.value != "down") direction.value = "up" }
            val onDownClick = { if (direction.value != "up") direction.value = "down"}
            snakeActionList.value = listOf(onUpClick, onLeftClick, onRightClick, onDownClick)



            LaunchedEffect(game.value) {


                // Get ready for start
                for (i in 0..2) {
                    tail.value.add(Pair(headX.value - 1,headY.value))
                }


                while(game.value){

                    // Make tail segments follow the head
                    for(i in 0..< tail.value.size - 1){
                        tail.value[i] = tail.value[i + 1]
                    }
                    tail.value[tail.value.size - 1] = Pair(headX.value, headY.value)

                    // Move head
                    when(direction.value){
                        "right" -> headX.value++
                        "left" -> headX.value--
                        "up" -> headY.value--
                        "down" -> headY.value++
                    }

                    // Check if head is out of boundaries
                    when{
                        headX.value < 0 -> headX.value = cols-1
                        headX.value > cols-1 -> headX.value = 0
                        headY.value < 0 -> headY.value = rows-1
                        headY.value > rows-1 -> headY.value = 0
                    }

                    // Grow the body if it eats food
                    if (headX.value == food.value.first && headY.value == food.value.second){
                        food.value = generateRandomFood(headX, headY, tail.value, rows)
                        tail.value.add(tail.value[tail.value.size - 1])
                        score.value += 10
                        promptText.value = "Puan: ${score.value}"
                    }

                    // Check for collision & game over
                    if ( Pair(headX.value, headY.value) in tail.value) {
                        promptText.value = "Oyun Bitti ! | Puan: ${score.value}"
                        game.value = false
                        if(checkHighScore(gameViewModel, score.value)){
                            recordScore.value = score.value
                            openDialog.value = true
                        }

                    }

                    delay(timeMillis = difficulty.toLong())
                }
            }

            Column {
                Canvas(Modifier
                    .background(ForestGreen)
                    .size(areaSize)
                ){
                    // Draw grid
                    for (i in 0..cols){
                        drawLine(
                            color = SandBeige,
                            start = Offset(  i * cellSize, 0f ),
                            end = Offset( i * cellSize, cellSize * rows),
                            strokeWidth = 1f,
                        )
                    }
                    for (i in 0..rows){
                        drawLine(
                            color = SandBeige,
                            start = Offset(  0f,  i * cellSize ),
                            end = Offset(  cellSize * cols,  i * cellSize ),
                            strokeWidth = 1f,
                        )
                    }

                    // Snake Head
                    drawRect(
                        color = Color(0xFF00FF66),
                        size = Size(headSize, headSize),
                        topLeft = Offset(headX.value * cellSize, headY.value * cellSize)
                    )
                    // Tail
                    tail.value.forEach{
                        drawRect(
                            color = Color(0xFF00FF66),
                            size = Size(headSize, headSize),
                            topLeft = Offset(it.first * cellSize, it.second * cellSize)
                        )
                    }
                    // Food
                    drawRect(
                        color = Color(0xFF00FF66),
                        size = Size(headSize, headSize),
                        topLeft = Offset(food.value.first * cellSize, food.value.second * cellSize)
                    )



                }
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = promptText.value,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = ForestGreen
                )
                Spacer(modifier = Modifier.size(5.dp))
                if(!game.value){
                    Button(
                        onClick = {
                            score.value = 0
                            headX.value = rows/2
                            headY.value = rows/2
                            tail.value.clear()
                            food.value = generateRandomFood(headX, headY, tail.value, rows)
                            promptText.value = "Puan: ${score.value}"
                            direction.value = "right"
                            game.value = true},
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        colors = ButtonColors(
                            contentColor = Color.White,
                            containerColor = ForestGreen,
                            disabledContentColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent
                        ),
                    ) {
                        Text(
                            text = "Yeniden Başlat !!!",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = SandBeige
                        )
                    }
                }

            }



        }
        if(openDialog.value) { getUserName(openDialog, gameViewModel, recordScore.value) }
        ControllerUI(Modifier
            .weight(0.35f)
            .padding(20.dp), snakeActionList.value)

    }



}



