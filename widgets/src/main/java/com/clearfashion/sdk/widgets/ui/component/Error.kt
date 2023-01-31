package com.clearfashion.sdk.widgets.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clearfashion.sdk.widgets.ui.theme.Color
import com.clearfashion.sdk.widgets.utility.getResources
import com.clearfashion.sdk.widgets.R

@Composable
fun Error(
    errorMessage: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    val resources = getResources()

    Column(modifier = modifier
        .fillMaxWidth()
        .background(Color.White, shape = RoundedCornerShape(5.dp))
        .border(1.dp, Color.Grey30, shape = RoundedCornerShape(5.dp))
        .padding(16.dp)
    ) {
        Text(errorMessage, color = Color.Grey600)
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            onClick = onRetry,
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Grey600,
                contentColor = Color.White
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        ) {
            Text(resources.getString(R.string.general_action_retry))
        }
    }
}