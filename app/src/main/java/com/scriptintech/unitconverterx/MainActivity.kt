package com.scriptintech.unitconverterx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.scriptintech.unitconverterx.navigations.UnitNavigation
import com.scriptintech.unitconverterx.screens.MainScreen
import com.scriptintech.unitconverterx.ui.theme.UnitConverterXTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App {
                MainScreen()
                //UnitNavigation()
            }
        }
    }
}

@Composable
fun App(content: @Composable () -> Unit) {
    UnitConverterXTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}