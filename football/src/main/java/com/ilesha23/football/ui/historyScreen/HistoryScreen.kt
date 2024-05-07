package com.ilesha23.football.ui.historyScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.ilesha23.football.R
import com.ilesha23.football.ui.common.CustomButton

@Composable
fun HistoryScreen(
    onBackClick: () -> Unit = {},
    onMainMenuClick: () -> Unit = {},
) {
    HistoryScreenContent(
        onBackClick = {
            onBackClick()
        },
        onMainMenuClick = {
            onMainMenuClick()
        }
    )
}

@Composable
fun HistoryScreenContent(
    onBackClick: () -> Unit = {},
    onMainMenuClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(0.1f)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(start = 10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            CustomButton(
                onClick = {
                    onMainMenuClick()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.new_game_screen_main_menu),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.9f)
                .weight(0.8f)
        ) {
            item {
                Spacer(modifier = Modifier.height(30.dp))
            }
            items(List(10) { it }) {
                MatchItem()
                Spacer(modifier = Modifier.height(30.dp))
            }
        }

        Column(
            modifier = Modifier
                .weight(0.2f)
                .fillMaxWidth(0.8f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    onBackClick()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.history_screen_back),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

@Composable
fun MatchItem(
    owners: String = "owners",
    guests: String = "guests",
    score: String = "2:0",
    date: String = "12.02.2024",
    time: String = "10:30"
) {
    CustomButton {
        Column(
            modifier = Modifier
                .height(100.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = owners,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelSmall,
                )
                Text(
                    text = score,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelSmall,
                )
                Text(
                    text = guests,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = date,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = time,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        }
    }
}