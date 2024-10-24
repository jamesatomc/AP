package shop.kanari.shop.home

import android.annotation.SuppressLint
import android.content.res.Configuration
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import androidx.compose.ui.platform.LocalContext

import shop.kanari.shop.home.components.ProductList
import shop.kanari.shop.home.components.Promotions
import shop.kanari.shop.home.components.ZoneProduct
import shop.kanari.shop.R
import shop.kanari.shop.ui.theme.ShopTheme
import kotlinx.coroutines.launch
import shop.kanari.shop.utils.SessionManager

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent,
                ),
                scrollBehavior = scrollBehavior,
                title = {},
                navigationIcon = {
                    Box(
                        Modifier
                            .width(60.dp)
                            .height(60.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }
                        ) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Localized description",
                            )
                        }
                    }
                },
                actions = {
                    val context = LocalContext.current
                    Box(
                        Modifier
                            .width(60.dp)
                            .height(60.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        IconButton(
                            onClick = {
                                // Perform logout operation
                                SessionManager.logout(context, navController)
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.home),
                                contentDescription = "Logout",
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }
            )
        },
    ) {
        Column(
            Modifier
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(120.dp))
            Promotions()
            Box(
                Modifier.fillMaxWidth(),
            ) {
                Text(text = "หมวดหมู่สินค้า", fontSize = 18.sp)
            }
            ZoneProduct(navController)
            Box(
                Modifier.fillMaxWidth(),
            ) {
                Text(text = "ยอดนิยม", fontSize = 18.sp)
            }
            ProductList()
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,showBackground = true)
@Composable
fun HomePreview() {
    ShopTheme {
        HomeScreen(navController = rememberNavController())
    }
}