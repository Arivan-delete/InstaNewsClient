package com.example.instagramnewsclient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagramnewsclient.domain.FeedPost
import com.example.instagramnewsclient.domain.StatisticItem
import java.util.Collections.replaceAll

class MainViewModel: ViewModel() {

    private val sourceList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it))
        }
    }
    private val _feedPosts = MutableLiveData<List<FeedPost>>(sourceList)
    val feedPosts: LiveData<List<FeedPost>> = _feedPosts

    fun updateAmount(feedPost: FeedPost, item: StatisticItem) {
        val oldPosts = feedPosts.value?.toMutableList() ?: mutableListOf()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(amount = oldItem.amount + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)
        _feedPosts.value = oldPosts.apply {
            replaceAll {
                if (it.id == feedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
    }

    fun remove(feedPost: FeedPost) {
        val oldPosts = feedPosts.value?.toMutableList() ?: mutableListOf()
        _feedPosts.value = oldPosts.apply {
            remove(feedPost)
        }
    }
}