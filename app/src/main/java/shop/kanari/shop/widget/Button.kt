package shop.kanari.shop.widget

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class ButtonType {
    BUTTON, TEXT_BUTTON
}

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    height: Dp = 48.dp,
    width: Modifier = Modifier.fillMaxWidth(),
    cornerRadius: Dp = 4.dp,
    icon: Painter? = null,
    iconDescription: String? = null,
    buttonType: ButtonType = ButtonType.BUTTON
) {
    val buttonModifier = modifier
        .padding(top = 16.dp, start = 40.dp, end = 40.dp)
        .height(height)
        .then(width)

    when (buttonType) {
        ButtonType.BUTTON -> {
            Button(
                onClick = onClick,
                enabled = enabled && !isLoading,
                colors = colors,
                shape = RoundedCornerShape(cornerRadius),
                modifier = buttonModifier
            ) {
                ButtonContent(text, isLoading, icon, iconDescription)
            }
        }
        ButtonType.TEXT_BUTTON -> {
            TextButton(
                onClick = onClick,
                enabled = enabled && !isLoading,
                modifier = buttonModifier
            ) {
                ButtonContent(text, isLoading, icon, iconDescription)
            }
        }
    }
}

@Composable
private fun ButtonContent(
    text: String,
    isLoading: Boolean,
    icon: Painter?,
    iconDescription: String?
) {
    if (isLoading) {
        CircularProgressIndicator(color = Color.White)
    } else {
        if (icon != null) {
            Icon(
                painter = icon,
                contentDescription = iconDescription,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(text)
    }
}