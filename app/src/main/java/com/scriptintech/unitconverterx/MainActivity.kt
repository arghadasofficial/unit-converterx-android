package com.scriptintech.unitconverterx

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.scriptintech.unitconverterx.screens.BmiScreen
import com.scriptintech.unitconverterx.ui.theme.UnitConverterXTheme
import com.scriptintech.unitconverterx.viewmodels.BmiViewModel
import kotlinx.coroutines.flow.emptyFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val bmiViewModel: BmiViewModel = viewModel()
            val context : Context = LocalContext.current
            UnitConverterXTheme {
                App(context, bmiViewModel)
            }
        }
    }
}

@Composable
fun App(context: Context, bmiViewModel: BmiViewModel) {
    BmiScreen(context, bmiViewModel)
}

@Preview (showSystemUi = true)
@Composable
fun AppPreview() {
    App(LocalContext.current, BmiViewModel())
}