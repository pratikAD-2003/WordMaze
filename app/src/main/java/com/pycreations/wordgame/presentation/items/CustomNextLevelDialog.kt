package com.pycreations.wordgame.presentation.items

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.pycreations.wordgame.R
import com.pycreations.wordgame.navgraph.Route

@Composable
fun CustomNextLevelDialog(levelName: String, onHome: (Boolean) -> Unit, onNext: () -> Unit) {
    var earnedName by remember { mutableStateOf(0) }
    if (levelName.toInt() < 50) {
        earnedName = 10
    } else if (levelName.toInt() < 100) {
        earnedName = 15
    } else if (levelName.toInt() < 150) {
        earnedName = 20
    } else if (levelName.toInt() < 200) {
        earnedName = 25
    } else {
        earnedName = 30
    }
    Dialog(onDismissRequest = {}) {
        Surface(
            color = Color.Transparent
        ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(Modifier.height(76.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color(0xFF3B2314))
                            .border(
                                width = 3.dp,
                                shape = RoundedCornerShape(15.dp),
                                color = Color(0xFFD8B07A)
                            )
                            .padding(top = 60.dp, bottom = 20.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "LEVEL - $levelName",
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
                            Spacer(Modifier.height(10.dp))
                            Image(
                                painter = painterResource(R.drawable.treasure),
                                contentDescription = "treasure",
                                modifier = Modifier.size(80.dp)
                            )
                            Spacer(Modifier.height(10.dp))
                            Text(
                                "+$earnedName Coins rewarded!",
                                color = Color.White, // Dark text like engraving
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
                            Spacer(Modifier.height(20.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Row(
                                    modifier = Modifier
                                        .clickable {
                                            onHome(false)
                                        }
                                        .clip(shape = RoundedCornerShape(10.dp))
                                        .background(
                                            Color(0xFF3B2314)
                                        )
                                        .border(
                                            2.dp,
                                            Color(0xFFD8B07A),
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .padding(vertical = 8.dp, horizontal = 15.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        "HOME",
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
                                }
                                Spacer(Modifier.width(20.dp))
                                Row(
                                    modifier = Modifier
                                        .clickable {
                                            onNext()
                                        }
                                        .clip(shape = RoundedCornerShape(10.dp))
                                        .background(
                                            Color(0xFFD8B07A)
                                        )
                                        .border(
                                            2.dp,
                                            Color(0xFFD8B07A),
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .padding(vertical = 8.dp, horizontal = 15.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        "NEXT",
                                        color = Color(0xFF3B2314), // Dark text like engraving
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
                                }
                            }
                        }
                    }
                }
                Image(
                    painter = painterResource(R.drawable.level_up),
                    contentDescription = "level up",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CNLP() {
//    CustomNextLevelDialog { }
}