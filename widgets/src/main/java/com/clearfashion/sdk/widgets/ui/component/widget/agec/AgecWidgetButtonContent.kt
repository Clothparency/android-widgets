package com.clearfashion.sdk.widgets.ui.component.widget.agec

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clearfashion.sdk.widgets.ui.theme.Color
import com.clearfashion.sdk.widgets.R
import com.clearfashion.sdk.widgets.model.Product
import com.clearfashion.sdk.widgets.ui.component.LogoColor
import com.clearfashion.sdk.widgets.ui.component.LogoWithText
import com.clearfashion.sdk.widgets.ui.component.Title
import com.clearfashion.sdk.widgets.utility.getResources
import com.clearfashion.sdk.widgets.utility.hasImpact

@Composable
internal fun AgecWidgetButtonContent(product: Product) {
    val resources = getResources()
    val titleResourceID =
        if (hasImpact(product)) R.string.agec_cta
        else R.string.agec_cta_tracability_only

    Row(verticalAlignment = Alignment.Top) {
        Column(modifier = Modifier.fillMaxWidth(0.9f)) {
            Title(resources.getString(titleResourceID))
            Spacer(modifier = Modifier.size(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = resources.getString(R.string.general_verified_by),
                    color = Color.Grey300,
                    softWrap = true,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.size(6.dp))
                LogoWithText(color = LogoColor.Grey)
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
        Image(
            painter = painterResource(R.drawable.arrow),
            contentDescription = "arrow",
            modifier = Modifier
                .size(14.dp)
                .offset(y = 3.dp)
        )
    }
}