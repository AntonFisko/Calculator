package com.example.calculatortz

import androidx.lifecycle.ViewModel
import com.example.calculatortz.Calculate.Variables
import java.util.*


class GetResult () {

     fun rPnToInt(tokens: List<String>): Int {

        val stack = Stack<String>()
        var x: Int
        var y: Int
        var result = ""
        var choice: String
        var value: Int
        val p = ""

        for (i in tokens.indices) {
            choice =
                if (tokens[i] != "+" && tokens[i] != "-" && tokens[i] != "*" && tokens[i] != "/") {
                    stack.push(tokens[i])
                    continue
                } else {
                    tokens[i]
                }
            when (choice) {
                "+" -> {
                    x = stack.pop().toInt()
                    y = stack.pop().toInt()
                    value = x + y
                    result = p + value
                    stack.push(result)
                }
                "-" -> {
                    x = stack.pop().toInt()
                    y = stack.pop().toInt()
                    value = y - x
                    result = p + value
                    stack.push(result)
                }
                "*" -> {
                    x = stack.pop().toInt()
                    y = stack.pop().toInt()
                    value = x * y
                    result = p + value
                    stack.push(result)
                }
                "/" -> {
                    x = stack.pop().toInt()
                    y = stack.pop().toInt()
                    value = y / x
                    result = p + value
                    stack.push(result)
                }
                else -> continue
            }
        }
        return stack.pop().toInt()
    }
}