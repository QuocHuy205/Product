package com.example.product

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductScreen(productId: Int, navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(navController)
        Box(modifier = Modifier.weight(1f)) {
            ProductDetailScreen(productId, navController)
        }
        BottomNavigationBar()
    }
}

@Composable
fun ProductDetailScreen(productId: Int, navController: NavHostController) {
    val product = listProduct.getOrNull(productId)

    if (product == null) {
        Text("Không tìm thấy sản phẩm", fontSize = 20.sp)
        return
    }

    LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White)) {
        item {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = "Product Image",
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Inside
            )
        }

        item {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(product.name, fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Text("⭐⭐⭐⭐☆", fontSize = 14.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(8.dp))
                Text(product.description, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text("${product.price} VND", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A1B9A)),
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("ADD TO CART", color = Color.White, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text("Reviews", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        item { ReviewItem("abcd", "5/15/2022", "Loved it!", "Amazing product. Can't go wrong with this one. 100% recommend.") }
        item { ReviewItem("Khan", "7/20/2022", "Excellent quality", "Amazing quality for the price.") }
        item { ReviewItem("User", "5/15/2022", "Loved it!", "Can't go wrong with this one. 100% recommend.") }
        item { ReviewItem("An", "7/20/2022", "Excellent quality", "OKkkkkkkkkkkkk") }
    }
}

@Composable
fun ReviewItem(name: String, date: String, title: String, content: String) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),

        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(name, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.weight(1f))
                Text(date, fontSize = 12.sp, color = Color.Gray)
            }
            Text("⭐⭐⭐⭐⭐", fontSize = 14.sp)
            Text(title, fontWeight = FontWeight.Bold)
            Text(content, fontSize = 14.sp)
        }
    }
}

