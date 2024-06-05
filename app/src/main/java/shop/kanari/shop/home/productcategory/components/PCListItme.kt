package shop.kanari.shop.home.productcategory.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun PCListItem(
    image: String = "",
    title: String = "",
    subtitle: String = "",
    header: String = "",
    onClick: () -> Unit = {},
    backgroundColor: Color = MaterialTheme.colorScheme.onSurface
) {
    Box(
        Modifier
            .width(182.dp)
            .height(270.dp)
            .clickable(onClick = onClick)
            .background(backgroundColor, RoundedCornerShape(16.dp)),

        ) {
        Column(
            Modifier
                .padding(horizontal = 16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                Modifier
                    .fillMaxWidth()
                    .size(150.dp)
            ) {
                Surface(
                    Modifier.clip(RoundedCornerShape(16.dp)),
                ){
                    AsyncImage(
                        model = image,
                        contentDescription = "Translated description of what the image contains",
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = title, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
            Text(text = subtitle, fontSize = 16.sp, color = Color.White)
            Text(text = header, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}