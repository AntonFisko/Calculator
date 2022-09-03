package com.example.calculatortz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.fragment.app.Fragment
import com.example.calculatortz.databinding.FragmentCalculatorBinding

class FragmentCalculator : Fragment(R.layout.fragment_calculator) {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding
        get() = _binding!!

    private val calculatorViewModel: CalculatorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // лиснеры кнопок
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
        binding.floatingComma.setOnClickListener { addSymbolTextView(",") }
        binding.buttonShare.setOnClickListener { addSymbolTextView("/") }
        binding.buttonMultiply.setOnClickListener { addSymbolTextView("*") }
        binding.textView2.setOnClickListener {
            if (binding.textView2.text.isNotEmpty())
                binding.textView.text = binding.textView2.text
            binding.textView2.text = ""
        }

        //удаление и очистка элеменовов
        binding.buttonRemoval.setOnClickListener {
            val str = binding.textView.text
            if (str.isNotEmpty())
                binding.textView.text = str.substring(0, str.length - 1)
        }

        binding.buttonClear.setOnClickListener { binding.textView.text = "" }

        //нажатие на равно
        binding.buttonEqually.setOnClickListener {
            val text = binding.textView.text

            var result = calculatorViewModel.calculate(text.toString())

            binding.textView2.text = result.toString()
            binding.textView.text = ""

        }

    }

    private fun addSymbolTextView(src: String) {
        binding.textView.append(src)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): FragmentCalculator {
            return FragmentCalculator().withArguments {//можно положить информацию
            }
        }
    }
}