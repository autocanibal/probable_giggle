package org.mkhizem.probable_giggle

sealed class Screen(val route: String){
    object WelcomeScreen : Screen("welcomeScreen")
    object SignInSignUpScreen : Screen("signInSignUpScreen")
}
