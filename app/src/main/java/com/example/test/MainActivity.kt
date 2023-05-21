package com.example.test

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.ui.theme.TestTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
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

        Column() {
            Button(onClick = {
                contadorNaView = contadorNaView + 1
                umaViewModel.incrementaContador()
            }) {
                Text(text = "Incrementa contador")
            }

            Button(onClick = {
                contadorNaView = contadorNaView - 1
                umaViewModel.decrementoContador()
            })

            {
                Text(text = "Decrementar contador")
            }
            Text(text = "Valor do contador = $contadorNaView")
            Text(text = "Valor do Contador Controlado pela ViewModel = $contadorProvenienteDaMinhaModelView")
        }

    }
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
       // Main()
    }
