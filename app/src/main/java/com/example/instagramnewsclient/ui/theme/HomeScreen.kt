package com.example.instagramnewsclient.ui.theme

import androidx.activity.compose.BackHandler
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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instagramnewsclient.NewsFeedViewModel
import com.example.instagramnewsclient.domain.FeedPost

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    onCommentClickListener:(FeedPost) -> Unit
) {

    val viewModel: NewsFeedViewModel = viewModel()

    val screenState = viewModel.screenState.observeAsState(NewsFeedScreenState.Initial)

    when (val currentState = screenState.value) {
        is NewsFeedScreenState.Posts -> {
            FeedPosts(
                posts = currentState.posts,
                viewModel = viewModel,
                paddingValues = paddingValues,
                onCommentClickListener = onCommentClickListener
            )
        }
        NewsFeedScreenState.Initial -> {}
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun FeedPosts(
    posts: List<FeedPost>,
    viewModel: NewsFeedViewModel,
    paddingValues: PaddingValues,
    onCommentClickListener:(FeedPost) -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(paddingValues)
    ) {
        items(
            items = posts,
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
                        onCommentClickListener = {
                            onCommentClickListener(feedPost)
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