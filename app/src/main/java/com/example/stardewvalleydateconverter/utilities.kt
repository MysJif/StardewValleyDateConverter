package com.example.stardewvalleydateconverter

import java.time.LocalDate

//full conversion method
fun convert(now: LocalDate): String {
    var dayOfYear = now.dayOfYear //get the date of the year out of 365/366
    val dayOfSeason: Int
    val dayOfWeek: String
    val season: String

    dayOfYear = springAdjust(dayOfYear) //adjust date of year so that it starts with spring

    dayOfYear = convertSdDay(dayOfYear, now.isLeapYear)

    dayOfSeason = sdDayOfSeason(dayOfYear, sdSeason(dayOfYear))

    season = seasonString(sdSeason(dayOfYear))

    dayOfWeek = dayOfWeek(dayOfSeason)

    return "$dayOfWeek, the $dayOfSeason of $season"

}

fun springAdjust(day: Int): Int { //adjusts day of year to start in spring
    var day2: Int = day
    if (day < 79) {
        day2+=286 //before spring
    } else {
        day2-=78 //after spring
    }
    return day2
}

fun convertSdDay(day: Int, leap: Boolean): Int { //converts gregorian to stardew valley
    val length: Int
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
    when (month) {
        1 -> {
            return day
        } //spring
        2 -> {
            return day - 28
        } //summer
        3 -> {
            return day - 56
        } //fall
        else -> {
            return day - 84
        } //winter
    }
}

fun seasonString(month: Int): String {
    when (month) {
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
    when (day) {
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