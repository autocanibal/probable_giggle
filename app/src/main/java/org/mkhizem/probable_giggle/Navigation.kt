package org.mkhizem.probable_giggle

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.mkhizem.probable_giggle.ui.signinsignup.SignInScreen
import org.mkhizem.probable_giggle.ui.signinsignup.SignUpScreen
import org.mkhizem.probable_giggle.ui.signinsignup.WelcomeScreen
import org.mkhizem.probable_giggle.ui.storefront.StoreScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route){
        composable(route = Screen.WelcomeScreen.route){
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.SignInScreen.route) {
            SignInScreen(navController = navController)
        }
        composable(route = Screen.SignUpScreen.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = Screen.StoreScreen.route) {
            StoreScreen(navController = navController)
        }
    }
}