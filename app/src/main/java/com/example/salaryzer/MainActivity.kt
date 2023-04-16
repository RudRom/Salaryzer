package com.example.salaryzer

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
//import by.dzmitry_lakisau.month_year_picker_dialog.MonthYearPickerDialog
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private lateinit var textDatePicker_MY: Button
    private lateinit var textDatePicker_Y: Button
    lateinit var pieChart: PieChart
    lateinit var db: DataBase
    var firstCalendarFlag = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)


        textDatePicker_MY = findViewById(R.id.btnMonthAndYear)
        textDatePicker_Y = findViewById(R.id.btnYear)
        pieChart = findViewById(R.id.pie_chart)

        setDB()

        setPieChart(ArrayList(), firstTime = true)

        //                                                      DATA PICKER

        //Setting calendars
        val calendar_MY = Calendar.getInstance()
        val calendar_Y = Calendar.getInstance()


        // Open date picker on click
        textDatePicker_MY.setOnClickListener() {
            firstCalendarFlag = true
            DatePickerDialog(
                this,
                this,
                calendar_MY.get(Calendar.YEAR),
                calendar_MY.get(Calendar.MONTH),
                calendar_MY.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        textDatePicker_Y.setOnClickListener() {
            firstCalendarFlag = false
            DatePickerDialog(
                this,
                this,
                calendar_Y.get(Calendar.YEAR),
                calendar_Y.get(Calendar.MONTH),
                calendar_Y.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        if(firstCalendarFlag){
            val arrayPairs: ArrayList<Pair<Float, String>> = ArrayList()
            arrayPairs.add(Pair(100f, "first"))
            arrayPairs.add(Pair(200f, "second"))
            setPieChart(arrayPairs, centerText = "${getTextMonth(month + 1)} $year")
        }
        else{
            textDatePicker_Y.text = year.toString()
        }

    }

    private fun setPieChart(
        pieArray: ArrayList<Pair<Float, String>>,
        firstTime: Boolean = false,
        centerText: String = ""
    ) {
        // Initialing data for pie chart
        val pieList: ArrayList<PieEntry> = ArrayList()
        val pieDataSet = PieDataSet(pieList, "")
        val legend = pieChart.getLegend()
        val pieChartParams = pieChart.layoutParams
        var heightPieChart = 320f

        if (firstTime) {
            pieList.add(PieEntry(100f, ""))

            pieDataSet.setColors(Color.GREEN)
            pieDataSet.valueTextSize = 15f
            pieDataSet.valueTextColor = Color.TRANSPARENT
            pieChart.centerText = ""
            legend.setEnabled(false)
        } else {
            for (i in pieArray) {
                pieList.add(PieEntry(i.first, i.second))
                heightPieChart += 90f
            }
            pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS, 255)
            pieDataSet.valueTextSize = 15f
            pieDataSet.valueTextColor = Color.BLACK
            pieChart.centerText = centerText

            legend.setEnabled(true)
            legend.textSize = 30f
            legend.setWordWrapEnabled(true)
            legend.formSize = 30f
        }
        // Changing heightPieChart to dp format
        val px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, heightPieChart, resources.displayMetrics)

        //Setting height of the pieChart, refering to member count
        pieChartParams.height = px.toInt()
        pieChart.setLayoutParams(pieChartParams)


        pieChart.data = PieData(pieDataSet)
        pieChart.description.text = ""
        pieChart.animateY(500)
    }

    fun setDB() {
        val fileName = "Database.db"
        val filePath = filesDir
        val path = filePath.toString() + "/" + fileName
        val file = File(path)
        val data: String

        if (!file.exists() && !file.isDirectory) {
            createDB(filePath, fileName)
        }

        data = readFile(File(filePath, fileName))

        db = DataBase(data)


    }

    fun readFile(file: File) :String{
        val inputStream = FileInputStream(file)
        val reader = InputStreamReader(inputStream)
        val bufferedReader = BufferedReader(reader)
        val data = bufferedReader.use{
            it.readLines().joinToString(separator = "\n")
        }

        return data
    }

    fun createDB(filePath: File, fileName: String) {
        val file = File(filePath, fileName)
        FileOutputStream(file).use {
            it.write(("Month Year Аванс Отпускные Больничный Зарплата Премиальные" +
                    System.getProperty("line.separator") +
                    "03 2023 300.03 400.03 500.03 600.83 700.03" +
                    System.getProperty("line.separator") +
                    "02 2023 300.02 400.02 500.02 600.02 700.02").toByteArray())
        }
    }

    fun onClickGoToAdd(view: View){
        Log.d("Debug", "On click to add is done")
        intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
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




