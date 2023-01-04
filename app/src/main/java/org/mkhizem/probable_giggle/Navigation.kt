package org.mkhizem.probable_giggle

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.mkhizem.probable_giggle.ui.signinsignup.WelcomeScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route){
        composable(route = Screen.WelcomeScreen.route){
            WelcomeScreen(navController = navController)
        }
    }
}