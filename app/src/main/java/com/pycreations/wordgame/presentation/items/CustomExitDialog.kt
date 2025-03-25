package com.pycreations.wordgame.presentation.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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

@Composable
fun CustomExitDialog(text: String, onDismiss: (Boolean) -> Unit, onYes: () -> Unit) {
    Dialog(onDismissRequest = {
//        onDismiss(false)
    }) {
        Surface(
            color = Color.Transparent
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(R.drawable.wood_b2), contentDescription = "", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
                Column(
                    modifier = Modifier.matchParentSize().padding(vertical = 5.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(end = 10.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Box(modifier = Modifier.size(30.dp).clip(shape = CircleShape).background(Color.Transparent).clickable {
                            onDismiss(false)
                        })
                    }
                    Text(
                        text = text,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.boolagoo_regular)),
                        color = Color(0xFF3B2314), // Dark text like engraving
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.4f),
                                offset = Offset(2f, 2f),
                                blurRadius = 2f
                            )
                        )
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(bottom = 5.dp),
                        horizontalArrangement = Arrangement.Absolute.SpaceEvenly
                    ) {
                        Box(modifier = Modifier.size(50.dp).clip(shape = CircleShape).background(Color.Transparent).clickable {

                            onYes()
                        })
                        Box(modifier = Modifier.size(50.dp).clip(shape = CircleShape).background(Color.Transparent).clickable {
                            onDismiss(false)
                        })
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CEPreview() {
    CustomExitDialog("Do want to exit ?", onDismiss = {

    }, onYes = {

    })
}