package com.clearfashion.sdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.clearfashion.sdk.widgets.ClearFashionWidget
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetLanguage

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(16.dp)) {
                Column() {
                    Text(text = "This is some other content...")
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "And that too !")
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "Hey, me too ! Don't forget me ayayay")
                    Spacer(modifier = Modifier.size(16.dp))

                    /*
                        Product keys for tests:
                            - 280395902A09
                            - 141605696A06
                            - 562596899A08
                            - 141284899A08 (production countries only)
                    */
                    ClearFashionWidget(
                        brandId = "pimkie",
                        productIdentifier = "280395902A09",
                        lang = ClearFashionWidgetLanguage.FR
                    )

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