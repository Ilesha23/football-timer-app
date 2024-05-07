package com.ilesha23.football.ui.newGameScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun NewGameScreen() {
    NewGameScreenContent()
}

@Composable
fun NewGameScreenContent() {
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
        Column(
            modifier = Modifier
                .weight(0.9f)
                .fillMaxWidth(0.8f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {

                }
            ) {
                Text(
                    text = stringResource(id = R.string.new_game_screen_date),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    textDecoration = TextDecoration.Underline
                )
            }
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {

                }
            ) {
                Text(
                    text = stringResource(id = R.string.new_game_screen_time),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    textDecoration = TextDecoration.Underline
                )
            }
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {

                }
            ) {
                Text(
                    text = stringResource(id = R.string.new_game_screen_owners),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    textDecoration = TextDecoration.Underline
                )
            }
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {

                }
            ) {
                Text(
                    text = stringResource(id = R.string.new_game_screen_guests),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    textDecoration = TextDecoration.Underline
                )
            }
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = listOf(
                    Color(0xFF5CE2FF),
                    Color(0xFF258FDC),
                    Color(0xFF50D8F5),
                    Color(0xFF50D8F5),
                    Color(0xFF258FDC),
                    Color(0xFF5CE2FF),
                    Color(0x20FFFFFF),
                    Color(0xFF3B38EE),
                ),
                onClick = {

                }
            ) {
                Text(
                    text = stringResource(id = R.string.new_game_screen_start),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                )
            }
        }
    }
}