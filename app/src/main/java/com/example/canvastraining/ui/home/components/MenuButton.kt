package com.example.canvastraining.ui.home.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.canvastraining.ui.ForestGreen
import com.example.canvastraining.ui.SageGreen
import com.example.canvastraining.ui.SandBeige

@Composable
fun MenuButton(onClick:  () -> Unit, text: String){

    Button(onClick = onClick,
        modifier = Modifier.fillMaxWidth().padding(0.dp,5.dp),
        shape = RectangleShape,
        colors = ButtonColors(
            contentColor = Color.White,
            containerColor = ForestGreen,
            disabledContentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
    ) {
        Text(
            text =  text,
            fontSize = 24.sp,
            color = SandBeige,
            fontWeight = FontWeight.ExtraBold
        )
    }
}



@Preview
@Composable
fun MenuButtonPreview(){

}