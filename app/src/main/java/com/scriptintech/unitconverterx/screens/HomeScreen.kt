package com.scriptintech.unitconverterx.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.scriptintech.unitconverterx.components.UVerticalGrid
import com.scriptintech.unitconverterx.navigations.ConverterNavItems
import com.scriptintech.unitconverterx.navigations.getBottomNavItemsList
import com.scriptintech.unitconverterx.navigations.getNavigationItemsList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Home") }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary, titleContentColor = Color.Black
            )
        )
    }) {
        MainContent(paddingValues = it, navController = navController)
    }
}

@Composable
private fun MainContent(
    paddingValues: PaddingValues,
    convertersList: List<ConverterNavItems> = getNavigationItemsList(),
    navController: NavController
) {
    Column(modifier = Modifier.padding(paddingValues)) {
        UVerticalGrid(convertersList = convertersList, onItemClick = {
            navController.navigate(it)
        })
    }
}

@Preview
@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                getBottomNavItemsList().forEachIndexed { index, bottomNavItems ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = {
                            Icon(imageVector = bottomNavItems.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = bottomNavItems.label)
                        })
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {
    when(selectedIndex) {
        0-> FavouriteScreen()
        1-> CategoriesScreen()
        2-> ToolsScreen()
        3-> HistoryScreen()
        4-> FavouriteScreen()
    }
}
