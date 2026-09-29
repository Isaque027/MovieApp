package com.example.moviesapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.moviesapp.model.Movie
import com.example.moviesapp.sampledata.movies
import com.example.moviesapp.ui.theme.MoviesAppTheme
import com.example.moviesapp.ui.theme.OrangeProject

@Composable
fun MovieSection(
    title: String,
    movies: List<Movie>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            modifier = Modifier.padding(start = 16.dp),
            color = OrangeProject

        )

        LazyRow(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                ),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(movies){
                movie -> MoviePoster(movie)
            }
            item {
                AsyncImage(
                    model = "https://br.web.img3.acsta.net/pictures/16/02/03/17/11/571106.jpg",
                    contentDescription = null,
                    modifier = Modifier
                        .width(148.dp)
                        .height(154.dp),
                    contentScale = ContentScale.Crop,
                    onSuccess = {
                        println("Imagem carregada!")
                    },
                    onError = {
                        println("Erro ao carregar a imagem!")
                    }
                )
            }
        }

        
    }
}

@Preview
@Composable
private fun MovieSectionPreview(){
    MoviesAppTheme {
        MovieSection(
            title = "Discover",
            movies = movies
        )
    }
}