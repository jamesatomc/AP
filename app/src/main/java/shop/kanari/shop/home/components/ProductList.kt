package shop.kanari.shop.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun ProductList() {
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        ProductListItem(
            onClick = {},
            image = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_16IMH9/IdeaPad_Pro_5_16IMH9_CT2_06.png",
            title = "Fruit",
            subtitle = "Start @",
            header = "$1",
        )
        ProductListItem(
            onClick = {},
            image = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_16IMH9/IdeaPad_Pro_5_16IMH9_CT2_06.png",
            title = "Lenovo",
            subtitle = "",
            header = "$1",
        )
        ProductListItem(
            onClick = {},
            image = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_16IMH9/IdeaPad_Pro_5_16IMH9_CT2_06.png",
            title = "Fruitrhdhddshds",
            subtitle = "",
            header = "$1",
        )
        ProductListItem(
            onClick = {},
            image = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_16IMH9/IdeaPad_Pro_5_16IMH9_CT2_06.png",
            title = "Fruitdgdsgdsg",
            subtitle = "",
            header = "$1",
        )

    }
}


@Composable
fun ProductListItem(
    onClick: () -> Unit = {},
    title: String = "",
    subtitle: String = "",
    header: String = "",
    image : String = "",
    backgroundColor: Color = MaterialTheme.colorScheme.onSurface
) {
    Box(
        Modifier
            .clickable(onClick = onClick)
            .fillMaxSize()
            .height(140.dp)
            .background(backgroundColor, RoundedCornerShape(16.dp)),
    ) {
        Row(
            Modifier.fillMaxSize()
                .padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = image,
                contentDescription = "",
                Modifier
                    .height(120.dp)
                    .weight(1f),

                alignment = Alignment.CenterStart
            )
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text(text = title, fontSize = 14.sp, color = MaterialTheme.colorScheme.background)
                Text(text = subtitle, fontSize = 16.sp, color = MaterialTheme.colorScheme.background, fontWeight = FontWeight.Bold)
                Text(text = header, fontSize = 28.sp, color = MaterialTheme.colorScheme.background, fontWeight = FontWeight.Bold)
            }
        }
    }
}