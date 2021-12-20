package com.example.cybeleminigames.fingerbattle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.cybeleminigames.R

class FingerBattle : AppCompatActivity(), View.OnClickListener {
    lateinit var title: TextView
    lateinit var startButton: Button
    lateinit var fingerPlayer1: View
    lateinit var fingerPlayer2: View

    val player: ArrayList<View> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finger_battle)

        title = findViewById(R.id.fingerTitle)
        startButton = findViewById(R.id.fingerButton)

        player.add(findViewById(R.id.fingerPlayer1))
        player.add(findViewById(R.id.fingerPlayer2))

        player[0].setOnClickListener(this)
        player[1].setOnClickListener(this)
    }

    fun fingerStart(view: android.view.View) {
        title.visibility = View.GONE
        startButton.visibility = View.GONE
    }

    override fun onClick(view: View?) {
        when(view) {
            player[0] -> actionTaker(0)
            player[1] -> actionTaker(1)
        }
    }

    private fun actionTaker(i: Int) {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        val parms: ViewGroup.LayoutParams = player[i].layoutParams
        parms.height += 100
        player[i].layoutParams = parms
    }
}
