package com.pycreations.wordgame.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pycreations.wordgame.presentation.items.WoodenBlock
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun DragSelectionWoodenBlocks2(
    characters: List<Char>,
    isTouchEnable: Boolean,
    onCharacterClick: (Char) -> Unit,
    onDragEnd: () -> Unit
) {
    val selectedBlocks = remember { mutableStateListOf<Char>() }
    val boxSize = 50.dp

    val boxPositions = remember { mutableStateMapOf<Char, androidx.compose.ui.geometry.Rect>() }
    var isDragging by remember { mutableStateOf(false) }

    val path = remember { Path() }
    var lastPoint by remember { mutableStateOf(Offset.Zero) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(isTouchEnable) {
                if (isTouchEnable) {
                    detectDragGesturesAfterLongPress(
                        onDragStart = { offset ->
                            val startLetter = boxPositions.entries.find { (_, rect) ->
                                rect.contains(offset) // ✅ Uses Offset correctly
                            }?.key

                            if (startLetter != null && !selectedBlocks.contains(startLetter)) {
                                selectedBlocks.add(startLetter)
                                onCharacterClick(startLetter)
                                isDragging = true
                                path.reset()
                                path.moveTo(offset.x, offset.y)
                                lastPoint = offset
                            }
                        },
                        onDrag = { change, _ ->
                            if (isDragging) {
                                val position = change.position
                                path.lineTo(position.x, position.y)
                                lastPoint = position

                                val selectedLetter = boxPositions.entries.find { (_, rect) ->
                                    rect.contains(position)
                                }?.key

                                if (selectedLetter != null && !selectedBlocks.contains(
                                        selectedLetter
                                    )
                                ) {
                                    selectedBlocks.add(selectedLetter)
                                    onCharacterClick(selectedLetter)
                                }
                            }
                        },
                        onDragEnd = {
                            isDragging = false
                            path.reset() // ✅ Clears the drawn path
                            selectedBlocks.clear()
                            boxPositions.clear()
                            lastPoint = Offset.Zero
                            onDragEnd()
                        }
                    )
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(
                path = path,
                color = Color(0xFFD8B07A),
                style = Stroke(width = 20f, cap = StrokeCap.Square)
            )
        }

        Layout(
            content = {
                characters.forEach { letter ->
                    WoodenBlock(
                        letter = letter.uppercaseChar(),
                        modifier = Modifier.background(
                            if (selectedBlocks.contains(letter)) Color.Green else Color.Transparent
                        )
                    )
                }
            },
            measurePolicy = { measurables, constraints ->
                val placeables = measurables.map { it.measure(constraints) }
                val layoutWidth = constraints.maxWidth
                val layoutHeight = constraints.maxHeight
                val centerX = layoutWidth / 2
                val centerY = layoutHeight / 2
                var circleRadius = 75.dp.toPx()
                if (characters.size < 4) {
                    circleRadius = 60.dp.toPx()
                } else if (characters.size < 6) {
                    circleRadius = 65.dp.toPx()
                } else if (characters.size > 6) {
                    circleRadius = 85.dp.toPx()
                }
                val angleStep = 360.0 / characters.size

                layout(layoutWidth, layoutHeight) {
                    characters.forEachIndexed { index, letter ->
                        val angle = Math.toRadians(angleStep * index).toFloat()
                        val x = (centerX + circleRadius * cos(angle) - boxSize.toPx() / 2)
                        val y = (centerY + circleRadius * sin(angle) - boxSize.toPx() / 2)

                        // ✅ Uses Offset properly
                        boxPositions[letter] = Rect(
                            offset = Offset(x, y),
                            size = Size(boxSize.toPx(), boxSize.toPx())
                        )
                        placeables[index].place(x.toInt(), y.toInt())
                    }
                }
            }
        )
    }
}

