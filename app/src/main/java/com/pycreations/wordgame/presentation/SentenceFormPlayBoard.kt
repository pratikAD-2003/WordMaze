package com.pycreations.wordgame.presentation

import android.content.Context
import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pycreations.wordgame.R
import com.pycreations.wordgame.data.sentenceForm.SentenceData
import com.pycreations.wordgame.data.sentenceForm.SentenceModel
import com.pycreations.wordgame.databse.AdsServices
import com.pycreations.wordgame.databse.BackgroundMusicManager
import com.pycreations.wordgame.databse.SharedPrefFunctions
import com.pycreations.wordgame.databse.SoundManager
import com.pycreations.wordgame.databse.VibrateManager
import com.pycreations.wordgame.presentation.items.CustomAdsOptionDialog
import com.pycreations.wordgame.presentation.items.CustomExitDialog
import com.pycreations.wordgame.presentation.items.CustomHintDialog
import com.pycreations.wordgame.presentation.items.CustomNextLevelDialog
import com.pycreations.wordgame.presentation.items.CustomSettingDialog
import com.pycreations.wordgame.presentation.items.WoodenBlockShow
import com.pycreations.wordgame.presentation.items.WoodenBlockShow3
import com.pycreations.wordgame.presentation.items.WordFormationHintDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Locale

@Composable
fun SentenceFormPlayBoard(context: Context, navHostController: NavHostController) {
    var enteredWord by remember { mutableStateOf("") }
    var currentLevel by remember {
        mutableIntStateOf(
            SharedPrefFunctions.getCurrentLevelWordSentence(
                context
            )
        )
    }
    var totalLevels by remember { mutableIntStateOf(SentenceData.sentenceLevels.size) }

    var levelData by remember { mutableStateOf(updateLevel(currentLevel)) }
    var cc by remember { mutableIntStateOf(SharedPrefFunctions.getCoins(context)) }
    var givenCharacters by remember { mutableStateOf(levelData.givenCharacters) }
    var borderBoxSize by remember { mutableStateOf(getBorderBoxSize(givenCharacters.size)) }

    val soundManager = SoundManager(context)
    val musicSP = context.getSharedPreferences(SharedPrefFunctions.MUSIC_DB, Context.MODE_PRIVATE)

    var showToHomeDialog by remember { mutableStateOf(false) }
    var showSettingDialog by remember { mutableStateOf(false) }
    var showNextLevelDialog by remember { mutableStateOf(false) }
    var showHintDialog by remember { mutableStateOf(false) }

    var showHintDialog2 by remember { mutableStateOf(false) }
    var showHintDialog3 by remember { mutableStateOf(false) }
    var showNotEnoughCoins by remember { mutableStateOf(false) }
    var showAdsDialog by remember { mutableStateOf(false) }
    var showWinAnimation by remember { mutableStateOf(false) }
    var triggerAnimation by remember { mutableStateOf(false) }
    var allLevelDone by remember { mutableStateOf(false) }


    if (showWinAnimation) {
        triggerAnimation = true
    }

    var h by remember {
        mutableStateOf(
            levelData.targetWord
        )
    }

    if (allLevelDone) {
        WordFormationHintDialog(
            text = "Congratulation!",
            hint = "You have finished all the levels of 'Word Formation' category!\nPlease leave a mail to the developer for any feedback or add new levels!",
            onWatchAds = {
                SharedPrefFunctions.resetSentenceCompletion(context)
                allLevelDone = false
                navHostController.navigateUp()
            },
            onDismiss = {
                allLevelDone = it
                navHostController.navigateUp()
            })
    }

    if (showAdsDialog) {
        CustomAdsOptionDialog(onDismiss = {
            showAdsDialog = it
        }, onWatchAds = {
            AdsServices.showRewardedAds(context, onFailed = {
                showAdsDialog = false
            }, onRewardEarn = {
                SharedPrefFunctions.updateC(context,30)
                cc =
                    SharedPrefFunctions.getCoins(context)
                showAdsDialog = false
            })
        })
    }
    if (showHintDialog3) {
        WordFormationHintDialog(
            text = "HINT",
            hint = "'" + getHFormat(h) + "'",
            onWatchAds = {},
            onDismiss = {
                showHintDialog3 = it
            })
    }

    if (showHintDialog2) {
        WordFormationHintDialog(text = "HINT", hint = "'" + h + "'", onWatchAds = {}, onDismiss = {
            showHintDialog2 = it
        })
    }

    if (showNotEnoughCoins) {
        WordFormationHintDialog(
            text = "Ohhh! no...",
            hint = "You didn't have Enough Coins to get HINT,watch Ads videos to earn coins or pass levels!",
            onWatchAds = {},
            onDismiss = {
                showNotEnoughCoins = it
            })
    }

    if (showHintDialog) {
        CustomHintDialog(availableCoin = cc.toString(), onDismiss = {
            showHintDialog = it
        }, onRevelLetter = {
            showHintDialog = false
            if (SharedPrefFunctions.getCoins(context) >= 20) {
                SharedPrefFunctions.subtractCoins(context, 20)
                cc = SharedPrefFunctions.getCoins(context)
                showHintDialog3 = true
            } else {
                // perform not enough coins
                showNotEnoughCoins = true
            }
        }, onRevelWord = {
            showHintDialog = false
            if (SharedPrefFunctions.getCoins(context) >= 30) {
                SharedPrefFunctions.subtractCoins(context, 30)
                cc = SharedPrefFunctions.getCoins(context)
                showHintDialog2 = true
            } else {
                // perform not enough coins
                showNotEnoughCoins = true
            }
        })
    }


    if (showToHomeDialog) {
        CustomExitDialog("Do want to exit ?", onYes = {
            // perform exit operation
            soundManager.playTapSound()
            showToHomeDialog = false
            navHostController.navigateUp()
        }, onDismiss = {
            soundManager.playTapSound()
            showToHomeDialog = it
        })
    }

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
        }, onDismiss = {
            soundManager.playTapSound()
            showSettingDialog = it
        })
    }
    if (showNextLevelDialog) {
        CustomNextLevelDialog(levelData.levelNumber.toString(), onHome = {
            soundManager.playTapSound()
            showNextLevelDialog = false
            navHostController.navigateUp()
        }, onNext = {
            soundManager.playTapSound()
            currentLevel++
            levelData = updateLevel(currentLevel)
            givenCharacters = levelData.givenCharacters
            borderBoxSize = getBorderBoxSize(givenCharacters.size)
            givenCharacters.shuffled()
            showNextLevelDialog = false
        })
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.red_board_2),
            contentDescription = "",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .clip(
                            shape = RoundedCornerShape(
                                bottomStart = 15.dp, bottomEnd = 15.dp
                            )
                        )
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color(0xFFD8B07A), Color(0xFFA96E3C)) // More balanced colors
                            )
                        )
                        .padding(vertical = 5.dp, horizontal = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(
                                Color(0xFF3B2314)
                            )
                            .border(
                                2.dp, Color(0xFF3B2314), shape = RoundedCornerShape(20.dp)
                            )
                            .padding(2.dp)
                            .height(35.dp)
                            .clickable {
                                showAdsDialog = true
                            },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.coin),
                            contentDescription = "coin",
                            modifier = Modifier.size(40.dp)
                        )
                        Text(
                            "$cc",
                            color = Color(0xFFD8B07A), // Dark text like engraving
                            style = TextStyle(
                                shadow = Shadow(
                                    color = Color.Black.copy(alpha = 0.4f),
                                    offset = Offset(2f, 2f),
                                    blurRadius = 2f
                                )
                            ),
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.boolagoo_regular))
                        )
                        Spacer(Modifier.width(5.dp))
                        Image(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "coin",
                            modifier = Modifier.size(25.dp),
                            colorFilter = ColorFilter.tint(Color(0xFFD8B07A))
                        )
                    }
                    Row(
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        Color(0xFFD8B07A), Color(0xFFA96E3C)
                                    ) // More balanced colors
                                )
                            )
                            .border(
                                2.dp, Color(0xFF3B2314), shape = RoundedCornerShape(20.dp)
                            )
                            .width(110.dp)
                            .padding(2.dp)
                            .height(35.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Level ${levelData.levelNumber}",
                            color = Color(0xFF3B2314), // Dark text like engraving
                            style = TextStyle(
                                shadow = Shadow(
                                    color = Color.Black.copy(alpha = 0.4f),
                                    offset = Offset(2f, 2f),
                                    blurRadius = 2f
                                )
                            ),
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.boolagoo_regular))
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top
                ) {
                    Image(
                        painter = painterResource(R.drawable.app_logo_transparent_2),
                        contentDescription = "app_logo",
                        modifier = Modifier.size(70.dp)
                    )
                }
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(horizontal = 10.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.board_1),
                        contentDescription = "",
                        modifier = Modifier.matchParentSize(),
                        contentScale = ContentScale.FillBounds
                    )
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .padding(horizontal = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            levelData.sentence,
                            color = Color(0xFF3B2314), // Dark text like engraving
                            style = TextStyle(
                                shadow = Shadow(
                                    color = Color.Black.copy(alpha = 0.4f),
                                    offset = Offset(2f, 2f),
                                    blurRadius = 2f
                                )
                            ),
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF3B2314))
                            .border(
                                2.dp, color = Color(0xFFD8B07A), shape = RoundedCornerShape(10.dp)
                            )
                            .height(55.dp)
                            .padding(horizontal = if (enteredWord.isEmpty()) 0.dp else 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
//                            items(enteredWord.toCharArray().toTypedArray()) { char ->
//                                WoodenBlockShow(char.uppercaseChar())
//                            }
                            itemsIndexed(enteredWord.toCharArray().toTypedArray()) { index, word ->
                                var scale by remember { mutableStateOf(0f) }

                                // Animate scale from 0 to 1
                                val animatedScale by animateFloatAsState(
                                    targetValue = scale,
                                    animationSpec = tween(
                                        durationMillis = 50,
                                        delayMillis = index * 100
                                    ),
                                    label = "scaleAnimation"
                                )

                                // Start animation when the item appears
                                LaunchedEffect(Unit) {
                                    scale = 1f
                                }
                                WoodenBlockShow3(word.uppercaseChar(), scale = animatedScale)
                            }
                        }
                    }
                    Spacer(Modifier.height(5.dp))
                    Box(modifier = Modifier.weight(1f)) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier.weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Image(painter = painterResource(R.drawable.hint),
                                        contentDescription = "hint",
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clickable {
                                                soundManager.playTapSound()
                                                showHintDialog = true
                                            })
                                    Image(painter = painterResource(R.drawable.shuffle_icon),
                                        contentDescription = "shuffle",
                                        modifier = Modifier
                                            .size(55.dp)
                                            .clickable {
                                                soundManager.playTapSound()
                                                givenCharacters =
                                                    levelData.givenCharacters.shuffled()
                                            })
                                }
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 10.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(borderBoxSize) // Define boundary size
                                            .background(Color(0xFF3B2314), shape = CircleShape)
                                            .border(
                                                width = 3.dp,
                                                shape = CircleShape,
                                                color = Color(0xFFD8B07A)
                                            ), contentAlignment = Alignment.Center
                                    ) {
                                        val charList = givenCharacters.flatMap { it.toList() }
                                        DragSelectionWoodenBlocks3(charList,
                                            isTouchEnable = true,
                                            onCharacterClick = { selectedChar ->
                                                enteredWord += selectedChar
                                            },
                                            onDragEnd = {
                                                if (checkMatch(
                                                        levelData.targetWord, enteredWord
                                                    )
                                                ) {
                                                    soundManager.playCorrectAnsSound()
                                                    soundManager.playLevelCompleteSound()
                                                    SharedPrefFunctions.updateLevelWordSentence(
                                                        context
                                                    )
                                                    if ( levelData.levelNumber.toInt() > SentenceData.sentenceLevels.size-1) {
                                                        allLevelDone = true
                                                        SharedPrefFunctions.resetSentenceCompletion(context)
                                                    } else {
                                                        CoroutineScope(Dispatchers.IO).launch {
                                                            delay(500)
                                                            cc =
                                                                SharedPrefFunctions.getCoins(context)
                                                            showWinAnimation = true
                                                        }
                                                    }
                                                } else {
                                                    soundManager.playWrongAnsSound()
                                                    VibrateManager.vibrateDevice(context)
                                                }
                                                enteredWord = ""
                                            })
                                    }
                                }
                                Spacer(Modifier.height(20.dp))
                            }
                            Row(
                                modifier = Modifier
                                    .clip(
                                        shape = RoundedCornerShape(
                                            topEnd = 15.dp, topStart = 15.dp
                                        )
                                    )
                                    .fillMaxWidth()
                                    .background(
                                        Brush.verticalGradient(
                                            listOf(
                                                Color(0xFFD8B07A), Color(0xFFA96E3C)
                                            ) // More balanced colors
                                        )
                                    )
                                    .padding(vertical = 5.dp, horizontal = 5.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Image(painter = painterResource(R.drawable.home),
                                    contentDescription = "home",
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clickable {
                                            soundManager.playTapSound()
                                            showToHomeDialog = true
                                        })
                                Image(painter = painterResource(R.drawable.settting),
                                    contentDescription = "setting",
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clickable {
                                            soundManager.playTapSound()
                                            showSettingDialog = true
                                        })
                            }
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
            if (showWinAnimation) {
                CelebrationAnimation()
                LaunchedEffect(Unit) {
                    delay(1000)
                    VibrateManager.vibrateLongMilliDevice(context)
                    delay(2000)
                    showWinAnimation = false
                    showNextLevelDialog = true
                }
            }
        }
    }
}


private fun updateLevel(currentLevel: Int): SentenceModel {
    return SentenceData.sentenceLevels[currentLevel]
}

private fun checkMatch(targetWord: String, input: String): Boolean {
    return targetWord == input
}

private fun getBorderBoxSize(noOfChar: Int): Dp {
    if (noOfChar == 3) {
        return 195.dp
    } else if (noOfChar == 4) {
        return 200.dp
    } else if (noOfChar == 5) {
        return 210.dp
    } else if (noOfChar == 6) {
        return 225.dp
    } else if (noOfChar > 6) {
        return 250.dp
    }
    return 230.dp
}

private fun getHFormat(word: String): String {
    if (word.isEmpty()) return ""
    return word.first() + " _ ".repeat(word.length - 1)
}


@Composable
@Preview(showBackground = true)
fun SFPPrev() {
    val context = LocalContext.current
    val navHostController = NavHostController(context)
    SentenceFormPlayBoard(context, navHostController)
}