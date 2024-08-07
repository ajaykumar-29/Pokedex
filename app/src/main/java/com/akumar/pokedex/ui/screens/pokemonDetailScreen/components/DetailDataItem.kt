package com.akumar.pokedex.ui.screens.pokemonDetailScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun PokemonDetailDataItem(
    dataValue: Float, dataUnit: String, dataIcon: Painter, modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(painter = dataIcon, contentDescription = "")
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "$dataValue$dataUnit", color = MaterialTheme.colorScheme.onSurface
        )
    }
}