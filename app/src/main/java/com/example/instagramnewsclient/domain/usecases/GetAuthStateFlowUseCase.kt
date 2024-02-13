package com.example.instagramnewsclient.domain.usecases

import com.example.instagramnewsclient.domain.entity.AuthState
import com.example.instagramnewsclient.domain.repository.NewsFeedRepository
import kotlinx.coroutines.flow.StateFlow

class GetAuthStateFlowUseCase(
    private val repository: NewsFeedRepository
) {

    operator fun invoke(): StateFlow<AuthState> {
        return repository.getAuthStateFlow()
    }
}
