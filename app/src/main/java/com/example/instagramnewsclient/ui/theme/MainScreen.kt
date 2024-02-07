package com.example.instagramnewsclient.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.instagramnewsclient.MainViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                val selectedItemPosition = remember {
                    mutableStateOf(0)
                }
                val items = listOf(
                    NavItem.Home,
                    NavItem.Favorite,
                    NavItem.Profile
                )
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemPosition.value == index,
                        onClick = { selectedItemPosition.value = index },
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondary
                        )
                    )
                }
            }
        }
    ) {
        val feedPosts = viewModel.feedPosts.observeAsState(listOf())
        LazyColumn(
            modifier = Modifier.padding(it)
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
}