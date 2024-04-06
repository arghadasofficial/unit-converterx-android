package com.scriptintech.unitconverterx.screens

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.scriptintech.unitconverterx.navigations.NavigationItem
import com.scriptintech.unitconverterx.viewmodels.HomeViewModel

@Composable
fun HomeScreen(
    context: Context,
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
        items(navGridData?.size ?: 0) {
            navGridData?.get(it)?.let { it1 ->
                NavigationCard(item = it1) { route ->
                    onItemClick(route)
                }
            }
        }
    }
}

@Composable
private fun NavigationCard(item: NavigationItem, onItemClick: (String) -> Unit) {
    Card(modifier = Modifier
        .padding(8.dp)
        .clickable {
            onItemClick(item.route)
        }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(imageVector = item.icon, contentDescription = item.title)
            Text(text = item.title, textAlign = TextAlign.Center)
        }
    }
}