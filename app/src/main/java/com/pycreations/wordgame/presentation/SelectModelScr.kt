package com.pycreations.wordgame.presentation

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pycreations.wordgame.R
import com.pycreations.wordgame.databse.AdsServices
import com.pycreations.wordgame.databse.SoundManager
import com.pycreations.wordgame.navgraph.Route
import com.pycreations.wordgame.presentation.items.CustomAdsOptionDialog

@Composable
fun SelectModeScr(context: Context, navHostController: NavHostController) {
    var showAdsDialog by remember { mutableStateOf(false) }
    val soundManager = SoundManager(context)

    if (showAdsDialog) {
        CustomAdsOptionDialog(onDismiss = {
            showAdsDialog = it
        }, onWatchAds = {
            AdsServices.showRewardedAds(context, onFailed = {
                showAdsDialog = false
            }, onRewardEarn = {
                showAdsDialog = false
            })
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
            modifier = Modifier
                .matchParentSize()
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(color = Color(0xFF3B2314))
                        .border(
                            width = 2.dp,
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFD8B07A)
                        )
                        .clickable {
                            soundManager.playTapSound()
                            navHostController.navigateUp()
                        }
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(R.drawable.baseline_arrow_back_24),
                        contentDescription = "watch",
                        modifier = Modifier.size(25.dp),
                        colorFilter = ColorFilter.tint(color = Color(0xFFD8B07A))
                    )
                }

                Row(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(color = Color(0xFF3B2314))
                        .border(
                            width = 2.dp,
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFD8B07A)
                        )
                        .clickable {
                            soundManager.playTapSound()
                            showAdsDialog = true
                        }
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Free Coins",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                        color = Color(0xFFD8B07A), // Dark text like engraving
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.4f),
                                offset = Offset(2f, 2f),
                                blurRadius = 2f
                            )
                        )
                    )
                    Spacer(Modifier.width(10.dp))
                    Image(
                        painter = painterResource(R.drawable.watch),
                        contentDescription = "watch",
                        modifier = Modifier.size(35.dp)
                    )
                }
            }
            Spacer(Modifier.height(20.dp))
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color(0xFF3B2314))
                            .border(
                                width = 2.dp,
                                shape = RoundedCornerShape(10.dp),
                                color = Color(0xFFD8B07A)
                            )
                            .clickable {
//                        onWatchAds()
                                soundManager.playTapSound()
                                navHostController.navigate(Route.PlayBoardScreenR.route)
                            }
                            .padding(horizontal = 10.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Word Formation",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                                color = Color(0xFFD8B07A), // Dark text like engraving
                                style = TextStyle(
                                    shadow = Shadow(
                                        color = Color.Black.copy(alpha = 0.4f),
                                        offset = Offset(2f, 2f),
                                        blurRadius = 2f
                                    )
                                )
                            )
                            Spacer(Modifier.height(5.dp))
                            Text(
                                text = "Select letters to make your words!",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                                color = Color(0xFFD8B07A), // Dark text like engraving
                                style = TextStyle(
                                    shadow = Shadow(
                                        color = Color.Black.copy(alpha = 0.4f),
                                        offset = Offset(2f, 2f),
                                        blurRadius = 2f
                                    )
                                )
                            )
                        }
                        Image(
                            painter = painterResource(R.drawable.watch),
                            contentDescription = "watch",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(end = 10.dp)
                        )
                    }
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color(0xFF3B2314))
                            .border(
                                width = 2.dp,
                                shape = RoundedCornerShape(10.dp),
                                color = Color(0xFFD8B07A)
                            )
                            .clickable {
//                        onWatchAds()
                                soundManager.playTapSound()
                                navHostController.navigate(Route.SentenceFormBoard.route)
                            }
                            .padding(horizontal = 10.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = "Complete the Sentence",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                                color = Color(0xFFD8B07A), // Dark text like engraving
                                style = TextStyle(
                                    shadow = Shadow(
                                        color = Color.Black.copy(alpha = 0.4f),
                                        offset = Offset(2f, 2f),
                                        blurRadius = 2f
                                    )
                                )
                            )
                            Spacer(Modifier.height(5.dp))
                            Text(
                                text = "Select letters to complete the sentence!",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                                color = Color(0xFFD8B07A), // Dark text like engraving
                                style = TextStyle(
                                    shadow = Shadow(
                                        color = Color.Black.copy(alpha = 0.4f),
                                        offset = Offset(2f, 2f),
                                        blurRadius = 2f
                                    )
                                )
                            )
                        }
                        Image(
                            painter = painterResource(R.drawable.watch),
                            contentDescription = "watch",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(end = 10.dp)
                        )
                    }
                }
            }
        }
    }
}

//@Composable
//@Preview(showBackground = true)
//fun SelectModePrev() {
//    SelectModeScr()
//}