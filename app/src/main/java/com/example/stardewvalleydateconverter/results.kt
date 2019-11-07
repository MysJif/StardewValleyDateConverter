package com.example.stardewvalleydateconverter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class results : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val resultText = findViewById<TextView>(R.id.textResult2)
        val backBtn = findViewById<Button>(R.id.btnBack)
        val mainBtn = findViewById<Button>(R.id.btnMain2)

        backBtn.setOnClickListener{
            var intent = Intent(this, custom::class.java)
            startActivity(intent)
        }

        mainBtn.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
