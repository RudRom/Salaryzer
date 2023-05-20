package com.example.salaryzer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class AddActivity : AppCompatActivity() {

    private lateinit var tvSalaryType: TextView
    private lateinit var evSalaryQuan: EditText
    private lateinit var tvSalaryTime: TextView
    private lateinit var tvYear: TextView
    private lateinit var imgArrowLeft: ImageView
    private lateinit var imgArrowRight: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        tvSalaryType = findViewById(R.id.tv_salaryType)
        evSalaryQuan = findViewById(R.id.et_salaryQuantity)
        tvSalaryTime = findViewById(R.id.tv_salaryTime)
        tvYear = findViewById(R.id.tv_year)
        imgArrowLeft = findViewById(R.id.img_arrowLeft)
        imgArrowRight = findViewById(R.id.img_arrowRight)

        imgArrowRight.setOnClickListener(){
            tvYear.text = "${tvYear.text.toString().toInt() + 1}"
        }

        imgArrowLeft.setOnClickListener(){
            tvYear.text = "${tvYear.text.toString().toInt() - 1}"
        }


    }

    fun onClickSalaryType (view: View){
        val salaryTypeView = view as TextView
        tvSalaryType.text = salaryTypeView.text
    }

    fun onClickSalaryQuan (view: View){
        val tvSalaryQuan = view as TextView
        evSalaryQuan.setText(tvSalaryQuan.text.removeSuffix(" \u20BD"))
    }

    fun onClickMonth (view: View){
        val tvMonth = view as TextView
        tvSalaryTime.text = "${tvMonth.text} ${tvYear.text} г."
    }

    fun onClickGoToMain(view: View){
        Log.d("Debug", "On click to main is done")
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}