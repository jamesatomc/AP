package shop.kanari.shop.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import shop.kanari.shop.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    keyboardType: KeyboardType,
    isPassword: Boolean = false,
    passwordVisible: Boolean = false,
    onPasswordVisibilityChange: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    shadowElevation: Dp = 8.dp // Add shadow elevation parameter
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(
                BorderStroke(
                    color = Color.Transparent,
                    width = 1.dp
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .shadow(shadowElevation, RoundedCornerShape(10.dp)), // Add shadow modifier
        colors = textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = if (isPassword) {
            {
                val image = if (passwordVisible) {
                    painterResource(id = R.drawable.visibility) // Replace with your drawable ID
                } else {
                    painterResource(id = R.drawable.visibility) // Replace with your drawable ID
                }

                IconButton(onClick = onPasswordVisibilityChange!!) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = image, // Use painter instead of imageVector
                        contentDescription = if (passwordVisible) "Hide password" else "Show password"
                    )
                }
            }
        } else null
    )
}