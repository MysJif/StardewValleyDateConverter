package com.example.stardewvalleydateconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showDate = findViewById<TextView>(R.id.textShowDate)
        val dateSpinner = findViewById<Spinner>(R.id.spinnerDate)
        val convertBtn = findViewById<Button>(R.id.btnConvert)
        val customBtn = findViewById<Button>(R.id.btnCustom)

        convertBtn.setOnClickListener {
            dateSpinner.
        }

    }
}
