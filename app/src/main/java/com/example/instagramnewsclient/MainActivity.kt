package com.example.instagramnewsclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.instagramnewsclient.ui.theme.InstagramNewsClientTheme
import com.example.instagramnewsclient.ui.theme.MainScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramNewsClientTheme {
                MainScreen()
            }
        }
    }
}
