package com.clearfashion.sdk.widgets.ui.component.widget.generic

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.clearfashion.sdk.widgets.ui.theme.Color

@Composable
internal fun WidgetSubSectionWithImage(
    @DrawableRes resourceId: Int,
    modifier: Modifier = Modifier,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: @Composable () -> Unit
) {
    WidgetSubSection(modifier = modifier) {
        Row(verticalAlignment = verticalAlignment) {
            Box(
                modifier = Modifier
                    .border(1.dp, Color.Grey30, shape = RoundedCornerShape(50))
                    .padding(12.dp)
            ) {
                Image(
                    painter = painterResource(resourceId),
                    contentDescription = "Logo"
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Column() {
                content()
            }
        }
    }
}