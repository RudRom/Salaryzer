package com.example.salaryzer

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
//import by.dzmitry_lakisau.month_year_picker_dialog.MonthYearPickerDialog
import java.util.*


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

    @SuppressLint("RestrictedApi")
    private fun getTextMonth(month: Int) : String {
        var result = ""
        result = when (month){
            1 -> "Январь"
            2 -> "Февраль"
            3 -> "Март"
            4 -> "Апрель"
            5 -> "Май"
            6 -> "Июнь"
            7 -> "Июль"
            8 -> "Август"
            9 -> "Сентябрь"
            10 -> "Октябрь"
            11 -> "Ноябрь"
            12 -> "Декабрь"
            else -> "Ошибка"
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
