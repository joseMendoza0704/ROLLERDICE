package com.example.ROLLERDICE

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ROLLERDICE.ui.theme.ROLLERDICETheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults


import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerApp()


        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DiceRollerApp(){

    DiceWithAndImage()

}


@ExperimentalMaterial3Api
@Composable
fun DiceWithAndImage (modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)){
    var result by remember {
        mutableIntStateOf(1)
    }

    var mensaje  :String by remember { mutableStateOf("") }

    var predic :String by remember { mutableStateOf("") }

    val imageResource = when (result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    TopAppBar(
        title = {
            Text(
                text = "ROLLERDICE",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },


    )

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(imageResource), contentDescription = "1")
        OutlinedTextField(
            value = predic,
            onValueChange = { predic = it },
            label = { Text("Prediccion") }
        )
        Button(onClick = { result = (1..6).random()
            mensaje = if (predic.toIntOrNull()== result){
                "Haz acertado,$result"
            } else  {
                "intentelo de nuevo,$result"
            }

        }) {

            Text(stringResource(R.string.ROLLERDICE))
        }

        Text(text = mensaje, style = MaterialTheme.typography.bodyLarge)

    }



    }






