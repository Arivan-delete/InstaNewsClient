package com.example.instagramnewsclient.presentation.news

import com.example.instagramnewsclient.domain.FeedPost

sealed class NewsFeedScreenState {

    data object Initial: NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>): NewsFeedScreenState()
}