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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.pycreations.wordgame.R

@Composable
fun CustomHintDialog(
    availableCoin: String,
    onDismiss: (Boolean) -> Unit,
    onRevelLetter: () -> Unit,
    onRevelWord: () -> Unit
) {
    Dialog(onDismissRequest = {
        onDismiss(false)
    }) {
        Surface(
            color = Color.Transparent
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                contentAlignment = Alignment.TopEnd
            ) {

                Column(
                    modifier = Modifier.padding(horizontal = 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(Modifier.height(15.dp))
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
                            .padding(vertical = 15.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Need a Hint ?",
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
                            Spacer(Modifier.height(5.dp))
                            Text(
                                text = "Stuck on this word? Use a hint to help you out!",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraLight,
                                fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                                color = Color(0xFFD8B07A), // Dark text like engraving
                                style = TextStyle(
                                    shadow = Shadow(
                                        color = Color.Black.copy(alpha = 0.4f),
                                        offset = Offset(2f, 2f),
                                        blurRadius = 2f
                                    )
                                ),
                                textAlign = TextAlign.Center
                            )
                            Spacer(Modifier.height(10.dp))
                            Text(
                                text = "Currently You have $availableCoin Coins!",
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
                            Spacer(Modifier.height(20.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Absolute.SpaceEvenly
                            ) {
                                Box(
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(5.dp))
                                        .shadow(elevation = 2.dp)
//                                        .background(color = Color(0xFF3B2314))
                                        .background(color = Color(0xFFD8B07A))
                                        .border(
                                            width = 2.dp,
                                            shape = RoundedCornerShape(5.dp),
                                            color = Color(0xFFD8B07A)
                                        )
                                        .clickable {

                                        }
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,
                                        modifier = Modifier.padding(5.dp)
                                    ) {

                                        Text(
                                            text = "Revel a Letter",
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                                            color = Color(0xFF3B2314), // Dark text like engraving
                                            style = TextStyle(
                                                shadow = Shadow(
                                                    color = Color.Black.copy(alpha = 0.4f),
                                                    offset = Offset(2f, 2f),
                                                    blurRadius = 2f
                                                )
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                        Text(
                                            text = "In 20 coins",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                                            color = Color(0xFF3B2314), // Dark text like engraving
                                            style = TextStyle(
                                                shadow = Shadow(
                                                    color = Color.Black.copy(alpha = 0.4f),
                                                    offset = Offset(2f, 2f),
                                                    blurRadius = 2f
                                                )
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                        Text(
                                            text = "( _ o u r )",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                                            color = Color(0xFF3B2314), // Dark text like engraving
                                            style = TextStyle(
                                                shadow = Shadow(
                                                    color = Color.Black.copy(alpha = 0.4f),
                                                    offset = Offset(2f, 2f),
                                                    blurRadius = 2f
                                                )
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                                Box(
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(5.dp))
                                        .shadow(elevation = 2.dp)
//                                        .background(color = Color(0xFF3B2314))
                                        .background(color = Color(0xFFD8B07A))
                                        .border(
                                            width = 2.dp,
                                            shape = RoundedCornerShape(5.dp),
                                            color = Color(0xFFD8B07A)
                                        )
                                        .clickable {

                                        }
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,
                                        modifier = Modifier.padding(5.dp)
                                    ) {

                                        Text(
                                            text = "Revel a Word",
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                                            color = Color(0xFF3B2314), // Dark text like engraving
                                            style = TextStyle(
                                                shadow = Shadow(
                                                    color = Color.Black.copy(alpha = 0.4f),
                                                    offset = Offset(2f, 2f),
                                                    blurRadius = 2f
                                                )
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                        Text(
                                            text = "In 30 coins",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                                            color = Color(0xFF3B2314), // Dark text like engraving
                                            style = TextStyle(
                                                shadow = Shadow(
                                                    color = Color.Black.copy(alpha = 0.4f),
                                                    offset = Offset(2f, 2f),
                                                    blurRadius = 2f
                                                )
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                        Text(
                                            text = "( _ _ _ _ )",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                                            color = Color(0xFF3B2314), // Dark text like engraving
                                            style = TextStyle(
                                                shadow = Shadow(
                                                    color = Color.Black.copy(alpha = 0.4f),
                                                    offset = Offset(2f, 2f),
                                                    blurRadius = 2f
                                                )
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }
                            Spacer(Modifier.height(20.dp))
                            Text(
                                text = "Choose wisely and keep forming words to earn more coins!",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.ExtraLight,
                                fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                                color = Color(0xFFD8B07A), // Dark text like engraving
                                style = TextStyle(
                                    shadow = Shadow(
                                        color = Color.Black.copy(alpha = 0.4f),
                                        offset = Offset(2f, 2f),
                                        blurRadius = 2f
                                    )
                                ),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(horizontal = 10.dp)
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(shape = CircleShape)
                        .background(color = Color(0xFF3B2314))
                        .border(width = 3.dp, shape = CircleShape, color = Color(0xFFD8B07A))
                        .clickable {
                            onDismiss(false)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.close),
                        contentDescription = "close",
                        modifier = Modifier.size(15.dp),
                        colorFilter = ColorFilter.tint(color = Color(0xFFD8B07A))
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CustomHintDialogPrev() {
    CustomHintDialog(availableCoin = "100", onDismiss = {}, onRevelLetter = {}, onRevelWord = {})
}