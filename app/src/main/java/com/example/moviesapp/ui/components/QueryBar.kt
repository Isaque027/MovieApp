package com.example.moviesapp.ui.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

//Estado: Uma informação ou variável que guarda a situação de uma interface ou comportamento do aplicativo

@Composable
fun QueryBar(
    modifier: Modifier = Modifier,
    query: String, //State Hoisting
    onQueryChange: (String) -> Unit //State Hoisting
) {
    //mutableStateOf() --> Uma função do jetpack compose que permite eu criar um objeto de "estado", cujo o valor pode ser alterado e suas mudanças podem ser rastreadas pelo compose
    // remember {} --> Composable que faz com que a interface "lembre" do valor do estado quando houver uma recomposição da interface

/*    val state = remember {
        mutableStateOf(value = "")
    }
    state.value = "One"*/

    //by --> Muda a forma como eu acesso o valor do estado fazendo com que eu não precise utilizar o .value
    //       usando by eu preciso utilizar var, pois o valor pode ser alterado
/*
    var state2 by remember {
        mutableStateOf("")
    }

    state2 = "One Piece"
*/
    //Composable: Campo de input/texto. Outlined é esse campo com bordas em volta
    OutlinedTextField(
        //value: propriedade que define que texto deve aparecer no campo
        value = query,
        //onValueChange: propriedade que é executada quando o usuário digita ou altera algo no campo de texto
        //               recebe uma lambda que cujo o parâmetro é o texto atual do usuário
        /*onValueChange = { newText ->
            onQueryChange(newText)
        }*/
        onValueChange = onQueryChange,

        modifier = modifier
            .fillMaxWidth()
        ,
        shape = RoundedCornerShape(50),
        placeholder = {
            Text("Buscar Filmes")
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun QueryBarPreview() {
    var query by remember {
        mutableStateOf("")
    }

    QueryBar(
        query = "",
        onQueryChange = { newText ->
            query = newText
        }
    )
}