package com.uxstate.heroes.presentation.screens.details.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.heroes.R
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.presentation.ui.theme.HeroesTheme
import com.uxstate.heroes.presentation.ui.theme.titleColor
import com.uxstate.heroes.util.Constants.ABOUT_TEXT_MAX_LINES
import com.uxstate.heroes.util.LocalSpacing
import timber.log.Timber
import androidx.compose.material.BottomSheetValue.Collapsed
import androidx.compose.material.BottomSheetValue.Expanded
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

        //Info Box Row
        Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = spacing.spaceExtraSmall, bottom = spacing.spaceMedium)
        ) {

            InfoBox(
                    icon = painterResource(id = R.drawable.ic_bolt),
                    iconTint = infoBoxIconColor,
                    bigText = hero.power.toString(),
                    smallText = stringResource(
                            R.string.power_label
                    ),
                    textColor = contentColor
            )

            InfoBox(
                    icon = painterResource(id = R.drawable.ic_calendar),
                    iconTint = infoBoxIconColor,
                    bigText = hero.month,
                    smallText = stringResource(R.string.month_label),
                    textColor = contentColor
            )

            InfoBox(
                    icon = painterResource(id = R.drawable.ic_cake),
                    iconTint = infoBoxIconColor,
                    bigText = hero.day,
                    smallText = stringResource(R.string.birthday_label),
                    textColor = contentColor
            )

        }

        Text(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacing.spaceSmall),
                text = stringResource(R.string.about_label),
                color = contentColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Bold
        )
        //about text
        Text(
                modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .padding(spacing.spaceSmall),
                text = hero.about,
                color = contentColor,
                fontSize = MaterialTheme.typography.body1.fontSize,
                maxLines = ABOUT_TEXT_MAX_LINES
        )


        //Ordered List Row

        Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacing.spaceSmall),
                horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OrderedList(
                    title = stringResource(id = R.string.family_label),
                    items = hero.family,
                    textColor = contentColor
            )

            OrderedList(
                    title = stringResource(R.string.abilities_label),
                    items = hero.abilities,
                    textColor = contentColor
            )
            /*Timber.i("Fraction is: $fraction")
            Timber.i("Target is: $targetValue")
            Timber.i("Current is: $currentValue")*/

            OrderedList(
                    title = stringResource(R.string.nature_types),
                    items = hero.natureTypes,
                    textColor = contentColor
            )
        }
    }
}
//extension variable to BottomSheetScaffoldState


@Preview
@Composable
fun BottomSheetContentLight() {


    BottomSheetContent(
            hero = Hero(
                    id = 45,
                    name = "Tonnie",
                    image = "",
                    about = """                    
Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,
molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum
numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium
optio, eaque rerum! Provident similique accusantium nemo autem. Veritatis
obcaecati tenetur iure eius earum ut molestias architecto voluptate aliquam
nihil, eveniet aliquid culpa officia aut! Impedit sit sunt quaerat, odit,
tenetur error, harum nesciunt ipsum debitis quas aliquid. Reprehenderit,
quia. Quo neque error repudiandae fuga? Ipsa laudantium molestias eos 
                        
                    """,
                    rating = 5.0,
                    power = 97,
                    month = "January",
                    day = "6th",
                    family = listOf("Njiri", "Muchiri"),
                    abilities = listOf("Computing", "Scrabble"),
                    natureTypes = listOf("Trees", "Water")
            )
    )

}

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun BottomSheetContentDark() {


    HeroesTheme() {
        BottomSheetContent(
                hero = Hero(
                        id = 45,
                        name = "Tonnie",
                        image = "",
                        about = """Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,
molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum
numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium
optio, eaque rerum! Provident similique accusantium nemo autem. Veritatis
obcaecati tenetur iure eius earum ut molestias architecto voluptate aliquam
nihil, eveniet aliquid culpa officia aut! Impedit sit sunt quaerat, odit,
tenetur error, harum nesciunt ipsum debitis quas aliquid. Reprehenderit,
quia. Quo neque error repudiandae fuga? Ipsa laudantium molestias eos 
                        
                    """.trimIndent(),
                        rating = 5.0,
                        power = 97,
                        month = "January",
                        day = "6th",
                        family = listOf("Njiri", "Muchiri"),
                        abilities = listOf("Computing", "Scrabble"),
                        natureTypes = listOf("Trees", "Water")
                )
        )
    }


}