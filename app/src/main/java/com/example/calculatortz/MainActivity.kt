package com.example.calculatortz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatortz.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val container = binding.container.id

        supportFragmentManager.beginTransaction()
            .add(container, FragmentCalculator.newInstance())
            .commit()
    }

}