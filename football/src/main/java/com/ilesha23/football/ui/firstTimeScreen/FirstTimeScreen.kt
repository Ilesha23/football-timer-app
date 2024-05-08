package com.ilesha23.football.ui.firstTimeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.ilesha23.football.R
import com.ilesha23.football.ui.common.CustomButton
import com.ilesha23.football.ui.common.Timer

@Composable
fun FirstTimeScreen(
    viewModel: FirstTimeViewModel = hiltViewModel(),
    onBreakClick: () -> Unit = {}
) {
    val elapsedTime by viewModel.elapsedTime.collectAsState()
    val ownersScore by viewModel.ownersScore.collectAsState()
    val guestsScore by viewModel.guestsScore.collectAsState()

    FirstTimeScreenContent(
        ownersScore = ownersScore,
        guestsScore = guestsScore,
        elapsedTime = elapsedTime,
        onBreakClick = {
            viewModel.stop()
            onBreakClick()
        },
        onOwnersPlusClick = {
            viewModel.addOwners()
        },
        onOwnersMinusClick = {
            viewModel.subtractOwners()
        },
        onGuestsPlusClick = {
            viewModel.addGuests()
        },
        onGuestsMinusClick = {
            viewModel.subtractGuests()
        },
    )
}

@Composable
fun FirstTimeScreenContent(
    ownersScore: Int = 0,
    guestsScore: Int = 0,
    elapsedTime: String,
    onBreakClick: () -> Unit = {},
    onOwnersPlusClick: () -> Unit = {},
    onOwnersMinusClick: () -> Unit = {},
    onGuestsPlusClick: () -> Unit = {},
    onGuestsMinusClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(1.65f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = stringResource(id = R.string.time_screen_first),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displayLarge
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.05f))
            Timer(
                ownersScore = ownersScore,
                guestsScore = guestsScore,
                currentTime = elapsedTime,
                modifier = Modifier
                    .fillMaxHeight(0.8f)
            )
        }
        Spacer(modifier = Modifier.fillMaxSize(0.03f))
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    onOwnersPlusClick()
                },
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.first_time_screen_plus_button_height))
                    .width(dimensionResource(id = R.dimen.first_time_screen_plus_button_width))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            IconButton(
                onClick = {
                    onGuestsPlusClick()
                },
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.first_time_screen_plus_button_height))
                    .width(dimensionResource(id = R.dimen.first_time_screen_plus_button_width))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    onOwnersMinusClick()
                },
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.first_time_screen_plus_button_height))
                    .width(dimensionResource(id = R.dimen.first_time_screen_plus_button_width))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            IconButton(
                onClick = {
                    onGuestsMinusClick()
                },
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.first_time_screen_plus_button_height))
                    .width(dimensionResource(id = R.dimen.first_time_screen_plus_button_width))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    onBreakClick()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.time_screen_break),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .padding(vertical = dimensionResource(id = R.dimen.first_time_screen_button_padding))
                )
            }
        }
    }
}