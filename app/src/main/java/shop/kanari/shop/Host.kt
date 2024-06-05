package shop.kanari.shop

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import shop.kanari.shop.home.Cart
import shop.kanari.shop.home.HomeScreen
import shop.kanari.shop.home.productcategory.AccessoriesList
import shop.kanari.shop.home.productcategory.DesktopList
import shop.kanari.shop.home.productcategory.DisplayList

import shop.kanari.shop.home.productcategory.LaptopList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "register") {
        composable("home") {
            HomeScreen(
                navController = navController
            )
        }
        //ProductCategory
        composable("laptoplist") {
            LaptopList(navController = navController)
        }
        composable("desktoplist") {
            DesktopList(navController = navController)
        }
        composable("displaylist") {
            DisplayList(navController = navController)
        }
        composable("accessorieslist") {
            AccessoriesList(navController = navController)
        }
        composable("Cart") {
            Cart(navController = navController)
        }
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("register") {
           RegisterScreen(navController = navController)
        }
    }
}