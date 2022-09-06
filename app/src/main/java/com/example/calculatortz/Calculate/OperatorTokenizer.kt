package com.example.calculatortz.Calculate

sealed class Variables {
    class CalcNumber(val value: Int) : Variables()

    sealed class ParameterType : Variables() {
        class Plus : ParameterType()
        class Minus : ParameterType()
        class Divide : ParameterType()
        class Multiply : ParameterType()
    }
}

class OperatorTokenizer {

    fun teg(parameter: String): List<Variables> {
        var i = 0
        var dropWhile = 0
        var writingNumber = ""
        val listVariables = mutableListOf<Variables>()

        if (parameter.startsWith("-", false)) {
            writingNumber += parameter[0]
            i++
        }

        val iterator = parameter.length
        while (i <= iterator - 1) {
            if (parameter[i].isDigit()) {
                writingNumber += parameter[i]
                dropWhile = 0
                i++
                if (i == iterator) (
                        listVariables.add(Variables.CalcNumber(writingNumber.toInt()))
                        )
                continue
            } else {
                if (dropWhile == 0) {

                    dropWhile++
                    listVariables.add(Variables.CalcNumber(writingNumber.toInt()))
                    writingNumber = ""
                    when (parameter[i]) {
                        '*' -> listVariables.add(Variables.ParameterType.Multiply())
                        '/' -> listVariables.add(Variables.ParameterType.Divide())
                        '+' -> listVariables.add(Variables.ParameterType.Plus())
                        '-' -> listVariables.add(Variables.ParameterType.Minus())
                    }
                } else {
                    writingNumber += parameter[i]
                }
                i++
            }
        }
        return listVariables
    }
}