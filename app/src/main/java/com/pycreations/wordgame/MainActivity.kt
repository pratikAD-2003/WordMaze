package com.pycreations.wordgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.gms.ads.MobileAds
import com.pycreations.wordgame.databse.AdsServices
import com.pycreations.wordgame.databse.BackgroundMusicManager
import com.pycreations.wordgame.navgraph.NavGraph
import com.pycreations.wordgame.ui.theme.WordGameTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()

        val backgroundScope = CoroutineScope(Dispatchers.IO)
        backgroundScope.launch {
            // Initialize the Google Mobile Ads SDK on a background thread.
            MobileAds.initialize(this@MainActivity) {}
        }
        AdsServices.loadRewardedAds(baseContext)
//        AdsServices.loadInterstitialAds(this, onLoadFailed = {}, onDismiss = {})
        setContent {
            WordGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        NavGraph()
                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        BackgroundMusicManager.pauseMusic()
    }

    override fun onResume() {
        super.onResume()
        BackgroundMusicManager.startMusic(baseContext)
    }
}
