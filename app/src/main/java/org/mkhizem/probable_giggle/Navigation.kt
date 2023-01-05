package org.mkhizem.probable_giggle

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import org.mkhizem.probable_giggle.ui.signinsignup.SignInSignUpScreen
import org.mkhizem.probable_giggle.ui.signinsignup.WelcomeScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route){
        composable(route = Screen.WelcomeScreen.route){
            WelcomeScreen(navController = navController)
        }
        composable(
            route = Screen.SignInSignUpScreen.route + "?name={name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    nullable = true
                }
            )
        ){ entry ->
            SignInSignUpScreen(name = entry.arguments?.getString("name"))
        }
    }
}