package com.example.stardewvalleydateconverter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showDate = findViewById<TextView>(R.id.textShowDate)
        val dateSpinner = findViewById<Spinner>(R.id.spinnerDate)
        val convertBtn = findViewById<Button>(R.id.btnConvert2)
        val customBtn = findViewById<Button>(R.id.btnCustom)

        convertBtn.setOnClickListener {
            var id = dateSpinner.selectedItemPosition
            showDate.text = convertSet(id)
        }

        customBtn.setOnClickListener{
            var intent = Intent(this, custom::class.java)
            startActivity(intent)
        }

    }

    fun convertSet(id: Int): String {
        when(id) {
            0->{
                return convert(LocalDate.now())
            }
            1->{
                return convert(LocalDate.of(LocalDate.now().year, 1, 1 ))
            }
            2->{
                return convert(Easter(LocalDate.now().year))
            }
            3->{
                return convert(LocalDate.of(LocalDate.now().year, 10, 31))
            }
            4->{
                return convert(LocalDate.of(LocalDate.now().year, 11, Thanksgiving(LocalDate.now().year)))
            }
            5->{
                return convert(LocalDate.of(LocalDate.now().year, 12, 25))
            }
            else->{
                return ""
            }
        }
    }

    fun Thanksgiving(year: Int): Int {
        var first = LocalDate.of(year, 11, 1)

        if (first.dayOfWeek.equals(DayOfWeek.THURSDAY)) {
            return first.plusWeeks(3).dayOfMonth
        } else {
            return first.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)).plusWeeks(3).dayOfMonth
        }
    }

    fun Easter(year: Int): LocalDate {
        var a = year%19
        var b = year/100
        var c = year%100
        var d = b/4
        var e = b%4
        var f = (b+8)/25
        var g = (b-f+1)/3
        var h = (19*a+b-d-g+15)%30
        var i = c/4
        var k = c%4
        var m = (32+2*e+2*i-h-k)%7
        var n = (a+11*h+22*m)/451
        var month = (h+m-7*n+114)/31
        var day = (((h+m-(7*n)+114)%31)+1)

        return LocalDate.of(year, month, day)
    }
}
