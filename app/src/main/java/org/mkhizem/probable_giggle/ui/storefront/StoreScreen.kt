package org.mkhizem.probable_giggle.ui.storefront

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.mkhizem.probable_giggle.Screen
import org.mkhizem.probable_giggle.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreScreen(navController: NavController){

/* todo make for loop for categories
* todo add search bar
*  import data from products
*/
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            item(span = {GridItemSpan(maxLineSpan)}) { Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                Text(text = "Lunch", style = TextStyle(color = Color.Black, fontSize = 30.sp))
            } }
            items(20){i ->
                val painter = painterResource(id = R.drawable.burger)
                val name = "Burger $i"
                val contentDescription = "$name Image"
                val price= 50.5 + i

                Box(
                    modifier = Modifier
                        .padding(3.dp)
                        .aspectRatio(1f)){
                    ProductCard(
                        painter = painter,
                        contentDescription = contentDescription,
                        name = name,
                        price = price,
                        modifier = Modifier,
                        navController = navController
                    )
                }
            }
        }
    )
}


@ExperimentalMaterial3Api
@Composable
fun ProductCard(

    painter: Painter,
    contentDescription: String,
    name:String,
    price:Double,
    modifier: Modifier,
    navController: NavController
){
    val newPrice = if (price % 1.0 == 0.0){
        price.toInt()
    }else{
        price
    }
    Card(
        onClick = {navController.navigate(Screen.ProductScreen.route)},
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(modifier = modifier.height(200.dp)){
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
                contentAlignment = Alignment.TopEnd
            ) {

                Text(
                    newPrice.toString(),
                    style =  TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
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

@Preview
@Composable
fun StoreScreenPreview(){
    val navController = rememberNavController()
    StoreScreen(navController = navController)
}