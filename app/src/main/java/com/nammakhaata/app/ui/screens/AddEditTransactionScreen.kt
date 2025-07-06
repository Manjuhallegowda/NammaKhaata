package com.nammakhaata.app.ui.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditTransactionScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Add/Edit Transaction") }) }
    ) { padding ->
        Text(
            text = "Add/Edit Transaction screen content goes here.",
            modifier = Modifier.padding(padding)
        )
    }
}
