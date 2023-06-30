package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            val name = editTextName.text.toString()
            val heightText = editTextHeight.text.toString()
            val weightText = editTextWeight.text.toString()
            val ageText = editTextAge.text.toString()
            val height = heightText.toFloatOrNull()
            val weight = weightText.toFloatOrNull()
            val age = ageText.toIntOrNull()

            if (name.isEmpty() || height == null || weight == null || age == null
                || height <= 0 || height >= 250 || weight <= 0 || weight >= 250 || age <= 0 || age >= 150
            ) {
                textViewResult.text = "Данные введены некорректно."
            } else {
                val result = calculateResult(height, weight, age)
                textViewResult.text = "Ответ: $result"
            }
        }
    }

    private fun calculateResult(height: Float, weight: Float, age: Int): Float {
        return (height*3 * weight/4) / age
    }

}