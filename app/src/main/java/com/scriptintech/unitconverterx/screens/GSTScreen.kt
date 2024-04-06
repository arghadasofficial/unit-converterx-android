package com.scriptintech.unitconverterx.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.scriptintech.unitconverterx.navigations.Routes
import com.scriptintech.unitconverterx.viewmodels.GstViewModel
import com.scriptintech.unitconverterx.viewmodels.HomeViewModel

@Composable
fun GstScreen(viewModel: GstViewModel, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxSize().padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "GST Screen")
    }
}