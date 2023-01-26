package com.clearfashion.sdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clearfashion.sdk.widgets.ClearFashionWidget
import com.clearfashion.sdk.widgets.ClearFashionWidgetType
import com.clearfashion.sdk.widgets.ClearFashionWidgetLanguage
import com.clearfashion.sdk.widgets.ui.theme.Color

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Grey20)
                .padding(16.dp)) {
                Column() {
                    Text(text = "This is some other content...")
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "And that too !")
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "Hey, me too ! Don't forget me ayayay")
                    Spacer(modifier = Modifier.size(16.dp))

                    // Ça c'est le widget :
                    ClearFashionWidget(lang = ClearFashionWidgetLanguage.FRENCH)

                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "This is some other content...")
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "And that too !")
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "Hey, me too ! Don't forget me ayayay")
                }
            }
        }
    }
}