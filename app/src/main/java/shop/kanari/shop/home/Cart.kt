package shop.kanari.shop.home

import android.annotation.SuppressLint
import android.content.res.Configuration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import shop.kanari.shop.R
import shop.kanari.shop.ui.theme.ShopTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Cart(navController: NavHostController) {
    val countState = remember { mutableIntStateOf(0) }
    val count by countState
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                ),
                scrollBehavior = scrollBehavior,

                title = {

                },
                navigationIcon = {
                    Box(
                        Modifier
                            .width(60.dp)
                            .height(60.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        IconButton(
                            onClick = {
                                navController.navigate("laptoplist")
                            }
                        ) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Localized description",
//                                tint = MaterialTheme.colorScheme.background
                            )
                        }
                    }
                },
                actions = {
                    IconButton(
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp),
                        onClick = {  }
                    ) {
                        Box(
                            Modifier,
                            Alignment.Center
                        ) {
                            Box {
                                Icon(
                                    painter = painterResource(R.drawable.add_shopping_cart),contentDescription = "",
                                    modifier = Modifier.size(30.dp),
                                )
                                Box(
                                    modifier = Modifier
                                        .size(15.dp)
                                        .clip(CircleShape)
                                        .background(Color.Red)
                                        .align(Alignment.TopEnd),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "1",
                                        color = Color.White,
                                        fontSize = 10.sp
                                    )
                                }
                            }
                        }
                    }
                }
            )
        },
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Box(
                Modifier
                    .padding(10.dp)

            ) {
                Column(
                    Modifier
                        .height(690.dp)
                        .verticalScroll(rememberScrollState()),
                ) {
                    Surface(
                        Modifier
                            .height(550.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .fillMaxWidth(),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Box(
                            Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            LazyRow {
                                item {
                                    AsyncImage(
                                        model = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_14AHP9/IdeaPad_Pro_5_14AHP9_CT2_03.png",
                                        contentDescription = "Translated description of what the image contains",
                                    )
                                }
                                item {
                                    AsyncImage(
                                        model = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_14AHP9/IdeaPad_Pro_5_14AHP9_CT1_03.png",
                                        contentDescription = "Translated description of what the image contains",
                                    )
                                }
                                item {
                                    AsyncImage(
                                        model = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_16AHP9/IdeaPad_Pro_5_16AHP9_CT1_02.png",
                                        contentDescription = "Translated description of what the image contains",
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    //api
                    Text(text = "IdeaPad Pro 5 16AHP9", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(Modifier) {
                        Text(text = "รายละเอียด",  fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(Modifier.padding(10.dp)) {
                        Text(text = "Up to AMD Ryzen™ 7 8845HS\n" +
                                "Up to Windows® 11 Pro\n" +
                                "Up to NVIDIA® GeForce RTX™ 3050 6GB\n" +
                                "Up to 32GB LPDDR5x-6400, soldered\n" +
                                "Up to 1x 1TB M.2 PCIe® NVMe® SSD\n" +
                                "14\" 2.8K (2880x1800) OLED, 600nits (peak), 100% DCI-P3, Eyesafe®, DisplayHDR™ True Black 500, 120Hz")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(Modifier) {
                        Text(text = "การจัดส่งสินค้า", fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(Modifier.padding(10.dp)) {
                        Text(text = "จะใช้เวลาในการจัดส่ง 7 - 14 วัน")
                    }

                    // api cx

                }
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .background(
                        MaterialTheme.colorScheme.surfaceVariant,
                        RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    ),
                contentAlignment = Alignment.Center
            ){
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(text = "จำนวนสินค้า", fontSize = 18.sp)

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Button(onClick = { if (countState.intValue > 0) countState.intValue-- }) {
                                Text(text = "-")
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "$count", fontSize = 24.sp)
                            Spacer(modifier = Modifier.width(12.dp))
                            Button(onClick = { countState.intValue++ }) {
                                Text(text = "+")
                            }
                        }
                    }

                    Row(
                        Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "$10,000", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Row {
                            IconButton(onClick = { /*TODO*/ }) {
                               Icon(painter = painterResource(id = R.drawable.add_shopping_cart), contentDescription = "Add" )
                            }
                            FilledTonalButton(
                                onClick = { /*TODO*/ },
                                Modifier.width(200.dp)
                            ) {
                                Text(text = "Buy")
                            }
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,showBackground = true)
@Composable
fun CartPreview() {
    ShopTheme {
        Cart(navController = rememberNavController())
    }
}