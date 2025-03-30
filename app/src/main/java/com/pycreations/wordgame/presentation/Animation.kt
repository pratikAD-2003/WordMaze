package com.pycreations.wordgame.presentation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import com.airbnb.lottie.compose.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.pycreations.wordgame.R

@Composable
fun CelebrationAnimation() {
    val celebrationComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.celebration_anim))

    val celebrationProgress by animateLottieCompositionAsState(
        composition = celebrationComposition,
        iterations = 1, // Play once
        isPlaying = true
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = celebrationComposition,
            progress = { celebrationProgress },
            modifier = Modifier.size(250.dp)
        )
    }
}

@Composable
fun CoinAnimation() {
    val coinComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.coin_win_anim))

    val coinProgress by animateLottieCompositionAsState(
        composition = coinComposition,
        iterations = 1, // Play once
        isPlaying = true
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = coinComposition,
            progress = { coinProgress },
            modifier = Modifier.size(250.dp)
        )
    }
}
