package com.example.stardewvalleydateconverter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import java.time.LocalDate

class Custom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        val calendarWdgt = findViewById<CalendarView>(R.id.calendarView)
        val convertBtn = findViewById<Button>(R.id.btnConvert2)
        val mainBtn = findViewById<Button>(R.id.btnMain)
        var selectDate = LocalDate.now()

        calendarWdgt.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectDate = LocalDate.of(year, month+1, dayOfMonth)
        }

        convertBtn.setOnClickListener {

            val intent = Intent(this, Results::class.java)
            intent.putExtra("Date", convert(selectDate))

            startActivity(intent)
        }

        mainBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
    }
}
