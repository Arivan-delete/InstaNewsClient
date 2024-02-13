package com.example.instagramnewsclient.presentation.comments

import com.example.instagramnewsclient.domain.FeedPost
import com.example.instagramnewsclient.domain.PostComment

sealed class CommentsScreenState {

    data object Initial: CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ): CommentsScreenState()
}