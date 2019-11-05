package com.example.stardewvalleydateconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class custom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)
    }


    //full conversion method
    fun convert(now: LocalDate): String {
        var dayOfYear = now.dayOfYear //get the date of the year out of 365/366
        var dayOfSeason: Int
        var dayOfWeek: String
        var season: String

        dayOfYear = springAdjust(dayOfYear) //adjust date of year so that it starts with spring

        dayOfYear = convertSdDay(dayOfYear, now.isLeapYear)

        dayOfSeason = sdDayOfSeason(dayOfYear, sdSeason(dayOfYear))

        season = seasonString(sdSeason(dayOfYear))

        dayOfWeek = dayOfWeek(dayOfSeason)

        return "$dayOfWeek, the $dayOfSeason of $season"

    }

    fun springAdjust(day: Int): Int { //adjusts day of year to start in spring
        if (day < 79) {
            return day+286 //before spring
        } else {
            return day-78 //after spring
        }
    }

    fun convertSdDay(day: Int, leap: Boolean): Int { //converts gregorian to stardew valley
        var length: Int
        if (leap) {
            length = 366
        } else {
            length = 365
        }

        return (Math.ceil((day.toDouble() / length) * 112).toInt())
    }

    fun sdSeason(day: Int): Int { //finds which of the 4 months the dayofyear is in
        if (day <= 28) {
            return 1 //spring
        } else if (day <= 56) {
            return 2 //summer
        } else if (day <= 84) {
            return 3 //fal
        } else {
            return 4 //winter
        }
    }

    fun sdDayOfSeason(day: Int, month: Int): Int { //finds the day of the month the day of year it is
        if (month ==1) {
            return day //spring
        } else if (month == 2) {
            return day-28 //summer
        } else if (month == 3) {
            return day-56 //fall
        } else {
            return day-84 //winter
        }
    }

    fun seasonString(month: Int): String {
        return when (month) {
            1 -> {
                return "Spring"
            }
            2 -> {
                return "Summer"
            }
            3 -> {
                return "Fall"
            }
            4 -> {
                return "Winter"
            }
            else -> return ""
        }
    }

    fun dayOfWeek(day: Int): String {
        return when (day) {
            1, 8, 15, 22 -> {
                return "Monday"
            }
            2, 9, 16, 23 -> {
                return "Tuesday"
            }
            3, 10, 17, 24 -> {
                return "Wednesday"
            }
            4, 11, 18, 25 -> {
                return "Thursday"
            }
            5, 12, 19, 26 -> {
                return "Friday"
            }
            6, 13, 20, 27 -> {
                return "Saturday"
            }
            7, 14, 21, 28 -> {
                return "Sunday"
            }
            else -> return ""
        }
    }
}
