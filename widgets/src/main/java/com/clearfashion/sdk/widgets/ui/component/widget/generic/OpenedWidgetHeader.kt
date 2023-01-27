package com.clearfashion.sdk.widgets.ui.component.widget.generic

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.ui.component.Title

@Composable
internal fun OpenedWidgetHeader(
    title: @Composable () -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.90f)
            ) {
                title()
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(R.drawable.cross),
                    contentDescription = "Close",
                    modifier = Modifier
                        .height(16.dp)
                        .clickable { onClose() }
                        .align(Alignment.CenterEnd)
                )
            }
        }
    }
}
