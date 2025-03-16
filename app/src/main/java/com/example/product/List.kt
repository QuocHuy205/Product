package com.example.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ProductListScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopBar(navController) },
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            itemsIndexed(listProduct) { index, product ->
                ProductItem(product, index, navController)
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, index: Int, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("product_detail/$index")
            },
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
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    val formattedPrice = String.format("%.3f", product.price)
                    Text("${formattedPrice} VND", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        Icons.Default.Add, contentDescription = "Add",
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
