package com.example.test

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MinhasViewModelBemSimples : ViewModel(){

   private val _contadorDaViewModel =  MutableStateFlow (0)
     val contadorDaViewPublico: StateFlow<Int> get() = _contadorDaViewModel

    fun incrementaContador(){
        _contadorDaViewModel.value = _contadorDaViewModel.value + 1
    }
    fun decrementoContador(){
        _contadorDaViewModel.value = _contadorDaViewModel.value + 1
    }

}