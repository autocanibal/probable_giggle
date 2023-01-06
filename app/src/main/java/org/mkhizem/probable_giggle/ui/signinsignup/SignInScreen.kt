package org.mkhizem.probable_giggle.ui.signinsignup

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.mkhizem.probable_giggle.R
import org.mkhizem.probable_giggle.Screen
import org.mkhizem.probable_giggle.ui.theme.md_theme_dark_background
import org.mkhizem.probable_giggle.ui.theme.md_theme_light_background
import org.mkhizem.probable_giggle.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(navController: NavController){
    val emailValue = remember { mutableStateOf("")}
    val passwordValue = remember { mutableStateOf("")}
    val passwordVisibility = remember{ mutableStateOf(false)}
    val focusRequester = remember{FocusRequester()}
    val scrollState = rememberScrollState()
    val lightTheme = LocalContentColor.current.luminance() < 0.5f

    val background = if(lightTheme){
        md_theme_light_background
    }else{
        md_theme_dark_background
    }
    
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(background)
                .fillMaxHeight(0.6f)
                .clip(Shapes.large)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.verticalScroll(scrollState)
            ){
                Text(
                    text = "Sign In",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    ),
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = {emailValue.value = it},
                        label = { Text(text = "Email Address") },
                        placeholder = { Text(text = "Email Address") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                    )

                    val assetId = if(lightTheme){
                        R.drawable.password_eye_dark
                    }else{
                        R.drawable.password_eye_light
                    }
                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = {passwordValue.value = it},
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility.value = !passwordVisibility.value
                            }){
                                Icon(
                                    imageVector = ImageVector.vectorResource(id= assetId),
                                    contentDescription = "visibility eye"
                                )
                            }
                        },
                        label = { Text(text = "Password")},
                        placeholder = { Text(text = "Password")},
                        singleLine = true,
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .focusRequester(focusRequester = focusRequester)
                    )

                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Sign In",
                            fontSize = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = "Sign Up",
                        modifier = Modifier
                            .clickable(
                                onClick = { navController.navigate(Screen.SignUpScreen.route){
                                    launchSingleTop = true
                                } }
                            )

                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun SignInScreenPreview(){
    val navController = rememberNavController()
    SignInScreen(navController= navController)
}