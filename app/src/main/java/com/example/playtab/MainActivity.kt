package com.example.playtab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.playtab.ui.screens.HomeScreen
import com.example.playtab.ui.screens.PlayTabApp
import com.example.playtab.ui.theme.PlaytabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaytabTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PlayTabApp()
                }
            }
        }
    }
}