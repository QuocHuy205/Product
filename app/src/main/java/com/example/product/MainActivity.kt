package com.example.product

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.product.ui.theme.ProductTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductListScreen()
                }
            }
        }
    }
}

@Composable
fun ProductListScreen() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(listProduct) { product ->
                ProductItem(product)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text("Product", fontWeight = FontWeight.Bold) },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFDCC7E1))
    )
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(containerColor = Color(0xFFDCC7E1)) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
            label = { Text("Cart") },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Person") },
            label = { Text("Person") },
            selected = false,
            onClick = {}
        )
    }
}


@Composable
fun ProductItem(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .width(140.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(product.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(product.description, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Text("⭐ ${product.rating}", fontSize = 15.sp, color = Color(0xFFFFA500))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    val formattedPrice = String.format("%.3f", product.price)
                    Text("${formattedPrice} VND", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(Icons.Default.Add, contentDescription = "Add",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .clickable {

                            })
                }
            }
        }
    }
}





@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar()
        Box(modifier = Modifier.weight(1f)) {
            ProductDetailScreen()
        }
        BottomNavigationBar()
    }
}



@Composable
fun ProductDetailScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White)) {
        item {
            Image(
                painter = painterResource(id = R.drawable.aophao),
                contentDescription = "Product Image",
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Inside
            )
        }

        item {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Áo phao", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Text("⭐⭐⭐⭐☆ (2 Reviews)", fontSize = 14.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Áo phao size nhỏ cho học sinh tiểu học.\n" +
                            "Size 2 cho học sinh lớp 1-2-3\n" +
                            "Size 3 cho học sinh lớp 4-5", fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("100.000 VND", fontWeight = FontWeight.Bold, fontSize = 20.sp)
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

        item { ReviewItem("Test User", "5/15/2022", "Loved it!", "Amazing product. Can't go wrong with this one. 100% recommend.") }
        item { ReviewItem("Ahmed Khan", "7/20/2022", "Excellent quality", "Amazing quality for the price.") }
        item { ReviewItem("Test User", "5/15/2022", "Loved it!", "Can't go wrong with this one. 100% recommend.") }
        item { ReviewItem("Ahmed Khan", "7/20/2022", "Excellent quality", "OKkkkkkkkkkkkk") }
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






data class Product(
    val name: String,
    val description: String,
    val price: Double,
    val rating: Double,
    val imageRes: Int
)

val listProduct = listOf(
    Product(
        "Áo tù",
        "Bộ Tù Trưởng Kẻ Sọc Quần Áo Phạm Nhân Cực K" +
                "ỳ Độc và Lạ dành cho cả nam nữ . Bộ tù cộc tay chất " +
                "liệu kate thái cao cấp, màu sắc sang trọng đằng cấp dân chơi ^^",
        200.505,
        4.5,
        R.drawable.aotu
    ),
    Product(
        "Áo cà sa",
        "Tất cả các sản phẩm áo cà sa tại Yenlanh.com đều được " +
                "chọn lọc kỹ lưỡng từ nguồn vải cao cấp, đảm bảo độ bền và thoải mái khi mặc. Bạ" +
                "n có thể yên tâm về việc sử dụng sản phẩm của chúng tôi trong thời gian dài " +
                "mà không lo lắng về việc hao mòn hay biến dạng.",
        500.000,
        4.0,
        R.drawable.aocasa
    ),
    Product("Áo phao",
        "Áo phao size nhỏ cho học sinh tiểu học.\n" +
                "Size 2 cho học sinh lớp 1-2-3\n" +
                "Size 3 cho học sinh lớp 4-5\n",
        100.000,
        5.0,
        R.drawable.aophao),
    Product("Áo Akatsuki",
        "Sản phẩm bao gồm: áo choàng hoặc khác (vui lòng chọn tùy chọn bạn cần)\n" +
                "\n" +
                "Kích thước: Trẻ em: 125-135cm/145-155cm\n" +
                "\n" +
                "Người lớn: S, M, L, XL, XXL",
        180.000,
        5.0,
        R.drawable.aoakatsuki),
    Product("Áo VKU",
        "Đồng phục VKU.",
        100.000,
        4.0,
        R.drawable.aovku),
    Product(
        "Áo choàng thần Ra",
        "Hỏa diệm: Gây 2% máu tối đa " +
                "thành sát thương phép mỗi giây lên" +
                " những kẻ địch cạnh bên (tăng 50% sát" +
                " thương lên quái và lính) – Nội tại duy nhất",
        140.000,
        4.0,
        R.drawable.aochoangthanra
    ),
    Product(
        "Áo choàng băng giá",
        "Sức mạnh nguyên tố: Sau khi tung chiêu," +
                " trong 5 giây sẽ khiến đòn đánh kế gây thêm 100 " +
                "(+30% công vật lý) sát thương vật lý lan trong " +
                "phạm vi 3m quanh mục tiêu kèm 30% làm chậm địch " +
                "(tướng đánh xa làm chậm chỉ được 20%) trong 0.5 " +
                "giây; 0.65 giây hồi – Nội tại duy nhất",
        140.000,
        4.0,
        R.drawable.aochoangbanggia
    ),
    Product("Giáp hộ mệnh",
        "Phục sinh: Tướng sẽ sống lại sau " +
                "2 giây tại nơi bị hạ gục với 2100 – 3500 Máu;" +
                " 150 giây hồi chiêu. Đặc biệt mỗi trận chỉ có" +
                " tác dụng 2 lần – Nội tại duy nhất",
        150.000,
        5.0,
        R.drawable.giaphomenh),
    Product("Giày thép",
        "+30 Tốc chạy – Nội tại duy nhất: Gia tốc",
        200.000,
        4.5,
        R.drawable.giaythep),
)



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProductTheme {
        ProductScreen()
    }
}