package com.example.instagramnewsclient.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.instagramnewsclient.domain.entity.FeedPost
import com.google.gson.Gson

fun NavGraphBuilder.homeScreenNavGraph(
    commentsScreenContent: @Composable (FeedPost) -> Unit,
    newsFeedScreenContent: @Composable () -> Unit
) {
    navigation(
        startDestination = Screen.NewsFeed.route,
        route = Screen.Home.route
    ) {
        composable(Screen.NewsFeed.route) {
            newsFeedScreenContent()
        }
        composable(
            route = Screen.Comments.route,
            arguments = listOf(
                navArgument(Screen.KEY_FEED_POST) {
                    type = NavType.StringType
                }
            )
        ) {
            val feedPostJson = it.arguments?.getString(Screen.KEY_FEED_POST) ?: ""
            val feedPost = Gson().fromJson (feedPostJson, FeedPost::class.java)
            commentsScreenContent(feedPost)
        }
    }
}