package com.example.instagramnewsclient.presentation.comments

import com.example.instagramnewsclient.domain.entity.FeedPost
import com.example.instagramnewsclient.domain.entity.PostComment

sealed class CommentsScreenState {

    data object Initial: CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ): CommentsScreenState()
}