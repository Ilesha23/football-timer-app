package com.ilesha23.football.ui.loginScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.ilesha23.football.R
import com.ilesha23.football.ui.common.CustomButton
import com.ilesha23.football.ui.common.Timer
import com.ilesha23.football.ui.theme.MiniprojectsTheme

@Composable
fun LoginScreen(

) {
    LoginScreenContent()
}

@Composable
fun LoginScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            TextWithTimer()
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            ButtonsWithText()
        }
    }
}

@Composable
fun TextWithTimer() {
    Text(
        text = stringResource(id = R.string.login_screen_kickoff_timer).uppercase(),
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onBackground
    )
    Timer(
        modifier = Modifier
            .fillMaxHeight(0.5f)
    )
}

@Composable
fun ButtonsWithText() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.8f),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.2f))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.9f)
        ) {
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {

                }
            ) {
                Text(
                    text = stringResource(id = R.string.login_screen_history),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                )
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.15f))
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {

                }
            ) {
                Text(
                    text = stringResource(id = R.string.login_screen_new_game),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(0.2f)
        ) {
            Text(
                text = stringResource(id = R.string.login_screen_terms),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .clickable {

                    }
            )
        }
    }
}

@Composable
@PreviewScreenSizes
fun LoginPreview() {
    MiniprojectsTheme {
        LoginScreenContent()
    }
}