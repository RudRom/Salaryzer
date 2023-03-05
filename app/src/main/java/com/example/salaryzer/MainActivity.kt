package com.example.salaryzer

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.res.TypedArrayUtils.getString
import java.util.*

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private lateinit var textDatePicker : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        textDatePicker = findViewById(R.id.btnMonthAndYear)

        initDataPicker()

        val calendar = Calendar.getInstance()

        }

    }

    private fun initDataPicker() {
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, day ->
            val date = makeDateString(year, month + 1, day)

    }

    private fun updateLable(calendar: Calendar) {

    }

    fun getTextDate(calendar : Calendar) : String {
        var result = ""

        when (calendar.time.toString().substring(4,7)){
            "Jan" -> result = R.string.JANUARY.toString()
            "Feb" -> result = R.string.FEBRUARY.toString()
            "Mar" -> result = R.string.MARCH.toString()
            "Apr" -> result = R.string.APRIL.toString()
            "May" -> result = getString(R.string.MAY)
            "Jun" -> result = getString(R.string.JUNE)
            "Jul" -> result = getString(R.string.JULY)
            "Aug" -> result = getString(R.string.AUGUST)
            "Sep" -> result = getString(R.string.SEPTEMBER)
            "Oct" -> result = getString(R.string.OCTOBER)
            "Nov" -> result = getString(R.string.NOVEMBER)
            "Dec" -> result = getString(R.string.DECEMBER)
            else -> result = getString(R.string.error)
        }

        return result + " " + calendar.time.toString().substring(calendar.time.toString().length - 4,calendar.time.toString().length)
    }

    fun onClickCalendar(view: View){
        intent = Intent(this, CalendarActivity::class.java)
        startActivity(intent)
    }

fun makeDateString(year: Int, month : Int, day: Int): String {
    return "$year $month $day"
}
