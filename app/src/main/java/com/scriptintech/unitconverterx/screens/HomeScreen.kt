package com.scriptintech.unitconverterx.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.scriptintech.unitconverterx.navigations.NavigationItem
import com.scriptintech.unitconverterx.navigations.Routes
import com.scriptintech.unitconverterx.viewmodels.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navHostController: NavHostController,
    paddingValues: PaddingValues
) {
    val navGridData by viewModel.navItems.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        GridList(navGridData) { route ->
            navHostController.navigate(route)
        }
    }
}

@Composable
private fun GridList(navGridData: List<NavigationItem>?, onItemClick: (String) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        navGridData?.forEach { navItem ->
            if (navItem.route != Routes.HOME_SCREEN.getRoute) {
                item {
                    NavigationCard(item = navItem) { route ->
                        onItemClick(route)
                    }
                }
            }
        }
    }
}

@Composable
private fun NavigationCard(item: NavigationItem, onItemClick: (String) -> Unit) {
    val shape: Shape = RoundedCornerShape(10.dp)

    Column(
        modifier = Modifier
            .padding(10.dp)
            .clickable { onItemClick(item.route) }
            .background(
                MaterialTheme.colorScheme.primaryContainer,
                shape
            ) // Background color for the card
            .fillMaxSize() // Make the card square
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .size(50.dp) // Adjust size as needed
                .align(Alignment.CenterHorizontally)
        ) {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = "Icon",
                modifier = Modifier.fillMaxWidth(),
                tint = Color.Black
            )
        }
        Text(
            text = item.title,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            color = Color.Black // Color for the title text
        )
    }
}