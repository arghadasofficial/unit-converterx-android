package com.scriptintech.unitconverterx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.scriptintech.unitconverterx.navigations.UnitNavigation
import com.scriptintech.unitconverterx.ui.theme.UnitConverterXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App {
                UnitNavigation()
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

@Preview
@Composable
private fun DefaultPreview() {
    App {
        UnitNavigation()
    }
}