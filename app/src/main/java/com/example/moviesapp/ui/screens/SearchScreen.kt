package com.example.moviesapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviesapp.sampledata.movies
import com.example.moviesapp.ui.components.MovieSection
import com.example.moviesapp.ui.components.QueryBar
import com.example.moviesapp.ui.theme.BackgroundColor

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
){
    //State Hoisting (Elevação de estado): Consiste em elevar ou criar o estado num componente pai, de hierarquia superior aos componentes que dependem desse estado
    var query by remember {
        mutableStateOf(value = "")
    }

    //filter{} --> é uma função que cria uma nova lista a partir de um filtro aplicado em outra lista já existente
    val filteredMovies = movies.filter { movie ->
        //Aqui eu verifico com contains se o conteúdo de query está contido dentro do name dos movies, o argumento ignoreCase faz que a comparação ignore a diferença entre maiúsculas e minúsculas
        movie.name.contains(query, ignoreCase = true)
    }
    Column(
        modifier = Modifier
            .background(
                color = BackgroundColor
            )
    ) {
        //State Hoisting: Eu passo por parâmetro ao componente o valor atual do estado e uma função para ele comunicar mudanças no estado
        QueryBar(
            query = query,
            onQueryChange = { newText ->
                query = newText
            }
        )

        MovieSection(
            title = "Sua busca:",
            movies = filteredMovies
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    SearchScreen()
}