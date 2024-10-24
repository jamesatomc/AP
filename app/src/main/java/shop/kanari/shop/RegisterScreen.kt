package shop.kanari.shop

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@Composable
fun RegisterScreen(
    navController: NavHostController,
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    val isLoading by remember { mutableStateOf(false) }
    val registerError by remember { mutableStateOf<String?>(null) }
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
                SessionManager.setLogin(context, true)
                navController.navigate("home") {
                    popUpTo("register") { inclusive = true }
                }
            } else {
                // Handle sign-in failure
                loginError = "Google Sign-In failed"
            }
        }
    }

    Scaffold(
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .height(350.dp),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                        // Logo
                        AsyncImage(
                            model = "https://psrefstuff.lenovo.com/syspool/Sys/Image/IdeaPad/IdeaPad_Pro_5_14AHP9/IdeaPad_Pro_5_14AHP9_CT2_03.png",
                            contentDescription = "Translated description of what the image contains",
                            Modifier.size(200.dp),
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
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {


                    TextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Username") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .border(
                                BorderStroke(
                                    color = Color.Transparent,
                                    width = 1.dp
                                ),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clip(RoundedCornerShape(10.dp)),
                        colors = ExposedDropdownMenuDefaults.textFieldColors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        )
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .border(
                                BorderStroke(
                                    color = Color.Transparent,
                                    width = 1.dp
                                ),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clip(RoundedCornerShape(10.dp)),
                        colors = ExposedDropdownMenuDefaults.textFieldColors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        )
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .border(
                                BorderStroke(
                                    color = Color.Transparent,
                                    width = 1.dp
                                ),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clip(RoundedCornerShape(10.dp)),
                        colors = ExposedDropdownMenuDefaults.textFieldColors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        )
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    TextField(
                        value = firstname,
                        onValueChange = { firstname = it },
                        label = { Text("Firstname") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .border(
                                BorderStroke(
                                    color = Color.Transparent,
                                    width = 1.dp
                                ),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clip(RoundedCornerShape(10.dp)),
                        colors = ExposedDropdownMenuDefaults.textFieldColors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        )
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    TextField(
                        value = lastname ,
                        onValueChange = { lastname = it },
                        label = { Text("Lastname") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .border(
                                BorderStroke(
                                    color = Color.Transparent,
                                    width = 1.dp
                                ),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clip(RoundedCornerShape(10.dp)),
                        colors = ExposedDropdownMenuDefaults.textFieldColors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        )
                    )

                    Button(
                        onClick = {
//                            isLoading = true
//                            isLoading = false
//                            coroutineScope.launch {
//                                try {
//                                    val response = registerService.register(RegisterRequest(username, email, password, firstname, lastname))
//                                    if (response.isSuccessful) {
//
//                                        navController.navigate("RootHomeScreen") {
//                                            popUpTo("registerScreen") { inclusive = true }
//                                        }
//
//                                    } else {
//                                        registerError = response.errorBody()
//                                    }
//                                } catch (e: Exception) {
//                                    registerError = "Register failed"
//                                } finally {
//                                    isLoading = false
//                                }
//                            }
                        },
                        enabled = !isLoading,
                        modifier = Modifier
                            .padding(top = 16.dp, start = 40.dp, end = 40.dp)
                            .fillMaxWidth()
                    ) {
                        if (isLoading) {
                            CircularProgressIndicator(color = Color.White)
                        } else {
                            Text("Continue")
                        }
                    }
                    if (registerError != null) {
                        Text(registerError!!, color = Color.Red)
                    }

                    TextButton(
                        onClick = { navController.navigate("login") },
                        modifier = Modifier
                            .padding(top = 1.dp, start = 40.dp, end = 40.dp)
                            .fillMaxWidth()
                    ) {
                        Text("Sign In")
                    }
                    // Google Sign-In Button
                    Button(
                        onClick = {
                            googleSignInLauncher.launch(1)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .padding(top = 16.dp, start = 40.dp, end = 40.dp)
                            .fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.pngwing_com), // Replace with your Google logo drawable
                            contentDescription = "Google Sign-In",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Sign in with Google", color = Color.Black)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,showBackground = true)
@Composable
fun RegisterScreenPreview() {
    ShopTheme {
        RegisterScreen(navController = rememberNavController() )
    }
}