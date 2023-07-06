package com.example.controlroleforschools

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class ClassesActivity : AppCompatActivity() {
    lateinit var cardViewF1N: CardView
    lateinit var cardViewF1s: CardView
    lateinit var cardViewF2N: CardView
    lateinit var cardViewF2s: CardView
    lateinit var cardViewF3N: CardView
    lateinit var cardViewF3s: CardView
    lateinit var cardViewF4N: CardView
    lateinit var cardViewF4s: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classes)
        cardViewF1N = findViewById(R.id.Form1N)
        cardViewF1s = findViewById(R.id.F1s)
        cardViewF2N = findViewById(R.id.F2N)
        cardViewF2s = findViewById(R.id.F2s)
        cardViewF3N = findViewById(R.id.F3N)
        cardViewF3s = findViewById(R.id.F3s)
        cardViewF4N = findViewById(R.id.F4N)
        cardViewF4s = findViewById(R.id.F4s)



        cardViewF1N.setOnClickListener {
            startActivity(Intent(applicationContext, F1N_Activity::class.java))
        }
        cardViewF1s.setOnClickListener {
            startActivity(Intent(applicationContext, F1s_Activity::class.java))
        }
        cardViewF2N.setOnClickListener {
            startActivity(Intent(applicationContext, F2N_Activity::class.java))
        }
        cardViewF2s.setOnClickListener {
            startActivity(Intent(applicationContext, F2s_Activity::class.java))
        }
        cardViewF3N.setOnClickListener {
            startActivity(Intent(applicationContext, F3N_Activity::class.java))
        }
        cardViewF3s.setOnClickListener {
            startActivity(Intent(applicationContext, F3s_Activity::class.java))
        }
        cardViewF4N.setOnClickListener {
            startActivity(Intent(applicationContext, F4N_Activity::class.java))
        }
        cardViewF4s.setOnClickListener {
            startActivity(Intent(applicationContext, F4s_Activity::class.java))
        }
    }

}

