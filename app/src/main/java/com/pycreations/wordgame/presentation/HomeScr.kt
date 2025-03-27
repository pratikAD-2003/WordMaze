package com.pycreations.wordgame.presentation

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pycreations.wordgame.R
import com.pycreations.wordgame.databse.BackgroundMusicManager
import com.pycreations.wordgame.databse.SharedPrefFunctions
import com.pycreations.wordgame.databse.SoundManager
import com.pycreations.wordgame.navgraph.Route
import com.pycreations.wordgame.presentation.items.CustomSettingDialog

@Composable
fun HomeScr(navHostController: NavHostController, context: Context) {
    val soundManager = SoundManager(context)
    val musicSP =
        context.getSharedPreferences(SharedPrefFunctions.MUSIC_DB, Context.MODE_PRIVATE)

    var showSettingDialog by remember { mutableStateOf(false) }
    if (showSettingDialog) {
        CustomSettingDialog(context, onMusic = {
            soundManager.playTapSound()
            SharedPrefFunctions.toggleMusic(context)
            if (musicSP.getBoolean(SharedPrefFunctions.MUSIC_DB, true)) {
                BackgroundMusicManager.startMusic(context)
            } else {
                BackgroundMusicManager.pauseMusic()
            }
        }, onSound = {
            soundManager.playTapSound()
            SharedPrefFunctions.toggleSound(context)
        }, onExit = {
            soundManager.playTapSound()
            showSettingDialog = false
            navHostController.navigateUp()
        }, onVibrate = {
            SharedPrefFunctions.toggleVibrate(context)
        },
            onDismiss = {
                soundManager.playTapSound()
                showSettingDialog = it
            })
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.matchParentSize(),
            painter = painterResource(R.drawable.cartoon_style_scene),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.matchParentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                painter = painterResource(R.drawable.app_logo_transparent_2),
                contentDescription = ""
            )
            Spacer(modifier = Modifier)
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier
                        .clickable {
                            soundManager.playTapSound()
//                            navHostController.navigate(Route.SentenceFormBoard.route)
                            navHostController.navigate(Route.PlayBoardScreenR.route)
                        }
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(
                            Color(0xFF3B2314)
                        )
                        .border(
                            5.dp,
                            Color(0xFFD8B07A),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(vertical = 10.dp, horizontal = 25.dp)
                        .height(45.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "PLAY",
                        color = Color(0xFFD8B07A), // Dark text like engraving
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.4f),
                                offset = Offset(2f, 2f),
                                blurRadius = 2f
                            )
                        ),
                        fontSize = 35.sp,
                        fontFamily = FontFamily(Font(R.font.boolagoo_regular))
                    )
                    Spacer(Modifier.width(10.dp))
                    Image(
                        modifier = Modifier.size(45.dp),
                        painter = painterResource(R.drawable.play),
                        contentDescription = "Play"
                    )
                }
                Spacer(Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .clickable {
                            soundManager.playTapSound()
                            showSettingDialog = true
                        }
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(
                            Color(0xFF3B2314)
                        )
                        .border(
                            3.dp,
                            Color(0xFFD8B07A),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(vertical = 5.dp, horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "SETTINGS",
                        color = Color(0xFFD8B07A), // Dark text like engraving
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.4f),
                                offset = Offset(2f, 2f),
                                blurRadius = 2f
                            )
                        ),
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.boolagoo_regular))
                    )
//                    Spacer(Modifier.width(10.dp))
//                    Image(
//                        modifier = Modifier.size(45.dp),
//                        painter = painterResource(R.drawable.play),
//                        contentDescription = "Play"
//                    )
                }
            }

        }
    }
}