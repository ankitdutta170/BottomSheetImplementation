package com.example.bottomsheetimplementation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bottomsheetimplementation.ui.theme.BottomSheetImplementationTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomSheetImplementationTheme {
                val scope = rememberCoroutineScope()
                val bottomSheetSate =
                    rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
                // A surface container using the 'background' color from the theme

                ModalBottomSheetLayout(
                    sheetState = bottomSheetSate,
                    sheetContent = {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(text = "Text 1")
                            Text(text = "Text 2")
                            Text(text = "Text 3")
                            Text(text = "Text 4")
                            Text(text = "Text 5")
                            Text(text = "Text 6")
                            Text(text = "Text 7")
                            Text(text = "Text 8")
                            Text(text = "Text 9")
                            Text(text = "Text 10")
                        }
                    },
                    sheetShape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
                    sheetElevation = 12.dp
                ) {
                    MainContent(scope = scope, bottomSheetState = bottomSheetSate)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainContent(scope: CoroutineScope, bottomSheetState: ModalBottomSheetState) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    scope.launch {
                        bottomSheetState.show()
                    }
                }, modifier = Modifier
                    .height(50.dp)
            ) {
                Text(text = "Click me (Expand me)")

            }
        }




}

@Composable
fun BottomSheet() {


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomSheetImplementationTheme {
        Greeting("Android")
    }
}