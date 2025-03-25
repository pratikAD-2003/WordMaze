package com.pycreations.wordgame.presentation.items

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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.pycreations.wordgame.R
import com.pycreations.wordgame.databse.SharedPrefFunctions
import com.pycreations.wordgame.databse.SoundManager
import com.pycreations.wordgame.databse.VibrateManager

@Composable
fun CustomSettingDialog(
    context: Context,
    onMusic: () -> Unit,
    onSound: () -> Unit,
    onVibrate: () -> Unit,
    onExit: () -> Unit,
    onDismiss: (Boolean) -> Unit
) {
    val musicSP = context.getSharedPreferences(SharedPrefFunctions.MUSIC_DB, Context.MODE_PRIVATE)
    val soundSP = context.getSharedPreferences(SharedPrefFunctions.SOUND_DB, Context.MODE_PRIVATE)
    val vibrateSP =
        context.getSharedPreferences(SharedPrefFunctions.VIBRATE_DB, Context.MODE_PRIVATE)
    val soundManager = SoundManager(context)

    var checkMusic by remember {
        mutableStateOf(
            musicSP.getBoolean(
                SharedPrefFunctions.MUSIC_DB, true
            )
        )
    }
    var checkSound by remember {
        mutableStateOf(
            soundSP.getBoolean(
                SharedPrefFunctions.SOUND_DB, true
            )
        )
    }
    var checkVibrate by remember {
        mutableStateOf(
            vibrateSP.getBoolean(
                SharedPrefFunctions.VIBRATE_DB, true
            )
        )
    }

    Dialog(onDismissRequest = {
//        onDismiss(false)
    }) {
        Surface(
            color = Color.Transparent
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.wood_b1),
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                Column(
                    modifier = Modifier
                        .matchParentSize()
                        .padding(vertical = 5.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Box(modifier = Modifier
                            .size(30.dp)
                            .clip(shape = CircleShape)
                            .background(Color.Transparent)
                            .clickable {
                                onDismiss(false)
                            })
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = if (checkSound) painterResource(R.drawable.sound) else painterResource(
                            R.drawable.no_sound
                        ),
                            contentDescription = "sound",
                            modifier = Modifier
                                .size(55.dp)
                                .clickable {
                                    checkSound = !checkSound
                                    if (checkSound) {
                                        soundManager.playTapSound()
                                    }
                                    onSound()
                                })
                        Spacer(Modifier.width(15.dp))
                        Image(painter = if (checkMusic) painterResource(R.drawable.music) else painterResource(
                            R.drawable.no_music
                        ),
                            contentDescription = "music",
                            modifier = Modifier
                                .size(55.dp)
                                .clickable {
                                    checkMusic = !checkMusic
                                    onMusic()
                                })

                        Spacer(Modifier.width(15.dp))
                        Image(painter = if (checkVibrate) painterResource(R.drawable.vibrate) else painterResource(
                            R.drawable.not_vibrate
                        ),
                            contentDescription = "vibrate",
                            modifier = Modifier
                                .size(55.dp)
                                .clickable {
                                    checkVibrate = !checkVibrate
                                    if (checkVibrate) {
                                        VibrateManager.vibrateDevice(context)
                                    }
                                    onVibrate()
                                })
                        Spacer(Modifier.width(15.dp))
                        Image(painter = painterResource(R.drawable.exit),
                            contentDescription = "exit",
                            modifier = Modifier
                                .size(55.dp)
                                .clickable {
                                    onExit()
                                })
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(modifier = Modifier
                            .size(50.dp)
                            .clip(shape = CircleShape)
                            .background(Color.Transparent)
                            .clickable {
                                onDismiss(false)
                            })
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CSPreview() {
//    CustomSettingDialog(onMusic = {}, onDismiss = {
//
//    }, onSound = {}, onExit = {})
//}