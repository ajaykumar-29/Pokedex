package com.akumar.pokedex.ui.screens.pokemonListScreen.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.akumar.pokedex.R
import com.akumar.pokedex.data.models.PokemonListObject
import com.akumar.pokedex.ui.screens.pokemonListScreen.PokemonListViewModel
import com.akumar.pokedex.util.toThreeDigitString
import com.akumar.pokedex.util.with50PercentBlend

@Composable
fun PokemonCard(
    pokemon: PokemonListObject,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = hiltViewModel()
) {
    val defaultDominantColor = Color.LightGray
    var dominantColor by remember {
        mutableStateOf(defaultDominantColor)
    }
    Box(
        contentAlignment = Center,
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(
                dominantColor.with50PercentBlend()
            )
            .clickable {
                navController.navigate(
                    "pokemon_detail_screen/${pokemon.id}/${dominantColor.toArgb()}"
                )
            }
    ) {
        Text(
            text = "#${pokemon.id.toThreeDigitString()}",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0x88000080),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(4.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(contentAlignment = Center, modifier = Modifier.fillMaxSize(0.6f)) {
                Image(
                    painter = painterResource(R.drawable.pokeball),
                    contentDescription = "pokeball",
                    alpha = 0.3f,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Center)

                )
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(pokemon.imageUrl)
                        .listener(onSuccess = { request, result ->
                            viewModel.calcDominantColor(result.drawable) { color ->
                                dominantColor = color
                            }
                        })
                        .build(),
                    loading = {
                        Box(
                            contentAlignment = Center,
                            modifier = Modifier
                                .size(100.dp)
                        ) {
                            CircularProgressIndicator(
                                color = MaterialTheme.colorScheme.primary,
                            )
                        }
                    },
                    contentDescription = pokemon.pokemonName,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Center)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = pokemon.pokemonName,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White.copy(0.4f))
                    .align(CenterHorizontally)
                    .padding(horizontal = 20.dp, vertical = 8.dp)
            )
        }
    }
}