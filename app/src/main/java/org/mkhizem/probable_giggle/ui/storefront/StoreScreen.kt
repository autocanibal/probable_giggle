package org.mkhizem.probable_giggle.ui.storefront

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.mkhizem.probable_giggle.Screen

@Composable
fun StoreScreen(navController: NavController){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(100){index ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Item $index")
                }
            }
        }
    )
}

/*
@ExperimentalMaterial3Api
@Composable
fun ProductCard(

    painter: Painter,
    contentDescription: String,
    name:String,
    price:Float,
    modifier: Modifier,
    navController: NavController
){
    Card(
        onClick = {navController.navigate(Screen.ProductScreen.route)},
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = modifier.height(200.dp)){
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Text(
                    price.toString(),
                    style =  TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(name,
                    style =  TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
        }
    }
}
*/
@Preview
@Composable
fun StoreScreenPreview(){
    val navController = rememberNavController()
    StoreScreen(navController = navController)
}