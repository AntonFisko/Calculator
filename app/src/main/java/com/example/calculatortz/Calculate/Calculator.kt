package com.example.calculatortz.Calculate

import androidx.lifecycle.ViewModel
import com.example.calculatortz.GetResult

class Calculator : ViewModel() {

    private val operatorTokenizer = OperatorTokenizer()
    private val toRPN = ToRPN()
    private val getResult = GetResult()

    fun calculate(expression: String): Int? {
        return try {
            val tokens = operatorTokenizer.teg(expression)
            val listRPN = toRPN.reversePolishEntry(tokens)

            getResult.rPnToInt(listRPN)
        } catch (exception: Exception) {
            null
        }
    }
}