package com.example.instagramnewsclient.domain.entity

sealed class AuthState {

    data object Initial: AuthState()
    data object Authorized: AuthState()
    data object NotAuthorized: AuthState()
}