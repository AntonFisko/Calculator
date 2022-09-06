package com.example.calculatortz.Calculate

import java.util.*

class ToRPN() {
    fun reversePolishEntry(tokens: List<Variables>): List<String> {

        val stack = Stack<String>()
        val out = StringBuilder()
        var counter = 0

        tokens.forEach {
            when (it) {
                is Variables.CalcNumber -> {
                    out.append(it.value)
                    counter++
                }

                is Variables.ParameterType.Pius -> {
                    while (!stack.empty() && (stack.peek() == "*" || stack.peek() == "/")) {
                        out.append(' ')
                        out.append(stack.pop())
                    }
                    out.append(' ')
                    stack.push(it.sign)
                }
                is Variables.ParameterType.Minus -> {
                    while (!stack.empty() && (stack.peek() == "/" || stack.peek() == "*")) {
                        out.append(' ')
                        out.append(stack.pop())
                    }
                    out.append(' ')
                    stack.push(it.sign)
                }
                is Variables.ParameterType.Multiply -> {
                    if(counter>=2){ while (!stack.empty() && (stack.peek() == "*" || stack.peek() == "/")){
                        out.append(' ')
                        out.append(stack.pop())
                    }}
                        out.append(' ')
                    stack.push(it.sign)
                }
                is Variables.ParameterType.Divide -> {
                    if(counter>=2){ while (!stack.empty() && (stack.peek() == "*" || stack.peek() == "/")){
                        out.append(' ')
                        out.append(stack.pop())
                    }}
                    out.append(' ')
                    stack.push(it.sign)
                }

            }
        }
        while (!stack.isEmpty()) out.append(' ').append(stack.pop())
        val polishNotation = out.toString()
        val listPolishNotation = polishNotation.split(" ").toList()
        return listPolishNotation
    }
}
