package com.example.cybeleminigames.stonepaperscissor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.cybeleminigames.R

class RockPaper : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rockpaper)
    }

    fun clickMove(view: android.view.View) {
        val rockA = findViewById<ImageView>(R.id.rockA)
        val rockB = findViewById<ImageView>(R.id.rockB)
        val paperA = findViewById<ImageView>(R.id.paperA)
        val paperB = findViewById<ImageView>(R.id.paperB)
        val scissorA = findViewById<ImageView>(R.id.scissorA)
        val scissorB = findViewById<ImageView>(R.id.scissorB)

        rockA.visibility = View.GONE;
        paperA.visibility = View.GONE;
        scissorA.visibility = View.GONE;

        rockB.visibility = View.GONE;
        paperB.visibility = View.GONE;
        scissorB.visibility = View.GONE;



        var randA = (1..3).random()
        var randB = (1..3).random()

        if(randA == 1) {
            rockA.visibility = View.VISIBLE
        } else if(randA == 2) {
            scissorA.visibility = View.VISIBLE
        } else {
            paperA.visibility = View.VISIBLE
        }

        if(randB == 1) {
            rockB.visibility = View.VISIBLE
        } else if(randB == 2) {
            scissorB.visibility = View.VISIBLE
        } else {
            paperB.visibility = View.VISIBLE
        }
    }
}