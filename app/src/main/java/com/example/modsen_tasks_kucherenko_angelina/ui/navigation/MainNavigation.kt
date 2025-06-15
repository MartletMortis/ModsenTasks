package com.example.modsen_tasks_kucherenko_angelina.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.modsen_tasks_kucherenko_angelina.ui.screen.StartScreen
import com.example.modsen_tasks_kucherenko_angelina.ui.screen.Task1EmptyScreen
import com.example.modsen_tasks_kucherenko_angelina.ui.screen.Task1LoginScreen
import kotlinx.serialization.Serializable

sealed class Screen {                        //хранит в себе названия путей как дата-объекты
    @Serializable                           //нужен для преобразования дата-объектов
    data object Start: Screen()             //наследует Screen

    @Serializable
    data object Task1Login: Screen()

    @Serializable
    data object Task1Empty: Screen()
}

@Composable
fun MainNav(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screen.Start     //изначально принимает в себя только строки, но с новой версии можно и объекты
    ) {
        composable<Screen.Start> {
            StartScreen { navigateTo ->
                navHostController.navigate(navigateTo)

            }
        }

        composable<Screen.Task1Login> {
            Task1LoginScreen(
                onNavigateTo = {navigateTo ->
                    navHostController.navigate(navigateTo)
               }

            )
        }

        composable<Screen.Task1Empty> {
            Task1EmptyScreen(
                onNavigateTo = {navigateTo ->
                    navHostController.navigate(navigateTo)
                }
            )
        }
    }
}