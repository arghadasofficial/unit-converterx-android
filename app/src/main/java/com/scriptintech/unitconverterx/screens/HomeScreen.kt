package com.scriptintech.unitconverterx.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.scriptintech.unitconverterx.components.UVerticalGrid
import com.scriptintech.unitconverterx.navigations.ConverterNavItems
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

