package com.example.valorant

import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.widget.VideoView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController

@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
//animation daala hai
    val videoUri = Uri.parse("android.resource://${context.packageName}/raw/intro_animation")

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ) {
        AndroidView(
            factory = {
                VideoView(it).apply {
                    setVideoURI(videoUri)
                    setOnPreparedListener { player ->
                        player.isLooping = false
                        start()
                    }
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }

    // 5 secs mein navigate to login screen
    Handler(Looper.getMainLooper()).postDelayed({
        navController.navigate(Screen.Login.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }, 5000)
}
