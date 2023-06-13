package com.example.laundry_application.ui.theme
//import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.TopAppBar
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Person

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem


import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.material.icons.filled.Home





import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.laundry_application.R
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.ui.unit.dp
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Alignment
import androidx.compose.material.Text
//import androidx.compose.ui.Modifier.width
//import androidx.compose.ui.Modifier.Companion.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.painter.Painter











@Composable
fun HomeScreen(){


    Box(
        modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
    ) {


        /*Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Background image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            //colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.10f))
            alpha = 0.2F,

           //colorFilter = ColorFilter.tint(Color(0x80FFFFFF))
        )*/

        MyAppTopAppBar(
            logo = painterResource(R.drawable.logo),
            onNavigationIconClick = { /* Handle navigation click */ },
            onCartIconClick = { /* Handle cart click */ }
        )

        //Spacer(modifier = Modifier.height(90.dp))

        //have to add the lazy vertical here

        Box(modifier = Modifier.padding(top = 65.dp)) {
            Column (
                //modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

                    ){
                LazyRow() {
                    items(3) {
                        scrollImage("machine")
                        scrollImage(my_logo = "sheets")
                        scrollImage(my_logo = "dry2")
                    }
                }

                //Spacer(modifier = Modifier.height(400.dp))


            }

            //Spacer(modifier = Modifier.height(40.dp))
        }


        Column(
            modifier = Modifier.padding(start = 140.dp, top = 240.dp)
        ){
            Box(modifier = Modifier.fillMaxWidth()){

                Text(
                    text = "Our Services",
                    style = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        fontSize = 22.sp,
                        letterSpacing = 0.15.sp,
                    )

                )



            }

        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ){

            MyBottomNavigationBar()


        }












        /*LazyRow(){
            items(3){
                scrollImage("machine")
                scrollImage(my_logo = "sheets")
                scrollImage(my_logo = "dry2")

            }
        }*/


    }
}

@Composable
fun scrollImage(
    my_logo: String
){
    val isHovered = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val resId = context.resources.getIdentifier(my_logo, "drawable", context.packageName)
    //val resId = resources.getIdentifier(my_logo, "drawable", packageName)
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(170.dp)
            .padding(6.dp)
            .clickable { isHovered.value = !isHovered.value },
        shape = RoundedCornerShape(16.dp),

        //elevation = if (isHovered.value) 15.dp else 12.dp,
        elevation = 11.dp,
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        Box(
            contentAlignment = Alignment.Center,
            //modifier = Modifier.aspectRatio(16f/9f)


        ) {
            Image(
                painter = painterResource(id = resId),
                contentDescription = "Card image",
                contentScale = ContentScale.Crop,
                alpha = 0.9F,
                colorFilter = if (isHovered.value) {
                    ColorFilter.tint(Color(0x884A2921))
                } else {
                    null
                },
                modifier = Modifier
                    .fillMaxSize()

            )
            /*Text(
                text = "Card title",
                color = Color.Black,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            )*/

            Column(
                modifier = Modifier.padding(start = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Title",
                    style = TextStyle(
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 40.sp,
                        letterSpacing = 0.15.sp,
                    )

                )
                /*Text(
                    text = "Subtitle",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        letterSpacing = 0.25.sp,
                        color = Color.Gray
                    ),

                )*/


            }
        }
    }

}

@Composable
fun MyAppTopAppBar(
    logo: Painter,
    onNavigationIconClick: () -> Unit,
    onCartIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                //Spacer(modifier = Modifier.weight(7f))
                Image(
                    painter = logo,
                    contentDescription = "App logo",

                    modifier = Modifier
                        .size(77.dp)
                        .weight(1f)
                        //.width(50.dp)
                        //.clip(CircleShape)

                )
            }
        },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = onCartIconClick) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "Cart")
            }
        },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 10.dp,
        modifier = Modifier.height(58.dp)
    )
}

@Composable
fun MyBottomNavigationBar(

) {
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 30.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = true,
            onClick = { /* Handle home item selection */ },
            selectedContentColor = Color(android.graphics.Color.parseColor("#795548")),
            unselectedContentColor = Color.Gray,
            modifier = Modifier.padding(2.dp),
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = false,
            onClick = { /* Handle profile item selection */ },
            selectedContentColor = Color(android.graphics.Color.parseColor("#795548")),
            unselectedContentColor = Color.Gray,
            modifier = Modifier.padding(2.dp),
        )

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Favorite")},
            label = { Text("carding")},
            selected = false,
            onClick = { },
            selectedContentColor = Color(android.graphics.Color.parseColor("#795548")),
            unselectedContentColor = Color.Gray,
            modifier = Modifier.padding(2.dp),

        )
    }
}

@Composable

fun chips(
    sample_logo : String
){
    val context = LocalContext.current
    val resId = context.resources.getIdentifier(sample_logo, "drawable", context.packageName)
    val now = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .width(100.dp)
            .height(50.dp)
            .padding(6.dp)
            .clickable { now.value = !now.value },
        shape = RoundedCornerShape(20.dp),

        //elevation = if (isHovered.value) 15.dp else 12.dp,
        elevation = 11.dp,
        backgroundColor = Color.White,
        contentColor = Color.Black

    ){
        Image(
            painter = painterResource(id = resId),
            contentDescription = "service cards",
            contentScale = ContentScale.Crop,
            alpha = 0.95F,
            /*colorFilter = if (now.value) {
                ColorFilter.tint(Color(0x884A2921))
            } else {
                null
            },*/
            modifier = Modifier
                .fillMaxSize()

        )



    }
}





