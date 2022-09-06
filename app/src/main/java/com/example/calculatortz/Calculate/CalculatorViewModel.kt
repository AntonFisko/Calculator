package com.example.calculatortz.Calculate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CalculatorViewModel : ViewModel() {

    private val calculator = Calculator()

    private val expressionStream = MutableLiveData<String>()
    val expression: LiveData<String> = expressionStream

    private val expressionResultStream = MutableLiveData<Int?>()
    val expressionResult: LiveData<Int?> = expressionResultStream

    private var currentExpression: String = EMPTY_VALUE
        set(value) {
            expressionStream.value = value

            updateCalculations(value)
            field = value
        }


    fun addSymbol(symbol: String) {
        currentExpression += symbol
    }

    fun clearExpression() {
        currentExpression = EMPTY_VALUE
    }

    fun removeLastSymbol() {
        currentExpression = currentExpression.dropLast(1)
    }

    private fun updateCalculations(expression: String) {
        viewModelScope.launch(Dispatchers.Default) {
            val result = calculator.calculate(expression)
            launch(Dispatchers.Main) { expressionResultStream.value = result }
        }
    }

    private companion object {
        private const val EMPTY_VALUE = ""
    }
}