package shop.kanari.shop

import android.annotation.SuppressLint
import android.content.res.Configuration
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import shop.kanari.shop.ui.theme.ShopTheme

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@Composable
fun LoginScreen(
    navController: NavHostController,
) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isLoading by remember { mutableStateOf(false) }
    val loginError by remember { mutableStateOf<String?>(null) }

//    val coroutineScope = rememberCoroutineScope()

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
                        .height(460.dp),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
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

                    TextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Username") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
                        colors = textFieldColors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        )
                    )
                    Spacer(Modifier.size(16.dp))
                    var passwordVisible by rememberSaveable { mutableStateOf(false) }

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        placeholder = { Text("Password") },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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
                        colors = textFieldColors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        ),
                        trailingIcon = {
                            val image = if (passwordVisible)
                                Icons.Filled.Lock
                            else Icons.Filled.Lock

                            // Please provide localized description for accessibility services
                            val description = if (passwordVisible) "Hide password" else "Show password"

                            IconButton(onClick = {passwordVisible = !passwordVisible}){
                                Icon(imageVector  = image, description)
                            }
                        }
                    )

                    Box(Modifier.fillMaxWidth()){
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

                    Button(
                        onClick = {
                            navController.navigate("home")
                            //api
//                            isLoading = false
//                            coroutineScope.launch {
//                                try {
//                                    isLoading = true
//                                    val response = loginService.login(LoginRequest(username, password))
//                                    if (response.isSuccessful) {
//
//                                        navController.navigate("RootHomeScreen") {
//                                            popUpTo("loginScreen") { inclusive = true }
//                                        }
//
//                                    } else {
//                                        loginError = response.errorBody()
//                                    }
//                                } catch (e: Exception) {
//                                    loginError = "Login failed"
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
                            Text("Login")
                        }
                    }

                    if (loginError != null) {
                        Text(loginError!!, color = Color.Red)
                    }

                    TextButton(
                        onClick = {
                            navController.navigate("register")
                        },
                        modifier = Modifier
                            .padding(top = 1.dp, start = 40.dp, end = 40.dp)
                            .fillMaxWidth()
                    ) {
                        Text("Register")
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
fun LoginScreenPreview() {
    ShopTheme {
        LoginScreen(
            navController = rememberNavController(),
        )
    }
}