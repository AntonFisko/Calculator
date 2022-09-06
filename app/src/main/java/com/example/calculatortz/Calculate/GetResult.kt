package com.example.calculatortz.Calculate

import java.util.*

class GetResult {
    fun polishEntryGetResult(tokens: List<Variables>): Int {

        val stack = Stack<Variables.CalcNumber>()
        var x: Int
        var y: Int

        for (token in tokens) {
            when (token) {
                is Variables.CalcNumber -> {
                    stack.push(token)
                }
                is Variables.ParameterType.Plus -> {
                    x = stack.pop().value
                    y = stack.pop().value
                    val value = x + y
                    stack.push(Variables.CalcNumber(value))
                }
                is Variables.ParameterType.Minus -> {
                    x = stack.pop().value
                    y = stack.pop().value
                    val value = y - x
                    stack.push(Variables.CalcNumber(value))
                }
                is Variables.ParameterType.Multiply -> {
                    x = stack.pop().value
                    y = stack.pop().value
                    val value = x * y
                    stack.push(Variables.CalcNumber(value))
                }
                is Variables.ParameterType.Divide -> {
                    x = stack.pop().value
                    y = stack.pop().value
                    val value = y / x
                    stack.push(Variables.CalcNumber(value))
                }
            }
        }
        return stack.pop().value
    }
}