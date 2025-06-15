package com.example.modsen_tasks_kucherenko_angelina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.modsen_tasks_kucherenko_angelina.ui.navigation.MainNav
import com.example.modsen_tasks_kucherenko_angelina.ui.theme.ModsenTasksKucherenko_AngelinaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModsenTasksKucherenko_AngelinaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainContent(
    modifier: Modifier = Modifier
){
    MainNav(navHostController = rememberNavController(), modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ModsenTasksKucherenko_AngelinaTheme {
        MainContent()
    }
}