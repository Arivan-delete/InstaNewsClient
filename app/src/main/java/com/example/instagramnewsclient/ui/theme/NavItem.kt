package com.example.instagramnewsclient.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.instagramnewsclient.R
import com.example.instagramnewsclient.navigation.Screen

sealed class NavItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: ImageVector
) {

    data object Home: NavItem(
        screen = Screen.NewsFeed,
        titleResId = R.string.navigation_item_main,
        icon = Icons.Outlined.Home
    )

    data object Favorite: NavItem(
        screen = Screen.Favorite,
        titleResId = R.string.navigation_item_favorite,
        icon = Icons.Outlined.Favorite
    )

    data object Profile: NavItem(
        screen = Screen.Profile,
        titleResId = R.string.navigation_item_profile,
        icon = Icons.Outlined.Person
    )
}