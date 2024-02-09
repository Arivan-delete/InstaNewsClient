package com.example.instagramnewsclient.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.instagramnewsclient.MainViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    paddingValues: PaddingValues
) {
    val feedPosts = viewModel.feedPosts.observeAsState(listOf())
    LazyColumn(
        modifier = Modifier.padding(paddingValues)
    ) {
        items(
            items = feedPosts.value,
            key = { it.id }
        ) { feedPost ->
            val dismissedState = rememberDismissState()
            if (dismissedState.isDismissed(DismissDirection.EndToStart)) {
                viewModel.remove(feedPost)
            }

            SwipeToDismiss(
                modifier = Modifier.animateItemPlacement(),
                state = dismissedState,
                directions = setOf(DismissDirection.EndToStart),
                background = {},
                dismissContent = {
                    PostCard(
                        modifier = Modifier.padding(8.dp),
                        feedPost = feedPost,
                        onCommentClickListener = { statisticItem ->
                            viewModel.updateAmount(feedPost, statisticItem)
                        },
                        onLikeClickListener = { statisticItem ->
                            viewModel.updateAmount(feedPost, statisticItem)
                        },
                        onShareClickListener = { statisticItem ->
                            viewModel.updateAmount(feedPost, statisticItem)
                        },
                        onViewsClickListener = { statisticItem ->
                            viewModel.updateAmount(feedPost, statisticItem)
                        }
                    )
                }
            )
        }
    }
}