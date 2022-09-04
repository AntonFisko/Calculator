package com.example.calculatortz

import androidx.lifecycle.ViewModel
import java.util.*

class CalculatorViewModel : ViewModel() {

//    private val calculator = Calculator()

    fun calculate(input: String?): Int {
        return stacky(arrayOfPolcey(Infix2(input))!!)

    }


    private fun Infix2(input: String?): String {
        if (input == null) return ""
        val `in` = input.toCharArray()
        val stack: Stack<Char> = Stack<Char>()
        val out = StringBuilder()

    for (i in `in`.indices) when (`in`[i]) {
        '+', '-' -> {
            while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                out.append(' ')
                out.append(stack.pop())
            }
            out.append(' ')
            stack.push(`in`[i])
        }
        '*', '/' -> {
            out.append(' ')
            stack.push(`in`[i])
        }
        '(' -> stack.push(`in`[i])
        ')' -> {
            while (!stack.empty() && stack.peek() != '(') {
                out.append(' ')
                out.append(stack.pop())
            }
            stack.pop()
        }
        else -> out.append(`in`[i])
    }
        while (!stack.isEmpty()) out.append(' ').append(stack.pop())
        return out.toString()

    }

    private fun arrayOfPolcey(polishNotation: String): List<String>? {
        return polishNotation.split(" ").toList()
    }

    private fun stacky(tokens: List<String>): Int {

        // Initialize the stack and the variable
        val stack = Stack<String>()
        var x: Int
        var y: Int
        var result = ""
        var choice: String
        var value: Int
        val p = ""

        // Iterating to the each character
        // in the array of the string

        for (i in tokens.indices) {

            // If the character is not the special character
            // ('+', '-' ,'*' , '/')
            // then push the character to the stack
            choice =
                if (tokens[i] != "+" && tokens[i] != "-" && tokens[i] != "*" && tokens[i] != "/") {
                    stack.push(tokens[i])
                    continue
                } else {
                    // else if the character is the special
                    // character then use the switch method to
                    // perform the action
                    tokens[i]
                }
            when (choice) {
                "+" -> {

                    // Performing the "+" operation by poping
                    // put the first two character
                    // and then again store back to the stack
                    x = stack.pop().toInt()
                    y = stack.pop().toInt()
                    value = x + y
                    result = p + value
                    stack.push(result)
                }
                "-" -> {

                    // Performing the "-" operation by poping
                    // put the first two character
                    // and then again store back to the stack
                    x = stack.pop().toInt()
                    y = stack.pop().toInt()
                    value = y - x
                    result = p + value
                    stack.push(result)
                }
                "*" -> {

                    // Performing the "*" operation
                    // by poping put the first two character
                    // and then again store back to the stack
                    x = stack.pop().toInt()
                    y = stack.pop().toInt()
                    value = x * y
                    result = p + value
                    stack.push(result)
                }
                "/" -> {

                    // Performing the "/" operation by poping
                    // put the first two character
                    // and then again store back to the stack
                    x = stack.pop().toInt()
                    y = stack.pop().toInt()
                    value = y / x
                    result = p + value
                    stack.push(result)
                }
                else -> continue
            }
        }

        // Method to convert the String to integer
        return stack.pop().toInt()
    }

}
//val operators = operatorTokenizer.tokenize()
//        val poolisstNotationOperators = polishNOtationTrnsformer.transform(operator)
//        return polishNOtatioEvalutator.transform(poolisstNotationoperators)