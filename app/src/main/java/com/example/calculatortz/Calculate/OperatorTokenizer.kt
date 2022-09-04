package com.example.calculatortz.Calculate

import java.util.*

sealed class Variables {
    sealed class CalcNumber {}

    sealed class ParameterType {
        class Pius : ParameterType()
        class Minus : ParameterType()
        class Divide : ParameterType()
        class Multiply : ParameterType()
    }
}

class OperatorTokenizer {

    fun teg(parameter: String): List<Variables> {
        var i = 0

        val listVariables = mutableListOf<Variables>()

        val iterator = parameter.length
        while (i <= iterator-1 ) {
            if (parameter[i].isDigit()) {
                i++
                continue
            } else {

                listVariables.add(Variables.CalcNumber)
                when (parameter[i]) {
                    '*' -> listVariables.add(Variables.ParameterType.Multiply)
                    '/' -> listVariables.add(Variables.ParameterType.Divide)
                    '+' -> listVariables.add(Variables.ParameterType.Pius)
                    '-' -> listVariables.add(Variables.ParameterType.Minus)
                }
            }
        }
        return listVariables
    }
}
//}
//return listParameter
//}

//        }}
//        val str: ParameterType
//        val stack: Stack<Char> = Stack<Char>()
//        val out = StringBuilder()
//
//        for (i in 0 until iterator) {
//            when (str) {
//                is ParameterType.Minus && ParameterType.Pius
//                -> {
//                    while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
//                        out.append(' ')
//                        out.append(stack.pop())
//                    }
//                    out.append(' ')
//                    stack.push(str[i])
//                }
//                is ParameterType.Multiply && ParameterType.Share
//                -> {
//                    out.append(' ')
//                    stack.push(str[i])
//                }
////            '(' -> stack.push(str[i])
////            ')' -> {
////                while (!stack.empty() && stack.peek() != '(') {
////                    out.append(' ')
////                    out.append(stack.pop())
////                }
////                stack.pop()
////            }
//                else -> out.append(str[i])
//            }
//            while (!stack.isEmpty()) out.append(' ').append(stack.pop())
//            return out.toString()
//        }
//    }
//}
//binding.floatingComma.setOnClickListener { addSymbolTextView(",") }
//binding.buttonShare.setOnClickListener { addSymbolTextView("/") }
//binding.buttonMultiply.setOnClickListener { addSymbolTextView("*") }