package com.elowis.calculadora

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elowis.calculadora.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var operator = 4
    // operator 1 == Sumar
    // operator 2 == Restar
    // operator 3 == Multiplicar
    // operator 4 == Divisió

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.enviarButton.setOnClickListener{
            val num1Value = binding.num1EditText.text.toString().toInt()
            val num2Value = binding.num2EditText.text.toString().toInt()

            val requestCode = 1

            val intent = Intent(this@MainActivity, CalculationResult::class.java)
            intent.putExtra("num1Value", num1Value)
            intent.putExtra("num2Value", num2Value)
            intent.putExtra("operator", operator)
            startActivityForResult(intent, requestCode)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                val result = data?.getIntExtra("result", 0)
                when (operator){
                    1 -> {
                        Toast.makeText(this, "El resultat de la suma es $result", Toast.LENGTH_SHORT).show()
                    } 2 -> {
                        Toast.makeText(this, "El resultat de la resta es $result", Toast.LENGTH_SHORT).show()
                    } 3 -> {
                        Toast.makeText(this, "El resultat de la multiplicació es $result", Toast.LENGTH_SHORT).show()
                    } 4 -> {
                        Toast.makeText(this, "El resultat de la divisió es $result", Toast.LENGTH_SHORT).show()
                    }
                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "No s'ha pogut seleccionar cap valor", Toast.LENGTH_SHORT).show()
            }
        }
    }
}