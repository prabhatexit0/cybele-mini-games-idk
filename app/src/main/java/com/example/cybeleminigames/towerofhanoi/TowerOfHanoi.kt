package com.example.cybeleminigames.towerofhanoi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.example.cybeleminigames.R
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

class TowerOfHanoi : AppCompatActivity() {
    var logicStackOne: Stack<Int> = Stack()
    var logicStackTwo: Stack<Int> = Stack()
    var logicStackThree: Stack<Int> = Stack()

    val matrixTowerOne: ArrayList<ArrayList<View>> = ArrayList()
    val matrixTowerTwo: ArrayList<ArrayList<View>> = ArrayList()
    val matrixTowerThree: ArrayList<ArrayList<View>> = ArrayList()

    private var pick: Boolean = true
    private var picked: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tower_of_hanoi)

        logicStackOne.push(3)
        logicStackOne.push(2)
        logicStackOne.push(1)

        matrixTowerOne.add(ArrayList())
        matrixTowerOne.add(ArrayList())
        matrixTowerOne.add(ArrayList())

        matrixTowerOne[2].add(findViewById<View>(R.id.bigTone1))
        matrixTowerOne[2].add(findViewById<View>(R.id.bigTone2))
        matrixTowerOne[2].add(findViewById<View>(R.id.bigTone3))

        matrixTowerOne[1].add(findViewById<View>(R.id.medTone1))
        matrixTowerOne[1].add(findViewById<View>(R.id.medTone2))
        matrixTowerOne[1].add(findViewById<View>(R.id.medTone3))

        matrixTowerOne[0].add(findViewById<View>(R.id.smallTone1))
        matrixTowerOne[0].add(findViewById<View>(R.id.smallTone2))
        matrixTowerOne[0].add(findViewById<View>(R.id.smallTone3))


        matrixTowerTwo.add(ArrayList())
        matrixTowerTwo.add(ArrayList())
        matrixTowerTwo.add(ArrayList())

        matrixTowerTwo[2].add(findViewById<View>(R.id.bigTwo1))
        matrixTowerTwo[2].add(findViewById<View>(R.id.bigTwo2))
        matrixTowerTwo[2].add(findViewById<View>(R.id.bigTwo3))

        matrixTowerTwo[1].add(findViewById<View>(R.id.medTwo1))
        matrixTowerTwo[1].add(findViewById<View>(R.id.medTwo2))
        matrixTowerTwo[1].add(findViewById<View>(R.id.medTwo3))

        matrixTowerTwo[0].add(findViewById<View>(R.id.smallTwo1))
        matrixTowerTwo[0].add(findViewById<View>(R.id.smallTwo2))
        matrixTowerTwo[0].add(findViewById<View>(R.id.smallTwo3))


        matrixTowerThree.add(ArrayList())
        matrixTowerThree.add(ArrayList())
        matrixTowerThree.add(ArrayList())

        matrixTowerThree[2].add(findViewById<View>(R.id.bigThree1))
        matrixTowerThree[2].add(findViewById<View>(R.id.bigThree2))
        matrixTowerThree[2].add(findViewById<View>(R.id.bigThree3))

        matrixTowerThree[1].add(findViewById<View>(R.id.medThree1))
        matrixTowerThree[1].add(findViewById<View>(R.id.medThree2))
        matrixTowerThree[1].add(findViewById<View>(R.id.medThree3))

        matrixTowerThree[0].add(findViewById<View>(R.id.smallThree1))
        matrixTowerThree[0].add(findViewById<View>(R.id.smallThree2))
        matrixTowerThree[0].add(findViewById<View>(R.id.smallThree3))

        pick = true
    }

    fun clickTowerOne(view: android.view.View) {
        // pick and picked
        /*
        * if not picked => logicStack.peek() => 1, 2, 3 and size => 0, 1, 2, 3
        * when picking {
        * if(logicStackCurr.size == 0) return
        * matrixTower[logicStackCurr.peek() - 1][size - 1].visibility = View.visible
        *
        * peek() will give the topmost element => 1 = biggest, 2 = medium, 3 => smallest
        * size 1 => 1
        *
        *
        *
        * */

        if(pick && logicStackOne.size != 0) {
            matrixTowerOne[logicStackOne.peek() - 1][logicStackOne.size - 1].visibility = View.GONE
            pick = false
            picked = logicStackOne.peek()
            logicStackOne.pop()
        }
        else {
            if(logicStackTwo.size == 0 && pick) {
                return
            }
            if(logicStackOne.size == 0 || picked < logicStackOne.peek()) {
                matrixTowerOne[picked - 1][logicStackOne.size].visibility = View.VISIBLE
                logicStackOne.push(picked)
                pick = true
            }
        }

        if(logicStackThree.size == 0) {

        }
    }
    fun clickTowerTwo(view: android.view.View) {
        if(pick && logicStackTwo.size != 0) {
            matrixTowerTwo[logicStackTwo.peek() - 1][logicStackTwo.size - 1].visibility = View.GONE
            pick = false
            picked = logicStackTwo.peek()
            logicStackTwo.pop()
        }
        else {
            if(logicStackTwo.size == 0 && pick) {
                return
            }
            if(logicStackTwo.size == 0 || picked < logicStackTwo.peek()) {
                matrixTowerTwo[picked - 1][logicStackTwo.size].visibility = View.VISIBLE
                logicStackTwo.push(picked)
                pick = true
            }
        }
    }
    fun clickTowerThree(view: android.view.View) {
        if(pick && logicStackThree.size != 0) {
            matrixTowerThree[logicStackThree.peek() - 1][logicStackThree.size - 1].visibility = View.GONE
            pick = false
            picked = logicStackThree.peek()
            logicStackThree.pop()
        }
        else {
            if(logicStackThree.size == 0 && pick) {
                return
            }
            if(logicStackThree.size == 0 || picked < logicStackThree.peek()) {
                matrixTowerThree[picked - 1][logicStackThree.size].visibility = View.VISIBLE
                logicStackThree.push(picked)
                pick = true
            }
        }

        if(logicStackThree.size == 3) {
            findViewById<RelativeLayout>(R.id.towerOne).visibility = View.GONE
            findViewById<RelativeLayout>(R.id.towerTwo).visibility = View.GONE
            findViewById<TextView>(R.id.gameOverToh).visibility = View.VISIBLE
            findViewById<Button>(R.id.resetToh).visibility = View.VISIBLE;
        }
    }

    fun clickResetToh(view: android.view.View) {
        val toh: Intent = Intent(this, TowerOfHanoi::class.java)
        finish()
        startActivity(toh)
    }
}