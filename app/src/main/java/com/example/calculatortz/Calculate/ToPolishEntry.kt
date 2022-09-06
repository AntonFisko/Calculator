package com.example.calculatortz.Calculate

import java.util.*

class ToPolishEntry {
    fun reversePolishEntry(tokens: List<Variables>): List<Variables> {

        val stack = Stack<Variables>()
        val result = mutableListOf<Variables>()
        var counter = 0

        tokens.forEach {
            when (it) {
                is Variables.CalcNumber -> {
                    result.add(it)
                    counter++
                }

                is Variables.ParameterType.Plus -> {
                    while (isPrioritizedOperation(stack)
                    ) {
                        result.add(stack.pop())
                    }
                    stack.push(it)
                }

                is Variables.ParameterType.Minus -> {
                    while (isPrioritizedOperation(stack)) {
                        result.add(stack.pop())
                    }
                    stack.push(it)
                }

                is Variables.ParameterType.Multiply -> {
                    if (counter >= 2) {
                        while (isPrioritizedOperation(stack)) {
                            result.add(stack.pop())
                        }
                    }
                    stack.push(it)
                }

                is Variables.ParameterType.Divide -> {
                    if (counter >= 2) {
                        while (isPrioritizedOperation(stack)) {
                            result.add(stack.pop())
                        }
                    }
                    stack.push(it)
                }
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop())
        }

        return result
    }

    private fun isPrioritizedOperation(stack: Stack<Variables>): Boolean {
        return !stack.empty() && (
                stack.peek() is Variables.ParameterType.Multiply
                        || stack.peek() is Variables.ParameterType.Divide);
    }
}
