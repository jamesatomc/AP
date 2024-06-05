package shop.kanari.shop.home.productcategory

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import shop.kanari.shop.home.productcategory.components.PCListItem


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LaptopList(navController: NavHostController) {

    Scaffold(
        Modifier.fillMaxWidth(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent,
                ),
                title = {
                    Text("Laptop")
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
                                navController.navigate("home")
                            }
                        ) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    }
                },
            )
        },
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(18.dp),
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Text(text = "IdeaPad", fontSize = 18.sp, fontWeight = FontWeight.Bold,)
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyRow(
                    horizontalArrangement =  Arrangement.spacedBy(10.dp),
                ) {
                    item {
                        PCListItem(
                            title = "Laptop",
                            subtitle = "Best Laptop",
                            header = "Laptop",
                            backgroundColor = Color.Black,
                            onClick = {
                                navController.navigate("Cart")
                            },
                            image = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_16IMH9/IdeaPad_Pro_5_16IMH9_CT2_06.png"
                        )
                    }
                    item {
                        PCListItem(
                            title = "Laptop",
                            subtitle = "Best Laptop",
                            header = "Laptop",
                            backgroundColor = Color.Black,
                            onClick = {
                                navController.navigate("Cart")
                            },
                            image = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_16IMH9/IdeaPad_Pro_5_16IMH9_CT2_06.png"
                        )
                    }
                }
            }
            Text(text = "IdeaPad", fontSize = 18.sp, fontWeight = FontWeight.Bold,)
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            }
        }
    }
}

