package com.example.calculatortz.Calculate

import android.app.Application
import androidx.lifecycle.*
import com.example.calculatortz.ExpressionRepository.ExpressionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class CalculatorViewModel(application: Application) : AndroidViewModel(application) {

    private val expressionRepository = ExpressionRepository(application)
    private val calculator = Calculator()

    private val expressionStream = MutableLiveData(EMPTY_VALUE)
    val expression: LiveData<String> = expressionStream

    private val expressionResultStream = MutableLiveData<Int?>(null)
    val expressionResult: LiveData<Int?> = expressionResultStream

    private var currentExpression: String = EMPTY_VALUE
        set(value) {
            expressionStream.value = value
            updateSavedExpression(value)
            updateCalculations(value)
            field = value
        }

    init {
        initializeFromSavedExpression()
    }

    private fun initializeFromSavedExpression() {
        viewModelScope.launch(Dispatchers.IO) {
            val expression = expressionRepository.expressionFlow.first()
            launch(Dispatchers.Main) { currentExpression = expression }
        }
    }

    private fun updateSavedExpression(value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            expressionRepository.setExpression(value)
        }
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