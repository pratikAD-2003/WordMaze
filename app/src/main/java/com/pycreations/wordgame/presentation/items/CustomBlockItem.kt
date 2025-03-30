package com.pycreations.wordgame.presentation.items

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

@Composable
fun WoodenBlock(letter: Char, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(50.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(2.dp, Color(0xFF3B2314), RoundedCornerShape(8.dp)) // Dark border
            .shadow(4.dp, shape = RoundedCornerShape(8.dp)),

        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(8.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFFD8B07A), Color(0xFFA96E3C)) // More balanced colors
                    )
                )
        )
        Text(
            text = letter.toString(),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3B2314), // Dark text like engraving
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.4f),
                    offset = Offset(2f, 2f),
                    blurRadius = 2f
                )
            )
        )
    }
}

@Composable
fun WoodenBlockShow(letter: Char, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(2.dp, Color(0xFF3B2314), RoundedCornerShape(8.dp)) // Dark border
            .shadow(4.dp, shape = RoundedCornerShape(8.dp)), // Soft depth
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(8.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFFD8B07A), Color(0xFFA96E3C)) // More balanced colors
                    )
                )
        )
        Text(
            text = letter.toString(),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3B2314), // Dark text like engraving
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.4f),
                    offset = Offset(2f, 2f),
                    blurRadius = 2f
                )
            )
        )
    }
}

@Composable
fun WoodenBlockShow3(letter: Char, modifier: Modifier = Modifier,scale : Float) {
    Box(
        modifier = modifier
            .size(40.dp).scale(scale)
            .clip(RoundedCornerShape(8.dp))
            .border(2.dp, Color(0xFF3B2314), RoundedCornerShape(8.dp)) // Dark border
            .shadow(4.dp, shape = RoundedCornerShape(8.dp)), // Soft depth
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(8.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFFD8B07A), Color(0xFFA96E3C)) // More balanced colors
                    )
                )
        )
        Text(
            text = letter.toString(),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3B2314), // Dark text like engraving
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.4f),
                    offset = Offset(2f, 2f),
                    blurRadius = 2f
                )
            )
        )
    }
}
