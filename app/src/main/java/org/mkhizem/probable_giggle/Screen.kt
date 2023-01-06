package org.mkhizem.probable_giggle

sealed class Screen(val route: String){
    object WelcomeScreen : Screen("welcomeScreen")
    object SignUpScreen : Screen("signUpScreen")
    object SignInScreen : Screen("signInScreen")
    object StoreScreen : Screen("storeScreen")
    object CheckoutScreen : Screen("checkoutScreen")
}
