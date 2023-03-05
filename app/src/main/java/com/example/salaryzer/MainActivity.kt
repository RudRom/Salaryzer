package com.example.salaryzer

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
//import by.dzmitry_lakisau.month_year_picker_dialog.MonthYearPickerDialog
import java.util.*
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private lateinit var textDatePicker: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        textDatePicker = findViewById(R.id.btnMonthAndYear)

        //Setting calendar
        val calendar = Calendar.getInstance()

        // Open date picker on click
        textDatePicker.setOnClickListener() {
             DatePickerDialog(this, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()

            }
        }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        textDatePicker.setText("${getTextMonth(month + 1)} $year")
    }

}

    private fun getTextMonth(month: Int) : String {
        var result = ""

        result = when (month){
            1 -> getString(R.string.JANUARY)
            2 -> R.string.FEBRUARY.toString()
            3 -> R.string.MARCH.toString()
            4 -> R.string.APRIL.toString()
            5 -> R.string.MAY.toString()
            6 -> R.string.JUNE.toString()
            7 -> R.string.JULY.toString()
            8 -> R.string.AUGUST.toString()
            9 -> R.string.SEPTEMBER.toString()
            10 -> R.string.OCTOBER.toString()
            11 -> R.string.NOVEMBER.toString()
            12 -> R.string.DECEMBER.toString()
            else -> R.string.error.toString()
        }

        return result
    }


    /*
    fun onClickCalendar(view: View) {
        intent = Intent(this, CalendarActivity::class.java)
        startActivity(intent)
    }

}

    private fun initDataPicker() {
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, day ->
            val date = makeDateString(year, month + 1, day)

    }





fun makeDateString(year: Int, month : Int, day: Int): String {
    return "$year $month $day"
}*/
