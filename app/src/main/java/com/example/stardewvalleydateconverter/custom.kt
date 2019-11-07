package com.example.stardewvalleydateconverter

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class custom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        val calendarWdgt = findViewById<CalendarView>(R.id.calendarView)
        val convertBtn = findViewById<Button>(R.id.btnConvert2)
        val mainBtn = findViewById<Button>(R.id.btnMain)

        mainBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
    }
}
