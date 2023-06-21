package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {

    private lateinit var minhaViewModelQueEuCrieiAgoraPouco : MinhasViewModelBemSimples

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            minhaViewModelQueEuCrieiAgoraPouco = ViewModelProvider(this).get(MinhasViewModelBemSimples::class.java)

        setContent {
                Main(minhaViewModelQueEuCrieiAgoraPouco)
            }
        }
    }



@Composable
fun Main(umaViewModel: MinhasViewModelBemSimples) {
    var contadorNaView by remember {
        mutableStateOf(0)
    }

    val contadorProvenienteDaMinhaModelView by umaViewModel.contadorDaViewPublico.collectAsState()

    Surface(
        color = Color(0xFFe6f8b1), // Cor da tela
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .padding(30.dp),
            text = "     Model View View Model ",
            color = Color(0xFF4f784e),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif

        )



        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    contadorNaView += 1
                    umaViewModel.incrementaContador()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .height(48.dp),
                contentPadding = PaddingValues(8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFf6b794))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Aumentar",
                        tint = Color(0xFF4f784e),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "Aumentar",
                        color = Color(0xFF395039),
                        fontSize = 16.sp
                    )
                }
            }


            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    contadorNaView -= 1
                    umaViewModel.decrementoContador()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .height(48.dp),
                contentPadding = PaddingValues(8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFf6b794))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.Clear,
                        contentDescription = "Decrementar",
                        tint = Color(0xFF4f784e),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "Decrementar",
                        color = Color(0xFF395039),
                        fontSize = 16.sp
                    )
                }
            }

            Text(
                text = "Valor do contador = $contadorNaView",
                modifier = Modifier.padding(vertical = 10.dp),
                color = Color(0xFF4f784e),
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif
            )
            Text(
                text = "Valor do Contador da ViewModel = $contadorProvenienteDaMinhaModelView",
                modifier = Modifier.padding(vertical = 10.dp),
                color = Color(0xFF4f784e),
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = "Feito por Bruno Portugal       RM:22295",
                modifier = Modifier.padding(16.dp),
                color = Color.Black,
                fontSize = 14.sp,
                fontStyle = FontStyle.Italic
            )
        }
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
       // Main()
    }
