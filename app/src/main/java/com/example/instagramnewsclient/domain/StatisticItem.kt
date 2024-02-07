package com.example.instagramnewsclient.domain

data class StatisticItem(
    val type: StatisticType,
    val amount: Int = 0
)

enum class StatisticType {
    VIEWS, COMMENTS, SHARES, LIKES
}