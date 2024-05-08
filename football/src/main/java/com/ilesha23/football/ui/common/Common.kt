package com.ilesha23.football.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ilesha23.football.R

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    colors: List<Color> = listOf(
        Color(0xFFF9AC67),
        Color(0xFFCA762D),
        Color(0xFFF59D50),
        Color(0xFFF59D50),
        Color(0xFFDC7D25),
        Color(0xFFFFAB5C),
        Color(0x20FFFFFF),
        Color(0xFFEE8C38)
    ),
    onClick: () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    Background(
        modifier = modifier,
        colors = colors,
        onClick = {
            onClick()
        }
    ) {
        content()
    }
}

@Composable
fun Timer(
    currentTime: String = "00:00",
    modifier: Modifier = Modifier
) {
    Background(
        modifier = modifier
            .fillMaxWidth(0.9f),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .weight(0.3f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(25))
                        .background(color = Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.login_screen_home).uppercase(),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .padding(horizontal = 14.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.85f)
                        .clip(RoundedCornerShape(10))
                        .background(color = Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "00",
                        style = MaterialTheme.typography.displayLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .weight(0.02f)
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.3f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.login_screen_time).uppercase(),
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10))
                        .background(color = Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = currentTime,
                        style = MaterialTheme.typography.displayMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .weight(0.02f)
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .weight(0.3f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(25))
                        .background(color = Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.login_screen_home).uppercase(),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .padding(horizontal = 14.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.85f)
                        .clip(RoundedCornerShape(10))
                        .background(color = Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "00",
                        style = MaterialTheme.typography.displayLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}

@Composable
fun Background(
    modifier: Modifier = Modifier,
    colors: List<Color> = listOf(
        Color(0xFFF9AC67),
        Color(0xFFCA762D),
        Color(0xFFF59D50),
        Color(0xFFF59D50),
        Color(0xFFDC7D25),
        Color(0xFFFFAB5C),
        Color(0x20FFFFFF),
        Color(0xFFEE8C38)
    ),
    onClick: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .clickable {
                onClick()
            }
            .drawBehind {
                val innerRadius = 30f
                val outerRadius = 40f
                val shadowWidth = 2f
                val borderWidth = 15f

                // outer shadow
                drawRoundRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colors[0],
                            colors[1]
                        ),
                        startY = 0f,
                        endY = size.height
                    ),
                    cornerRadius = CornerRadius(outerRadius),
                    size = Size(
                        size.width + (shadowWidth + 2 * borderWidth),
                        size.height + (2 * borderWidth + 5 * shadowWidth/*shadowWidth * 4 + shadowWidth * borderWidth + 2 * shadowWidth*/)
                    ),
                    topLeft = Offset(-borderWidth, -borderWidth - 2 * shadowWidth),
                )

                //outer border
                drawRoundRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colors[2],
                            colors[3]
                        ),
                        startY = 0f,
                        endY = size.height
                    ),
                    cornerRadius = CornerRadius(outerRadius),
                    size = Size(
                        size.width + (shadowWidth + 2 * borderWidth),
                        size.height + (shadowWidth + 2 * borderWidth)
                    ),
                    topLeft = Offset(-borderWidth, -borderWidth),
                )

                //inner shadow
                drawRoundRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colors[4],
                            colors[5]
                        ),
                        startY = 0f,
                        endY = size.height
                    ),
                    cornerRadius = CornerRadius(innerRadius),
                    size = Size(size.width + 2 * shadowWidth, size.height + 2 * shadowWidth),
                    topLeft = Offset(-shadowWidth, -shadowWidth),
                )

                //inner background
                drawRoundRect(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            colors[6],
                            colors[7],
                        ),
                        center = Offset(size.width / 2, size.height * 2),
                        radius = size.width
                    ),
                    cornerRadius = CornerRadius(innerRadius)
                )
            },
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}