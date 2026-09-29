package com.example.moviesapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.moviesapp.ui.theme.GreenProject
import com.example.moviesapp.ui.theme.MoviesAppTheme
import com.example.moviesapp.ui.theme.OrangeProject


@Composable
fun HeroBanner(
    titleBanner: String,
    titleName: String
){
    Box(){
        Image(
            painter = painterResource(R.drawable.herobanner),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .clip(RoundedCornerShape(
                    topStart = 25.dp,
                    topEnd = 25.dp
                ) //Recorta o compoenente de acordo com um formato, no caso formato de cantos arredondados
                )
            ,
            contentScale = ContentScale.Crop //"Cortar" ==> Tenta preencher toda a área disponível para a imagem sem distorcer a proporção original, se sobrar conteúdo para fora ele corta

            )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 40.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = titleBanner,
                color = GreenProject,
                fontSize = 16.sp,
                modifier = Modifier
            )
            Text(
                text = titleName,
                color = OrangeProject,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(
                        bottom = 8.dp
                    )
           )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                InfoChip("16+")
                InfoChip("Sunghoo Park")
                InfoChip("Netflix")
            }
        }

    }
}

@Composable
@Preview
private fun HeroBannerPreview(){
    MoviesAppTheme() {
        HeroBanner(
            titleBanner = "New Season 3",
            titleName = "Jujutsu Kaisen"
        )
    }
}
