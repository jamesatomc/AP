package shop.kanari.shop.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun ZoneProduct(navController: NavController) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            ZoneProductItme(
                title = "Laptop",
                onClick = { navController.navigate("laptoplist") }
            )
        }
        item {
            ZoneProductItme(
                title = "Desktop",
                onClick = {  navController.navigate("desktoplist")  }
            )
        }
        item {
            ZoneProductItme(
                title = "จอแสดงผล",
                onClick = { navController.navigate("displaylist") }
            )
        }
        item {
            ZoneProductItme(
                title = "อุปกรณ์เสริม",
                onClick = { navController.navigate("accessorieslist") }
            )
        }


    }
}


@Composable
fun ZoneProductItme(
    title: String = "",
    onClick: () -> Unit = {},

    ) {
    Card(
        Modifier
            .height(60.dp)
            .width(150.dp)
            .clickable(onClick = onClick)
    ) {
        Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
            Text(text = title)
        }
    }
}