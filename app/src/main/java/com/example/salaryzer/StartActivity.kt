package com.example.salaryzer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)


    }


     fun onClickGoToMain(view: View){
        Log.d("Debug", "On click to Main is done")
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
     }
}