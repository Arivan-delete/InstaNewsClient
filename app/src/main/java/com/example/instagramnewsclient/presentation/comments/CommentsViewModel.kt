package com.example.instagramnewsclient.presentation.comments

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.instagramnewsclient.data.repository.NewsFeedRepositoryImpl
import com.example.instagramnewsclient.domain.entity.FeedPost
import com.example.instagramnewsclient.domain.usecases.GetCommentsUseCase
import kotlinx.coroutines.flow.map

class CommentsViewModel(
    feedPost: FeedPost,
    application: Application
): ViewModel() {

    private val repository = NewsFeedRepositoryImpl(application)
    private val getCommentsUseCase = GetCommentsUseCase(repository)
    val screenState = repository.getComments(feedPost)
        .map {
            CommentsScreenState.Comments(
                feedPost = feedPost,
                comments = it
            )
        }
}