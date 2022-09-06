package com.example.calculatortz.Calculate

class Calculator {

    private val operatorTokenizer = OperatorTokenizer()
    private val toPolishEntry = ToPolishEntry()
    private val getResult = GetResult()

    fun calculate(expression: String): Int? {
        return try {
            val tokens = operatorTokenizer.teg(expression)
            val listPolishEntry = toPolishEntry.reversePolishEntry(tokens)

            getResult.polishEntryGetResult(listPolishEntry)
        } catch (exception: Exception) {
            null
        }
    }
}