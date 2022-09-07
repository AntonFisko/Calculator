package com.example.calculatortz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.calculatortz.Calculate.CalculatorViewModel
import com.example.calculatortz.databinding.FragmentCalculateConstrBinding


class FragmentCalculator : Fragment(R.layout.fragment_calculate_constr) {

    private lateinit var binding: FragmentCalculateConstrBinding

    private val calculatorViewModel: CalculatorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculateConstrBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // OnClickListener Button
        binding.buttonZero.setOnClickListener { addSymbolTextView("0") }
        binding.buttonOne.setOnClickListener { addSymbolTextView("1") }
        binding.buttonTwo.setOnClickListener { addSymbolTextView("2") }
        binding.buttonThree.setOnClickListener { addSymbolTextView("3") }
        binding.buttonFour.setOnClickListener { addSymbolTextView("4") }
        binding.buttonFive.setOnClickListener { addSymbolTextView("5") }
        binding.buttonSix.setOnClickListener { addSymbolTextView("6") }
        binding.buttonSeven.setOnClickListener { addSymbolTextView("7") }
        binding.buttonEight.setOnClickListener { addSymbolTextView("8") }
        binding.buttonNine.setOnClickListener { addSymbolTextView("9") }
        binding.buttonMinus.setOnClickListener { addSymbolTextView("-") }
        binding.buttonPlus.setOnClickListener { addSymbolTextView("+") }
        binding.buttonShare.setOnClickListener { addSymbolTextView("/") }
        binding.buttonMultiply.setOnClickListener { addSymbolTextView("*") }

        calculatorViewModel.expression.observe(viewLifecycleOwner) { expression ->
            binding.expressionView.text = expression
        }

        calculatorViewModel.expressionResult.observe(viewLifecycleOwner) { expressionResult ->
            val resultExpression = expressionResult?.toString() ?: "Wrong expression"
            binding.resultExpressionView.text = resultExpression
        }

        binding.buttonRemoval.setOnClickListener {
            calculatorViewModel.removeLastSymbol()
        }

        binding.buttonClear.setOnClickListener {
            calculatorViewModel.clearExpression()
        }
    }

    private fun addSymbolTextView(symbol: String) {
        calculatorViewModel.addSymbol(symbol)
    }

    companion object {
        fun newInstance(): FragmentCalculator {
            return FragmentCalculator()
        }
    }
}