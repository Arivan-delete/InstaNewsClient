package com.example.instagramnewsclient.domain.usecases

import com.example.instagramnewsclient.domain.entity.FeedPost
import com.example.instagramnewsclient.domain.entity.PostComment
import com.example.instagramnewsclient.domain.repository.NewsFeedRepository
import kotlinx.coroutines.flow.StateFlow

class GetCommentsUseCase(
    private val repository: NewsFeedRepository
) {

    operator fun invoke(feedPost: FeedPost): StateFlow<List<PostComment>> {
        return repository.getComments(feedPost)
    }
}
