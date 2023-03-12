package com.example.salaryzer

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
//import by.dzmitry_lakisau.month_year_picker_dialog.MonthYearPickerDialog
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private lateinit var textDatePicker: Button
    lateinit var pieChart: PieChart


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        textDatePicker = findViewById(R.id.btnMonthAndYear)
        pieChart = findViewById(R.id.pie_chart)

        //                                                      PIE CHART

        // Initialing data for pie chart
        val pieList: ArrayList<PieEntry> = ArrayList()
        val pieDataSet = PieDataSet(pieList, "Data for pie chart")

        pieList.add(PieEntry(100f, "First label"))
        pieList.add(PieEntry(90f, "Second label"))
        pieList.add(PieEntry(80f, "Third label"))
        pieList.add(PieEntry(70f, "Forth label"))

        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS, 255)
        pieDataSet.valueTextSize = 15f
        pieDataSet.valueTextColor = Color.BLACK

        // Initialing pie chart
        val pieData = PieData(pieDataSet)
        pieChart.data = pieData
        pieChart.description.text = "Pie chart description"
        pieChart.centerText = "Pie chart center text"
        pieChart.animateY(2000)


        //                                                      DATA PICKER

        //Setting calendar
        val calendar = Calendar.getInstance()

        // Open date picker on click
        textDatePicker.setOnClickListener() {
             DatePickerDialog(this, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()}
        }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        textDatePicker.setText("${getTextMonth(month + 1)} $year")
    }

}

    private fun getTextMonth(month: Int) : String {
        val result = when (month){
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

