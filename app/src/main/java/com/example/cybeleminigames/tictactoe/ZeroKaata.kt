package com.example.cybeleminigames.tictactoe

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import com.example.cybeleminigames.R
import org.w3c.dom.Text

class ZeroKaata : AppCompatActivity(), View.OnClickListener {
    val blocks: ArrayList<ArrayList<Block>> = ArrayList()

    lateinit var startBtn: Button
    lateinit var title: TextView
    lateinit var playerOne: TextView
    lateinit var playerTwo: TextView
    lateinit var mainBoard: LinearLayout

    var whoWon = 0

    var moves: Int = 0
    var win: Boolean = false
    var started: Boolean = false
    val visited = arrayOf(arrayOf(0, 0, 0), arrayOf(0, 0, 0), arrayOf(0, 0, 0))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zero_kaata)

        startBtn = findViewById<Button>(R.id.tttStartBtn)
        title = findViewById<TextView>(R.id.zeroKaataTitle)
        playerOne = findViewById<TextView>(R.id.playerOneSign)
        playerTwo = findViewById<TextView>(R.id.playerTwoSign)

        blocks.add(ArrayList())
        blocks.add(ArrayList())
        blocks.add(ArrayList())



        blocks[0].add(Block(findViewById(R.id.aa), 0, 0, "n"))
        blocks[0].add(Block(findViewById(R.id.ab), 0, 1, "n"))
        blocks[0].add(Block(findViewById(R.id.ac), 0, 2, "n"))

        blocks[1].add(Block(findViewById(R.id.ba), 1, 0, "n"))
        blocks[1].add(Block(findViewById(R.id.bb), 1, 1, "n"))
        blocks[1].add(Block(findViewById(R.id.bc), 1, 2, "n"))

        blocks[2].add(Block(findViewById(R.id.ca), 2, 0, "n"))
        blocks[2].add(Block(findViewById(R.id.cb), 2, 1, "n"))
        blocks[2].add(Block(findViewById(R.id.cc), 2, 2, "n"))

//        blocks[0][0].imgView.setOnClickListener(this)
//        blocks[0][1].imgView.setOnClickListener(this)
//        blocks[0][2].imgView.setOnClickListener(this)
//
//        blocks[1][0].imgView.setOnClickListener(this)
//        blocks[1][1].imgView.setOnClickListener(this)
//        blocks[1][2].imgView.setOnClickListener(this)
//
//        blocks[2][0].imgView.setOnClickListener(this)
//        blocks[2][1].imgView.setOnClickListener(this)
//        blocks[2][2].imgView.setOnClickListener(this)

        for(i in 0..2) {
            for(j in 0..2) {
                blocks[i][j].imgView.setOnClickListener(this)
            }
        }


        blocks[1][1].imgView.setOnLongClickListener {
            reset()
            return@setOnLongClickListener true
        }

    }

    override fun onClick(v: View?) {
        when(v) {
            blocks[0][0].imgView -> actionTaker(blocks[0][0])
            blocks[0][1].imgView -> actionTaker(blocks[0][1])
            blocks[0][2].imgView -> actionTaker(blocks[0][2])

            blocks[1][0].imgView -> actionTaker(blocks[1][0])
            blocks[1][1].imgView -> actionTaker(blocks[1][1])
            blocks[1][2].imgView -> actionTaker(blocks[1][2])

            blocks[2][0].imgView -> actionTaker(blocks[2][0])
            blocks[2][1].imgView -> actionTaker(blocks[2][1])
            blocks[2][2].imgView -> actionTaker(blocks[2][2])
        }
    }



    fun actionTaker(iv: Block) {

        if(!started || winCondition() || iv.vis || moves > 8) {
            return
        }

        if(moves % 2 == 0) {
            iv.imgView.setImageResource(R.drawable.o)
            iv.vis = true
            iv.c = "o"
            moves++
            playerOne.setBackgroundResource(R.drawable.player_ttt_bg)
            playerTwo.setBackgroundResource(R.drawable.player_ttt_bgtwo)

            if(winCondition()) {
                winAction(1)
            }
        }
        else {
            iv.imgView.setImageResource(R.drawable.x)
            iv.vis = true
            iv.c = "x"
            moves++
            playerOne.setBackgroundResource(R.drawable.player_ttt_bgtwo)
            playerTwo.setBackgroundResource(R.drawable.player_ttt_bg)

            if(winCondition()) {
                winAction(2)
            }
        }

        if(moves > 8) {
            winAction(3)
        }

        win = winCondition()

    }

    fun winAction(i: Int) {
        if(i == 1) {
            playerOne.text = "Player One Won"
            playerTwo.text = "Player One Won"
            playerOne.setBackgroundResource(R.drawable.tt_buttons)
            playerTwo.setBackgroundResource(R.drawable.tt_buttons)
            for(j in 0..2) {
                for(k in 0..2) {
                    blocks[j][k].imgView.setImageResource(R.drawable.o)
                }
            }
        }
        else if(i == 2) {
            playerOne.text = "Player Two Won"
            playerTwo.text = "Player Two Won"
            playerOne.setBackgroundResource(R.drawable.tt_buttons)
            playerTwo.setBackgroundResource(R.drawable.tt_buttons)
            for(j in 0..2) {
                for(k in 0..2) {
                    blocks[j][k].imgView.setImageResource(R.drawable.x)
                }
            }
        }
        else {
            playerOne.text = "DRAW DRAW DRAW"
            playerTwo.text = "DRAW DRAW DRAW"
            playerOne.setBackgroundResource(R.drawable.tt_buttons)
            playerTwo.setBackgroundResource(R.drawable.tt_buttons)
            for(j in 0..2) {
                for(k in 0..2) {
                    blocks[j][k].imgView.setImageResource(R.drawable.drawduck)
                }
            }
        }

    }

    fun reset() {
        started = false
        moves = 0
        whoWon = 0
        win = false

        for(i in 0..2) {
            for(j in 0..2) {
                blocks[i][j].c = "n"
                blocks[i][j].vis = false
                blocks[i][j].imgView.setImageResource(0)
            }
        }
        playerOne.visibility = View.GONE
        playerTwo.visibility = View.GONE
        playerOne.text = "Player One"
        playerTwo.text = "Player Two"
        playerOne.setBackgroundResource(R.drawable.player_ttt_bg)
        playerTwo.setBackgroundResource(R.drawable.player_ttt_bg)
        title.visibility = View.VISIBLE
        startBtn.visibility = View.VISIBLE
    }


    fun winCondition(): Boolean {
        if(blocks[0][0].c != "n" && (blocks[0][0].c == blocks[0][1].c) && (blocks[0][1].c == blocks[0][2].c)) {
            return true
        }
        if(blocks[1][0].c != "n" && (blocks[1][0].c == blocks[1][1].c) && (blocks[1][1].c == blocks[1][2].c)) {
            return true
        }
        if(blocks[2][0].c != "n" && (blocks[2][0].c == blocks[2][1].c) && (blocks[2][1].c == blocks[2][2].c)) {
            return true
        }

        if(blocks[0][0].c != "n" && (blocks[0][0].c == blocks[1][0].c) && (blocks[1][0].c == blocks[2][0].c)) {
            return true
        }
        if(blocks[0][1].c != "n" && (blocks[0][1].c == blocks[1][1].c) && (blocks[1][1].c == blocks[2][1].c)) {
            return true
        }
        if(blocks[0][2].c != "n" && (blocks[0][2].c == blocks[1][2].c) && (blocks[2][1].c == blocks[2][2].c)) {
            return true
        }

        if(blocks[0][0].c != "n" && (blocks[0][0].c == blocks[1][1].c) && (blocks[1][1].c == blocks[2][2].c)) {
            return true
        }
        if(blocks[0][2].c != "n" && (blocks[0][2].c == blocks[1][1].c) && (blocks[1][1].c == blocks[2][0].c)) {
            return true
        }
        return false
    }

    fun onClickStart(view: android.view.View) {
        started = true;
        startBtn.visibility = View.GONE
        title.visibility = View.GONE

        playerOne.visibility = View.VISIBLE
        playerTwo.visibility = View.VISIBLE
        playerOne.setBackgroundResource(R.drawable.player_ttt_bgtwo)
    }

}