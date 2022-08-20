package com.tostert.navigationfiledeeplink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.tostert.navigationfiledeeplink.screenA.ScreenA
import com.tostert.navigationfiledeeplink.screenB.ScreenB
import com.tostert.navigationfiledeeplink.screenB.ScreenBViewModel
import dagger.hilt.android.AndroidEntryPoint

private object Screens {
    const val screenA = "screenA"
    const val screenB = "screenB"
}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screens.screenA,
            ) {
                composable(route = Screens.screenA) {
                    ScreenA {
                        navController.navigate(Screens.screenB)
                    }
                }
                composable(
                    route = Screens.screenB,
                    deepLinks = listOf(
                        navDeepLink {
                            uriPattern = "content://"
                            mimeType = "application/json"
                            action = Intent.ACTION_VIEW
                        }
                    ),
                    // with this the app doesn't crash
//                    arguments = listOf(
//                        navArgument(name = "bla") {
//                            type = NavType.StringType
//                            nullable = true
//                            defaultValue = null
//                        }
//                    )
                ) {
                    val viewModel = hiltViewModel<ScreenBViewModel>()
                    ScreenB(
                        viewModel = viewModel,
                        onBack = navController::navigateUp,
                    )
                }
            }
        }
    }
}
