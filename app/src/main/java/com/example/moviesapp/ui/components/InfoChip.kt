package com.example.moviesapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.ui.theme.MoviesAppTheme

@Composable
fun InfoChip(
    text: String
) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 15.sp,
        modifier = Modifier
            .background(
                color = Color.Gray.copy(alpha = 0.5f),
                shape = RoundedCornerShape(25),
            )
            .padding(all = 5.dp)
    )
}

@Composable
@Preview(showBackground = true)
private fun InfoChipPreview(){
    MoviesAppTheme {
        InfoChip(
            text = "Sunghoo Park"
        )
    }
}