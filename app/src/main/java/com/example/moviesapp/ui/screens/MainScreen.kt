package com.example.moviesapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviesapp.sampledata.movies
import com.example.moviesapp.ui.components.HeroBanner
import com.example.moviesapp.ui.components.MovieSection
import com.example.moviesapp.ui.theme.BackgroundColor
import com.example.moviesapp.ui.theme.MoviesAppTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(25.dp),
        modifier = Modifier
            .background(
                color = BackgroundColor
            )
    )
    {
        item {
            HeroBanner(
                titleBanner = "New Season 3",
                titleName = "Jujutsu Kaisen"
            )
        }

        item {
            MovieSection(
                title = "Discover",
                movies = movies
            )
        }

        item {
            MovieSection(
                title = "Last watched",
                movies = movies
            )
        }

        item {
            MovieSection(
                title = "My list",
                movies = movies
            )
        }


    }

}

@Preview(showBackground = true
)
@Composable
fun MainScreenPreview() {
    MoviesAppTheme {
        MainScreen()
    }
}