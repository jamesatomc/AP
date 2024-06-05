package shop.kanari.shop.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun Promotions() {
    LazyRow(
        Modifier
            .height(180.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PromotionItem(
                image = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_16IMH9/IdeaPad_Pro_5_16IMH9_CT2_06.png",
                title = "Fruit",
                subtitle = "Start @",
                header = "$1",

                )
        }
        item {
            PromotionItem(
                image = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_16IMH9/IdeaPad_Pro_5_16IMH9_CT2_06.png",
                title = "Meat",
                subtitle = "Discount",
                header = "20%",
            )
        }
        item {
            PromotionItem(
                image = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_16IMH9/IdeaPad_Pro_5_16IMH9_CT2_06.png",
                title = "Meat",
                subtitle = "Discount",
                header = "20%",
            )
        }
    }
}

@Composable
fun PromotionItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    image: String = "",
    backgroundColor: Color = MaterialTheme.colorScheme.primary
) {
    Box(
        Modifier
            .width(300.dp)
            .background(backgroundColor, RoundedCornerShape(16.dp)),
    ) {
        Row {
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, fontSize = 14.sp,color = MaterialTheme.colorScheme.background)
                Text(text = subtitle, fontSize = 16.sp,color = MaterialTheme.colorScheme.background, fontWeight = FontWeight.Bold)
                Text(text = header, fontSize = 28.sp, color = MaterialTheme.colorScheme.background, fontWeight = FontWeight.Bold)
            }
            Box(
                Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center

            ) {

                Box(Modifier.size(150.dp)) {
                    AsyncImage(
                        model = image,
                        contentDescription = "Translated description of what the image contains",
                    )
                }

            }
        }
    }
}