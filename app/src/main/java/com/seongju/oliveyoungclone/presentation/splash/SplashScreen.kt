package com.seongju.oliveyoungclone.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.seongju.oliveyoungclone.R
import com.seongju.oliveyoungclone.ui.theme.SpaceDefault

@Composable
fun SplashScreen(navController: NavHostController) {
    Scaffold {
        Box(
            modifier = Modifier
                .padding(it)
        ) {
            SplashScreenBody()
        }
    }
}

@Composable
fun SplashScreenBody() {

    val scale = remember {
        Animatable(0f)
    }
    
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1.0f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .weight(1f)
                .padding(
                    vertical = SpaceDefault
                )
        )
        Image(
            painter = painterResource(id = R.drawable.logo_text),
            contentDescription = "splash logo image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(horizontal = SpaceDefault)
                .scale(scale.value)
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
                .padding(
                    vertical = SpaceDefault
                )
        )
        Image(
            painter = painterResource(id = R.drawable.background_splash),
            contentDescription = "bottom splash image",
            contentScale = ContentScale.FillWidth
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview(
    
) {
    val navController = rememberNavController()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        SplashScreen(navController)
    }

}