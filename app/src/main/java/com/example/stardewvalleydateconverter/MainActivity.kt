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

        showDate.text = convert(LocalDate.now())

        convertBtn.setOnClickListener {
            val id = dateSpinner.selectedItemPosition
            showDate.text = convertSet(id)
        }

        customBtn.setOnClickListener{
            val intent = Intent(this, Custom::class.java)
            startActivity(intent)
        }

    }

    private fun convertSet(id: Int): String {
        when(id) {
            0->{
                return convert(LocalDate.now())
            }
            1->{
                return convert(LocalDate.of(LocalDate.now().year, 1, 1 ))
            }
            2->{
                return convert(easter(LocalDate.now().year))
            }
            3->{
                return convert(LocalDate.of(LocalDate.now().year, 10, 31))
            }
            4->{
                return convert(LocalDate.of(LocalDate.now().year, 11, thanksgiving(LocalDate.now().year)))
            }
            5->{
                return convert(LocalDate.of(LocalDate.now().year, 12, 25))
            }
            else->{
                return ""
            }
        }
    }

    private fun thanksgiving(year: Int): Int { //thanksgiving! why arent these static.
        val first = LocalDate.of(year, 11, 1)
        val thanks: Int

        if (first.dayOfWeek.equals(DayOfWeek.THURSDAY)) {
            thanks = first.plusWeeks(3).dayOfMonth
        } else {
            thanks = first.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)).plusWeeks(3).dayOfMonth
        }

        return thanks
    }

    private fun easter(year: Int): LocalDate { //i dont understand this and i dont want to understand this. ask gauss.
        val a = year%19
        val b = year/100
        val c = year%100
        val d = b/4
        val e = b%4
        val f = (b+8)/25
        val g = (b-f+1)/3
        val h = (19*a+b-d-g+15)%30
        val i = c/4
        val k = c%4
        val m = (32+2*e+2*i-h-k)%7
        val n = (a+11*h+22*m)/451
        val month = (h+m-7*n+114)/31
        val day = (((h+m-(7*n)+114)%31)+1)

        return LocalDate.of(year, month, day)
    }
}
