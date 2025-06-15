package com.example.modsen_tasks_kucherenko_angelina.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.modsen_tasks_kucherenko_angelina.ui.navigation.Screen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.modsen_tasks_kucherenko_angelina.domain.LoginScreenViewModel
import com.example.modsen_tasks_kucherenko_angelina.domain.UIEvent
import org.koin.androidx.compose.koinViewModel

@Composable
fun Task1LoginScreen(
    onNavigateTo: (Screen) -> Unit = {},
    viewModel: LoginScreenViewModel = koinViewModel() //внедряем вьюмодель из коина

) {
    val uiEvent by viewModel.uiEvent.collectAsState(initial = null)
    val context = LocalContext.current

    LaunchedEffect(uiEvent) { //подписываемся на изменения
        when (uiEvent) {
            is UIEvent.NavigateToTask1EmptyScreen ->
                onNavigateTo(Screen.Task1Empty)
            is UIEvent.ShowError ->
                Toast.makeText(context, "Invalid user data", Toast.LENGTH_SHORT).show()
            else -> {}
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Page",
            fontSize = 35.sp,
            modifier = Modifier.padding(top = 150.dp)
        )

        OutlinedTextField(
            value = viewModel.log,
            onValueChange = viewModel::updateLogin,
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Default.AccountCircle),
                    contentDescription = null
                )
            },
            modifier = Modifier.padding(top = 100.dp),
            placeholder = {
                Text(text = "Login")
            }
        )

        OutlinedTextField(
            value = viewModel.pswd,
            onValueChange = viewModel::updatePassword,
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Default.Lock),
                    contentDescription = null
                )
            },
            modifier = Modifier.padding(top = 25.dp),
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Text(text = "Password")
            }
        )

        Button(
            onClick = {
                viewModel.onButtonClick()
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(top = 25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            enabled = viewModel.log.isNotBlank() && viewModel.pswd.isNotBlank()
        ) {
            Box(
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 5.dp)
            ) {
                Text(text = "Log In")
            }

        }

    }

}

@Composable
@Preview(showBackground = true)
fun Task1LoginScreenPreview(){
    Task1LoginScreen()
}