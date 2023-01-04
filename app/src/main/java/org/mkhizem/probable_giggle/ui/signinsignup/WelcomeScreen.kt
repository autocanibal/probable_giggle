package org.mkhizem.probable_giggle.ui.signinsignup

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.mkhizem.probable_giggle.Screen

@Composable
fun WelcomeScreen(navController: NavController){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)

    ) {
        Button(
            onClick = {
            navController.navigate(Screen.SignInSignUpScreen.route)
            }) {
            Text(text = "Continue")
        }
    }
}

@Composable
fun SignInSignUpScreen(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Hello This is a test")
    }
}