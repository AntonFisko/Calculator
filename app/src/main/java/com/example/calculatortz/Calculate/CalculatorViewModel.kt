package com.example.calculatortz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculatortz.Calculate.Calculator


class CalculatorViewModel : ViewModel() {

    private val calculator = Calculator()

    private val expressionStream = MutableLiveData<String>()
    val expression: LiveData<String> = expressionStream

    private val expressionResultStream = MutableLiveData<Int?>()
    val expressionResult: LiveData<Int?> = expressionResultStream

    private var currentExpression: String = EMPTY_VALUE
        set(value) {
            expressionStream.value = value
            expressionResultStream.value = calculator.calculate(value)
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

    private companion object {
        private const val EMPTY_VALUE = ""
    }
}