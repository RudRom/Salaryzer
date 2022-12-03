package com.example.salaryzer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)


    }


     fun onClickGoToMain(view: View){
        Log.d("Debug", "On click is done")
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
     }
}