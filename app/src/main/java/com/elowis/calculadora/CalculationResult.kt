package com.elowis.calculadora

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elowis.calculadora.databinding.ActivityCalculationResultBinding


class CalculationResult : AppCompatActivity() {

    lateinit var binding: ActivityCalculationResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculationResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val result1: Int = intent.getIntExtra("num1Value", 0)
        val result2: Int = intent.getIntExtra("num2Value", 0)
        val operator: Int = intent.getIntExtra("operator", 0)
        binding.num1Value.text = result1.toString()
        binding.num2Value.text = result2.toString()
        binding.resultButton.setOnClickListener{
            val resultIntent = Intent()
            when (operator) {
                1 -> {
                    var sum: Int = calculateSum(result1, result2)
                    resultIntent.putExtra("result", sum)
                }
                2 -> {
                    var rest: Int = calculateRest(result1, result2)
                    resultIntent.putExtra("result", rest)
                }
                3 -> {
                    var mult: Int = calculateMult(result1, result2)
                    resultIntent.putExtra("result", mult)
                }
                4 -> {
                    var div: Int = calculateDiv(result1, result2)
                    resultIntent.putExtra("result", div)
                }
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    fun calculateSum(result1: Int, result2: Int): Int {
        return result1 + result2
    }

    fun calculateRest(result1: Int, result2: Int): Int {
        return result1 - result2
    }

    fun calculateMult(result1: Int, result2: Int): Int {
        return result1 * result2
    }

    fun calculateDiv(result1: Int, result2: Int): Int {
        return result1 / result2
    }
}