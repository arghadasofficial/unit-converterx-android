package com.scriptintech.unitconverterx

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.scriptintech.unitconverterx.navigations.SetupNavGraph
import com.scriptintech.unitconverterx.navigations.getNavigationItemsList

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
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute: String? = navBackStackEntry?.destination?.route
    val items = getNavigationItemsList()

    val topBarTitle = if (currentRoute != null) {
        items[items.indexOfFirst { it.route == currentRoute }].title
    } else {
        "SimpleXUnit Converter"
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = topBarTitle)
            })
        }
    ) {
        SetupNavGraph(
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