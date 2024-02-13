package com.example.instagramnewsclient.presentation.news

import com.example.instagramnewsclient.domain.entity.FeedPost

sealed class NewsFeedScreenState {

    data object Initial: NewsFeedScreenState()
    data object Loading : NewsFeedScreenState()

    data class Posts(
        val posts: List<FeedPost>,
        val nextDataIsLoading: Boolean = false
    ) : NewsFeedScreenState()
}