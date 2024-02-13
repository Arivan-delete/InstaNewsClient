package com.example.instagramnewsclient.domain.usecases

import com.example.instagramnewsclient.domain.entity.FeedPost
import com.example.instagramnewsclient.domain.repository.NewsFeedRepository

class ChangeLikeStatusUseCase(
    private val repository: NewsFeedRepository
) {

    suspend operator fun invoke(feedPost: FeedPost) {
        repository.changeLikeStatus(feedPost)
    }
}
