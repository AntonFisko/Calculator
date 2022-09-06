package com.example.calculatortz.Calculate

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CalculatorTest(
    private val expression: String,
    private val expectedValue: Int?
) {

    private val calculator = Calculator()

    @Test
    fun testCalculate() {
        val value = calculator.calculate(expression)
        Assert.assertEquals(value, expectedValue)
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            return listOf(
                arrayOf("", null),
                arrayOf("1", 1),
                arrayOf("1+", null),
                arrayOf("1+1", 2),
                arrayOf("2+2*2", 6),
                arrayOf("2*2+8", 12),
                arrayOf("865*358/65-653+644/56", 4100),
                arrayOf("252/6*93+65*65", 8131)
            )
        }
    }
}
