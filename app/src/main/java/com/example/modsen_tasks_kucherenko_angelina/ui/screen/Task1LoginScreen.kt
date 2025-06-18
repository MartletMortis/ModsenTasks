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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.modsen_tasks_kucherenko_angelina.R
import com.example.modsen_tasks_kucherenko_angelina.domain.LoginEvent
import com.example.modsen_tasks_kucherenko_angelina.domain.LoginIntent
import com.example.modsen_tasks_kucherenko_angelina.ui.navigation.Screen
import com.example.modsen_tasks_kucherenko_angelina.ui.LoginScreenViewModel
import kotlinx.coroutines.flow.filterIsInstance
import org.koin.androidx.compose.koinViewModel

@Composable
fun Task1LoginScreen(
    onNavigateTo: (Screen) -> Unit = {},
    viewModel: LoginScreenViewModel = koinViewModel() //внедряем вьюмодель из коина

) {
    val state by viewModel.uiState.collectAsState()
    val context= LocalContext.current

    LaunchedEffect(Unit) { //подписываемся на изменения об ошибке и вывода тост
        viewModel.event
            .filterIsInstance<LoginEvent.ShowError>()
            .collect{
                Toast.makeText(context, it.error, Toast.LENGTH_SHORT).show()
            }
    }

    LaunchedEffect(Unit) { //подписываемся на изменеия об удачном логине и переходе на пустой экран
        viewModel.event
            .filterIsInstance<LoginEvent.NavigateToScreen>()
            .collect{
                onNavigateTo(Screen.Task1Empty)
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
            value = state.login,
            onValueChange = {viewModel.onIntent(LoginIntent.UpdateLogin(it))},
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
            value = state.password,
            onValueChange = {viewModel.onIntent(LoginIntent.UpdatePassword(it))},
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
                viewModel.onIntent(LoginIntent.Submit)
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(top = 25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            enabled = state.isButtonEnabled //теперь кликабельность кнопки тоже обрабатывается стейтом, а не юаем
        ) {
            Box(
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 5.dp)
            ) {
                Text(text = if(state.isLoading) {
                    stringResource(id = R.string.button_logging_in)
                } else {
                    stringResource(id = R.string.button_log_in)
                })
            }

        }

    }

}

@Composable
@Preview(showBackground = true)
fun Task1LoginScreenPreview(){
    Task1LoginScreen()
}