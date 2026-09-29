package com.example.moviesapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.R
import com.example.moviesapp.ui.theme.MoviesAppTheme
import com.example.moviesapp.model.Movie

@Composable
fun MoviePoster(movie: Movie) {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = Modifier
                .width(148.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(movie.image),
                contentDescription = null,
                modifier = Modifier
                    .height(154.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.FillBounds //Basicamente, estou dizendo preencha os limites. Horizontalmente e verticalmente de forma não uniforme
            )
            Text(
                text = movie.name,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
            )

        }
    }
}

@Preview
@Composable
private fun MoviePosterPreview() {
    val movie = Movie(
        id = 1,
        name = "Jujutsu Kaisen",
        image =  R.drawable.jujutsu
    )

    MoviesAppTheme() {
        MoviePoster(movie)
    }
}