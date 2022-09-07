package com.example.calculatortz.Calculate

class Calculator {

    private val operatorTokenizer = OperatorTokenizer()
    private val toPolishEntry = TokensToPolishEntry()
    private val getResult = GetResultPolishEntry()

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