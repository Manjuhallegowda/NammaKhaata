package com.nammakhaata.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.rememberNavController
import com.nammakhaata.app.ui.navigation.NavGraph
import com.nammakhaata.app.ui.theme.NammaKhaataTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NammaKhaataTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
