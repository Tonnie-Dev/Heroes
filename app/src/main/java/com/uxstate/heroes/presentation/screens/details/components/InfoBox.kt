package com.uxstate.heroes.presentation.screens.details.components


import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.heroes.R
import com.uxstate.heroes.presentation.ui.theme.titleColor
import com.uxstate.heroes.util.LocalSpacing

@Composable
fun InfoBox(
    icon: Painter,
    iconTint: Color,
    bigText: String,
    smallText: String,
    textColor: Color
) {

    val spacing = LocalSpacing.current
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
                modifier = Modifier
                        .padding(end = spacing.spaceExtraSmall)
                        .size(spacing.spaceLarge),

                        painter = icon,
                contentDescription = stringResource(R.string.info_icon),
                tint = iconTint
        )

        Column {
            Text(
                    text = bigText,
                    color = textColor,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Black
            )

            Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = smallText,
                    color = textColor,
                    fontSize = MaterialTheme.typography.overline.fontSize
            )
        }
    }


}


@Preview
@Composable
fun InfoBoxPreview() {
    InfoBox(
            icon = painterResource(id = R.drawable.ic_bolt),
            iconTint = MaterialTheme.colors.primary,
            bigText = "97",
            smallText = "Fair",
            textColor = MaterialTheme.colors.titleColor
    )

}

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun InfoBoxPreviewDark() {
    InfoBox(
            icon = painterResource(id = R.drawable.ic_bolt),
            iconTint = MaterialTheme.colors.primary,
            bigText = "97",
            smallText = "Fair",
            textColor = MaterialTheme.colors.titleColor
    )

}