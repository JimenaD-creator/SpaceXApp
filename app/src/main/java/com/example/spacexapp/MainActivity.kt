package com.example.spacexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import dagger.hilt.android.AndroidEntryPoint
import com.example.spacexapp.ui.theme.SpaceXAppTheme
import com.example.spacexapp.ui.SpaceXNavGraph
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpaceXAppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    SpaceXNavGraph()
                }
            }
        }
    }
}