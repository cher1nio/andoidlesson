package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val btn_clearly: Button = findViewById(R.id.btn_clear)
       val number:EditText = findViewById(R.id.numbers)
       val rez:TextView = findViewById(R.id.numbers_rez)

        val plus:Button = findViewById(R.id.btn_plus)
        val minus:Button = findViewById(R.id.btn_minus)
        val multiplication:Button = findViewById(R.id.btn_mnozh)
        val division:Button = findViewById(R.id.btn_podil)
        val equal:Button = findViewById(R.id.btn_rovno)

        val switchactivityy:Button = findViewById(R.id.btn_showsecondactivity)

        var firstnumber: Double = 0.0
        var secondnumber: Double
        var rezult: Double = 0.0
        var x: Int = 0

        plus.setOnClickListener{
            if(rez.text.isEmpty()) {
                firstnumber = number.text.toString().toDouble()
            }
            number.text.clear()
            x = 1
       }
        minus.setOnClickListener{
            if(rez.text.isEmpty()) {
                firstnumber = number.text.toString().toDouble()
            }
            number.text.clear()
            x = 2
        }
        multiplication.setOnClickListener{
            if(rez.text.isEmpty()) {
                firstnumber = number.text.toString().toDouble()
            }
            number.text.clear()
            x = 3
        }
        division.setOnClickListener{
            if(rez.text.isEmpty()) {
                firstnumber = number.text.toString().toDouble()
            }
            number.text.clear()
            x = 4
        }
        equal.setOnClickListener{
            secondnumber = number.text.toString().toDouble()
            when(x){
                1 -> rezult = firstnumber + secondnumber
                2 -> rezult = firstnumber - secondnumber
                3 -> rezult = firstnumber * secondnumber
                4 -> rezult = firstnumber / secondnumber
            }
            firstnumber = rezult

            val LongRes = rezult.toLong()
            if (rezult == LongRes.toDouble())
            {
                rez.text = LongRes.toString()
            }
            else
            {
                rez.text = rezult.toString()
            }
            number.text.clear()
        }


       btn_clearly.setOnClickListener{
          number.text.clear()
           rez.text = ""
           rezult = 0.0
       }

        switchactivityy.setOnClickListener{
            startActivity(Intent(this, MainActivity2::class.java).putExtra("results" , rezult.toString()))
        }



    }


}