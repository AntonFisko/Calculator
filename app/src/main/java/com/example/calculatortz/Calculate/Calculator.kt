package com.example.calculatortz.Calculate

import androidx.lifecycle.ViewModel
import com.example.calculatortz.GetResult

class Calculator : ViewModel() {

    private val operatorTokenizer = OperatorTokenizer()

    fun calculate(expression: String): Int {

        val tokens = operatorTokenizer.teg(expression)

        val toRPN = ToRPN()
        val listRPN = toRPN.reversePolishEntry(tokens)

        val rPNtoInt = GetResult()
        return rPNtoInt.rPnToInt(listRPN)
    }
}