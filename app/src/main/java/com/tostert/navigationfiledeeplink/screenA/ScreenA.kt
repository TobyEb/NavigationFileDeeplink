package com.tostert.navigationfiledeeplink.screenA

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ScreenA(
    navigateToB: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar {
                Text("ScreenA")
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center,
        ) {
            Text("ScreenA")
            Button(onClick = navigateToB) {
                Text("navigateToB")
            }
        }
    }
}
