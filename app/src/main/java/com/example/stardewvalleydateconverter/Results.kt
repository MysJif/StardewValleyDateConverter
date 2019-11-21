package com.example.stardewvalleydateconverter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Results : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val resultText = findViewById<TextView>(R.id.textResult2)
        val backBtn = findViewById<Button>(R.id.btnBack)
        val mainBtn = findViewById<Button>(R.id.btnMain2)
        val date = intent.getStringExtra("Date")

        resultText.text = date

        backBtn.setOnClickListener{
            val intent = Intent(this, custom::class.java)
            startActivity(intent)
        }

        mainBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
