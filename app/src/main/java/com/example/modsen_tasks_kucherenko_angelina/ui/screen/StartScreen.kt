package com.example.modsen_tasks_kucherenko_angelina.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.modsen_tasks_kucherenko_angelina.ui.components.StyledButton
import com.example.modsen_tasks_kucherenko_angelina.ui.navigation.Screen

@Composable
fun StartScreen(
    onNavigateTo: (Screen) -> Unit ={}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tasks",
            fontSize = 25.sp,
            modifier = Modifier.padding(top = 25.dp, bottom = 25.dp)
        )

        StyledButton(onClick = {onNavigateTo(Screen.Task1Login)}) {
            Text(text = "Task 1")
        }
    }

}


@Composable
@Preview(showBackground = true)
fun StartScreenPreview() {
    StartScreen()
}