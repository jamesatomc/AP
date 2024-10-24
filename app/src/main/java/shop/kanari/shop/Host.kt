package shop.kanari.shop

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import shop.kanari.shop.home.Cart
import shop.kanari.shop.home.HomeScreen
import shop.kanari.shop.home.productcategory.AccessoriesList
import shop.kanari.shop.home.productcategory.DesktopList
import shop.kanari.shop.home.productcategory.DisplayList

import shop.kanari.shop.home.productcategory.LaptopList
import shop.kanari.shop.utils.SessionManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHost() {
    val navController = rememberNavController()
    val context = LocalContext.current

    // Check login status and set start destination
    val startDestination = if (SessionManager.isLoggedIn(context)) "home" else "login"

    NavHost(navController = navController, startDestination = startDestination) {
        composable("home") {
            HomeScreen(navController = navController)
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
        composable("forgeScreen") {
            ForgePasswordScreen(navController = navController)
        }
    }
}