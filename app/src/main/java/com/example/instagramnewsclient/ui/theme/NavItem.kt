package com.example.instagramnewsclient.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.instagramnewsclient.R

sealed class NavItem(
    val titleResId: Int,
    val icon: ImageVector
) {

    data object Home: NavItem(
        titleResId = R.string.navigation_item_main,
        icon = Icons.Outlined.Home
    )

    data object Favorite: NavItem(
        titleResId = R.string.navigation_item_favorite,
        icon = Icons.Outlined.Favorite
    )

    data object Profile: NavItem(
        titleResId = R.string.navigation_item_profile,
        icon = Icons.Outlined.Person
    )
}