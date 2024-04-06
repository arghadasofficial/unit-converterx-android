package com.scriptintech.unitconverterx.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.scriptintech.unitconverterx.navigations.NavigationItem
import com.scriptintech.unitconverterx.navigations.getNavigationItemsList

class HomeViewModel : ViewModel() {

    private val _navItems = MutableLiveData<List<NavigationItem>>()
    val navItems : LiveData<List<NavigationItem>> = _navItems

    init {
        _navItems.value = getNavigationItemsList()
    }

}