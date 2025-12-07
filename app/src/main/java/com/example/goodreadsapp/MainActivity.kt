package com.example.goodreadsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.goodreadsapp.ui.theme.GoodreadsAppTheme
import com.example.goodreadsapp.ui.navigation.GoodreadsApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoodreadsAppTheme {
                GoodreadsApp()
            }
        }
    }
}