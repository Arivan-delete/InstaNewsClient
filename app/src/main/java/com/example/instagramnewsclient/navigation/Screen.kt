package com.example.instagramnewsclient.navigation

sealed class Screen(
    val route: String
) {
    data object NewsFeed: Screen(ROUTE_NEWS_FEED)
    data object Favorite: Screen(ROUTE_FAVORITE)
    data object Profile: Screen(ROUTE_PROFILE)

    private companion object {
        const val ROUTE_NEWS_FEED = "news_feed"
        const val ROUTE_FAVORITE = "favorite"
        const val ROUTE_PROFILE = "profile"
    }
}