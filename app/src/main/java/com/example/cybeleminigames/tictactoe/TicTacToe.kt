package com.example.cybeleminigames.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.cybeleminigames.R

class TicTacToe : AppCompatActivity() {

    var counter = 0
    var gameStarted: Boolean = false;
    private val visited = arrayOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictactoe);

        val ttButtons = arrayOf<Button>(
            findViewById(R.id.button_1),
            findViewById(R.id.button_2),
            findViewById(R.id.button_3),
            findViewById(R.id.button_4),
            findViewById(R.id.button_5),
            findViewById(R.id.button_6),
            findViewById(R.id.button_7),
            findViewById(R.id.button_8),
            findViewById(R.id.button_9)
        )


        val playerOneText: TextView = findViewById(R.id.player1_text)
        val playerTwoText: TextView = findViewById(R.id.player2_text)



        for(i in 0..8) {
            ttButtons[i].setOnClickListener {

                if(!gameStarted || visited[i] != 0) {
                    return@setOnClickListener
                }

                if(counter % 2 == 0) {
                    ttButtons[i].text = "O"
                    visited[i] = 1

                    playerTwoText.setBackgroundColor(ContextCompat.getColor
                        (this, R.color.our_yellow))
                    playerOneText.setBackgroundColor(ContextCompat.getColor
                        (this, R.color.white))

                }
                else {
                    ttButtons[i].text = "X"
                    visited[i] = 2

                    playerOneText.setBackgroundColor(ContextCompat.getColor
                        (this, R.color.our_yellow))
                    playerTwoText.setBackgroundColor(ContextCompat.getColor
                        (this, R.color.white))

                }
                counter++
                winCondition()
                drawCondition()
            }
        }
    }

    fun drawCondition() {
        if(counter == 8) {
            findViewById<TextView>(R.id.player1_text).text = "Won"
            findViewById<TextView>(R.id.player2_text).text = "Won"

            findViewById<TextView>(R.id.player1_text).setBackgroundColor(
                ContextCompat.getColor(this, R.color.our_green)
            )

            findViewById<TextView>(R.id.player2_text).setBackgroundColor(
                ContextCompat.getColor(this, R.color.our_green)
            )

            findViewById<Button>(R.id.start_buttonTTT).text = "START"
            findViewById<Button>(R.id.start_buttonTTT).setBackgroundColor(
                ContextCompat.getColor(this, R.color.our_yellow)
            )
            gameStarted = false
            counter = 0
        }
    }

    fun winCondition() {
        val arrstr = arrayOf(
            visited[0].toString(),
            visited[1].toString(),
            visited[2].toString(),
            visited[3].toString(),
            visited[4].toString(),
            visited[5].toString(),
            visited[6].toString(),
            visited[7].toString(),
            visited[8].toString()
        )

        var tempStr: String = ""

        tempStr = arrstr[0] + arrstr[1] + arrstr[2];
        if(tempStr == "111") {
            winFunction('a');
        }
        else if(tempStr == "222") {
            winFunction('b')
        }

        tempStr = arrstr[3] + arrstr[4] + arrstr[5];
        if(tempStr == "111") {
            winFunction('a');
        }
        else if(tempStr == "222") {
            winFunction('b')
        }

        tempStr = arrstr[6] + arrstr[7] + arrstr[8];
        if(tempStr == "111") {
            winFunction('a');
        }
        else if(tempStr == "222") {
            winFunction('b')
        }

        tempStr = arrstr[0] + arrstr[3] + arrstr[6];
        if(tempStr == "111") {
            winFunction('a');
        }
        else if(tempStr == "222") {
            winFunction('b')
        }

        tempStr = arrstr[1] + arrstr[4] + arrstr[7];
        if(tempStr == "111") {
            winFunction('a');
        }
        else if(tempStr == "222") {
            winFunction('b')
        }

        tempStr = arrstr[2] + arrstr[5] + arrstr[8];
        if(tempStr == "111") {
            winFunction('a');
        }
        else if(tempStr == "222") {
            winFunction('b')
        }


        tempStr = arrstr[0] + arrstr[4] + arrstr[8];
        if(tempStr == "111") {
            winFunction('a');
        }
        else if(tempStr == "222") {
            winFunction('b')
        }

        tempStr = arrstr[2] + arrstr[4] + arrstr[6];
        if(tempStr == "111") {
            winFunction('a');
        }
        else if(tempStr == "222") {
            winFunction('b')
        }

    }


    fun winFunction(ch: Char) {
        if(ch == 'a') {
            findViewById<TextView>(R.id.player1_text).text = "Won"
            findViewById<TextView>(R.id.player1_text).setBackgroundColor(
                ContextCompat.getColor(this, R.color.our_green)
            )
        }
        else {
            findViewById<TextView>(R.id.player2_text).text = "Won"
            findViewById<TextView>(R.id.player2_text).setBackgroundColor(
                ContextCompat.getColor(this, R.color.our_green)
            )
        }
        gameStarted = false
        counter = 0
        findViewById<Button>(R.id.start_buttonTTT).text = "START"
        findViewById<TextView>(R.id.start_buttonTTT).setBackgroundColor(
            ContextCompat.getColor(this, R.color.our_yellow)
        )
    }

//  for closing this activity
    fun backTicTacToe(view: android.view.View) {
        finish()
    }

    fun startGame(view: android.view.View) {
        if(gameStarted) {
            return
        }
        resetGame(view)
        gameStarted = true
        val startBtn = findViewById<Button>(R.id.start_buttonTTT)
        startBtn.setBackgroundColor(ContextCompat.getColor(this , R.color.our_green))
        startBtn.text = "STARTED"
        startBtn.width += 100
        findViewById<TextView>(R.id.player1_text).setBackgroundColor(
            ContextCompat.getColor(this, R.color.our_yellow))

    }

    fun resetGame(view: android.view.View) {
        val ttButtons = arrayOf<Button>(
            findViewById(R.id.button_1),
            findViewById(R.id.button_2),
            findViewById(R.id.button_3),
            findViewById(R.id.button_4),
            findViewById(R.id.button_5),
            findViewById(R.id.button_6),
            findViewById(R.id.button_7),
            findViewById(R.id.button_8),
            findViewById(R.id.button_9)
        )

        findViewById<TextView>(R.id.player1_text).setBackgroundColor(
            ContextCompat.getColor(this, R.color.white))
        findViewById<TextView>(R.id.player2_text).setBackgroundColor(
            ContextCompat.getColor(this, R.color.white))

        findViewById<TextView>(R.id.player1_text).text = "Player One"
        findViewById<TextView>(R.id.player2_text).text = "Player Two"

        gameStarted = false
        findViewById<Button>(R.id.start_buttonTTT).setBackgroundColor(
            ContextCompat.getColor(this , R.color.our_yellow))
        findViewById<Button>(R.id.start_buttonTTT).text = "START"


        for(i in 0..8) {
            ttButtons[i].text = ""
            visited[i] = 0
        }
    }
}

