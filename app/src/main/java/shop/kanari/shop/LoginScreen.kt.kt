package shop.kanari.shop

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import shop.kanari.shop.google.GoogleApiContract
import shop.kanari.shop.ui.theme.ShopTheme
import shop.kanari.shop.utils.SessionManager
import shop.kanari.shop.widget.ButtonType
import shop.kanari.shop.widget.CustomButton
import shop.kanari.shop.widget.CustomTextField


@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@Composable
fun LoginScreen(
    navController: NavHostController,
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val isLoading by remember { mutableStateOf(false) }
    var loginError by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current

    // Google Sign-In launcher
    val googleSignInLauncher: ActivityResultLauncher<Int> = rememberLauncherForActivityResult(
        contract = GoogleApiContract()
    ) { task: Task<GoogleSignInAccount>? ->
        // Inside the Google Sign-In task onCompleteListener
        task?.addOnCompleteListener { completedTask ->
            if (completedTask.isSuccessful) {
                // Handle successful sign-in
                SessionManager.setLoggedIn(context, true)
                navController.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
            } else {
                // Handle sign-in failure
                loginError = "Google Sign-In failed"
            }
        }
    }

    Scaffold {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .height(460.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                        // Logo
                        AsyncImage(
                            model = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_14AHP9/IdeaPad_Pro_5_14AHP9_CT2_03.png",
                            contentDescription = "Translated description of what the image contains",
                            Modifier.size(350.dp),
                        )
                    }
                    Box {
                        Text(
                            text = "Welcome!",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Box {
                        Text(
                            text = "บริการขายอุปกรณ์ it",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(bottom = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    CustomTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = "Username",
                        placeholder = "Username",
                        keyboardType = KeyboardType.Text
                    )
                    Spacer(Modifier.size(16.dp))
                    CustomTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = "Password",
                        placeholder = "Password",
                        keyboardType = KeyboardType.Password,
                        isPassword = true,
                        passwordVisible = passwordVisible,
                        onPasswordVisibilityChange = { passwordVisible = !passwordVisible }
                    )
                    Spacer(Modifier.size(16.dp))
                    Box(Modifier.fillMaxWidth()) {
                        TextButton(
                            onClick = {
                                navController.navigate("forgeScreen") {
                                    popUpTo("loginScreen") { inclusive = true }
                                }
                            },
                            Modifier
                                .padding(start = 2.dp)
                        ) {
                            Text("Forge Password")
                        }
                    }
                    CustomButton(
                        cornerRadius = 20.dp,
                        text = "Login",
                        onClick = {
                            navController.navigate("home")
                        },
                        isLoading = isLoading
                    )

                    if (loginError != null) {
                        Text(loginError!!, color = Color.Red)
                    }
                    CustomButton(
                        text = "Register",
                        onClick = { navController.navigate("register") },
                        buttonType = ButtonType.TEXT_BUTTON
                    )

                    CustomButton(
                        cornerRadius = 20.dp,
                        text = "Sign in with Google",
                        onClick = {
                            googleSignInLauncher.launch(1)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        ),
                        icon = painterResource(id = R.drawable.pngwing_com),
                        iconDescription = "Google Sign-In"
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,showBackground = true)
@Composable
fun LoginScreenPreview() {
    ShopTheme {
        LoginScreen(
            navController = rememberNavController(),
        )
    }
}