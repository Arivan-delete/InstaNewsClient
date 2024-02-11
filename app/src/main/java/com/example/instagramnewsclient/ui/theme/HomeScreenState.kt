package com.example.instagramnewsclient.ui.theme

import com.example.instagramnewsclient.domain.FeedPost
import com.example.instagramnewsclient.domain.PostComment

sealed class HomeScreenState {

    data object Initial: HomeScreenState()

    data class Posts(val posts: List<FeedPost>): HomeScreenState()
    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>): HomeScreenState()
}