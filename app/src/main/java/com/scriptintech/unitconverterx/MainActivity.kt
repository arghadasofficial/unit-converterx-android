package com.scriptintech.unitconverterx

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.scriptintech.unitconverterx.navigations.setupNavGraph
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val context: Context = LocalContext.current
    val navController = rememberNavController()
    Scaffold (
        topBar = { TopAppBar(title = {
            Text(text = "Unit Converter X")
        })}
    ) {
        setupNavGraph(
            navHostController = navController,
            paddingValues = it,
            context = context
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    App()
}