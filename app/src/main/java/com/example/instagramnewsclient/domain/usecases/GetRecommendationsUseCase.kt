package com.example.instagramnewsclient.domain.usecases

import com.example.instagramnewsclient.domain.entity.FeedPost
import com.example.instagramnewsclient.domain.repository.NewsFeedRepository
import kotlinx.coroutines.flow.StateFlow

class GetRecommendationsUseCase(
    private val repository: NewsFeedRepository
) {

    operator fun invoke(): StateFlow<List<FeedPost>> {
        return repository.getRecommendations()
    }
}
