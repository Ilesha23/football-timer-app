package com.ilesha23.football.ui.newGameScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.ilesha23.football.R
import com.ilesha23.football.ui.common.CustomButton

@Composable
fun NewGameScreen(
    viewModel: NewGameViewModel = hiltViewModel(),
    onMainMenuClick: () -> Unit = {},
    onStartClick: () -> Unit = {},
) {
    val selectedDate = viewModel.date.collectAsState().value

    NewGameScreenContent(
        selectedDate = selectedDate,
        onSelectDate = {
            viewModel.updateDate(it)
        },
        onSelectTime = {
            viewModel.updateTime(it)
        },
        onMainMenuClick = {
            onMainMenuClick()
        },
        onStartClick = {
            viewModel.start()
            onStartClick()
        },
        onOwnersUpdate = {
            viewModel.updateOwners(it)
        },
        onGuestsUpdate = {
            viewModel.updateGuests(it)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewGameScreenContent(
    selectedDate: Long = 0,
    onSelectDate: (Long) -> Unit = {},
    onSelectTime: (String) -> Unit = {},
    onMainMenuClick: () -> Unit = {},
    onStartClick: () -> Unit = {},
    onOwnersUpdate: (String) -> Unit = {},
    onGuestsUpdate: (String) -> Unit = {},
) {
    var showOwnersDialog by remember { mutableStateOf(false) }
    var showGuestsDialog by remember { mutableStateOf(false) }
    var showDateDialog by remember { mutableStateOf(false) }
    var showTimeDialog by remember { mutableStateOf(false) }
    val timePickerState = rememberTimePickerState()

    DialogWithTextField(
        showDialog = showOwnersDialog,
        onDismiss = {
            showOwnersDialog = false
        }
    ) {
        onOwnersUpdate(it)
    }

    DialogWithTextField(
        showDialog = showGuestsDialog,
        onDismiss = {
            showGuestsDialog = false
        }
    ) {
        onGuestsUpdate(it)
    }

    if (showDateDialog) {
        DatePickerDialog(
            currentDate = selectedDate,
            onSubmitDate = {
                onSelectDate(it)
            },
            onDismissRequest = {
                showDateDialog = false
            }
        )
    }

    if (showTimeDialog) {
        CustomTimePickerDialog(
            onDismissRequest = {
                showTimeDialog = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onSelectTime("${timePickerState.hour}:${timePickerState.minute}")
                        showTimeDialog = false
                    }
                ) { Text("OK") }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showTimeDialog = false
                    }
                ) { Text("Cancel") }
            }
        ) {
            TimePicker(
                state = timePickerState,
                colors = TimePickerDefaults.colors(
                    clockDialColor = MaterialTheme.colorScheme.background,
                    clockDialUnselectedContentColor = MaterialTheme.colorScheme.onBackground,
                    timeSelectorSelectedContainerColor = MaterialTheme.colorScheme.background,
                    timeSelectorSelectedContentColor = MaterialTheme.colorScheme.onBackground,
                    timeSelectorUnselectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    timeSelectorUnselectedContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        }
    }

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
                .padding(start = dimensionResource(id = R.dimen.new_game_screen_top_button_padding_start)),
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
                        .padding(horizontal = dimensionResource(id = R.dimen.new_game_screen_top_button_inner_padding_horizontal)),
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
                    showDateDialog = true
                }
            ) {
                Text(
                    text = stringResource(id = R.string.new_game_screen_date),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = dimensionResource(id = R.dimen.new_game_screen_button_padding)),
                    textDecoration = TextDecoration.Underline
                )
            }
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    showTimeDialog = true
                }
            ) {
                Text(
                    text = stringResource(id = R.string.new_game_screen_time),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = dimensionResource(id = R.dimen.new_game_screen_button_padding)),
                    textDecoration = TextDecoration.Underline
                )
            }
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    showOwnersDialog = !showOwnersDialog
                }
            ) {
                Text(
                    text = stringResource(id = R.string.new_game_screen_owners),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = dimensionResource(id = R.dimen.new_game_screen_button_padding)),
                    textDecoration = TextDecoration.Underline
                )
            }
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    showGuestsDialog = !showGuestsDialog
                }
            ) {
                Text(
                    text = stringResource(id = R.string.new_game_screen_guests),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = dimensionResource(id = R.dimen.new_game_screen_button_padding)),
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
                    onStartClick()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.new_game_screen_start),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = dimensionResource(id = R.dimen.new_game_screen_button_padding))
                )
            }
        }
    }
}

@Composable
fun DialogWithTextField(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    if (showDialog) {
        var text by remember { mutableStateOf(TextFieldValue()) }

        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = "Enter Text") },
            text = {
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier.fillMaxWidth()
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        onConfirm(text.text)
                        onDismiss()
                    }
                ) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                Button(
                    onClick = onDismiss
                ) {
                    Text(text = "Dismiss")
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialog(
    currentDate: Long,
    onDismissRequest: () -> Unit,
    onSubmitDate: (Long) -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
            val datePickerState =
                rememberDatePickerState(initialSelectedDateMillis = currentDate)
            DatePicker(
                state = datePickerState,
                colors = DatePickerDefaults.colors(
                    titleContentColor = MaterialTheme.colorScheme.onBackground,
                    headlineContentColor = MaterialTheme.colorScheme.onBackground,
                    weekdayContentColor = MaterialTheme.colorScheme.onBackground,
                    dayContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
            Row {
                TextButton(
                    onClick = {
                        onDismissRequest()
                        onSubmitDate(datePickerState.selectedDateMillis ?: 0)
                    }
                ) {
                    Text(
                        text = "Ok",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                TextButton(
                    onClick = onDismissRequest
                ) {
                    Text(
                        text = "Cancel",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}

@Composable
fun CustomTimePickerDialog(
    title: String = "Select Time",
    onDismissRequest: () -> Unit,
    confirmButton: @Composable (() -> Unit),
    dismissButton: @Composable (() -> Unit)? = null,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = 6.dp,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .background(
                    shape = MaterialTheme.shapes.extraLarge,
                    color = containerColor
                ),
            color = containerColor
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    text = title,
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.labelMedium
                )
                content()
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    dismissButton?.invoke()
                    confirmButton()
                }
            }
        }
    }
}