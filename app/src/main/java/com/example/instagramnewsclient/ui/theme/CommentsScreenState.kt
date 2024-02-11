package com.example.instagramnewsclient.ui.theme

import com.example.instagramnewsclient.domain.FeedPost
import com.example.instagramnewsclient.domain.PostComment

sealed class CommentsScreenState {

    data object Initial: CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ): CommentsScreenState()
}