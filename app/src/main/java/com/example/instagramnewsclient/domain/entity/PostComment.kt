package com.example.instagramnewsclient.domain.entity

import com.example.instagramnewsclient.R

data class PostComment(
    val id: Long,
    val authorName: String,
    val authorAvatarUrl: String,
    val commentText: String,
    val publicationDate: String
)
