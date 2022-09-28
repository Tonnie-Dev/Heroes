package com.uxstate.heroes.presentation.screens.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.uxstate.heroes.R
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.presentation.ui.theme.titleColor
import com.uxstate.heroes.util.LocalSpacing

@Composable
fun BottomSheetContent(
    hero: Hero,
    infoBoxIconColor: Color = MaterialTheme.colors.primary,
    sheetBackgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = MaterialTheme.colors.titleColor
) {
    val spacing = LocalSpacing.current

    Column(
            modifier = Modifier
                    .background(sheetBackgroundColor)
                    .padding(spacing.spaceMedium)
    ) {

        //Logo Row
        Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = spacing.spaceMedium),
                verticalAlignment = Alignment.CenterVertically
        ) {

            //log
            Icon(
                    painter = painterResource(id = R.drawable.ic_logo),
                    modifier = Modifier
                            .size(spacing.spaceLarge)
                            .weight(2f),
                    contentDescription = stringResource(
                            id = R.string.app_logo
                    ),
                    tint = contentColor
            )

            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            //text

            Text(
                    text = hero.name,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(8f),
                    color = contentColor,
                    fontSize = MaterialTheme.typography.h4.fontSize
            )
        }
    }
}