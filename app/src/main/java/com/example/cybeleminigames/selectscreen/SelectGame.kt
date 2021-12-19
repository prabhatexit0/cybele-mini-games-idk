package com.example.cybeleminigames.selectscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cybeleminigames.R
import com.example.cybeleminigames.tictactoe.ZeroKaata
import com.example.cybeleminigames.towerofhanoi.TowerOfHanoi

class SelectGame : AppCompatActivity(), ItemClicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_game)

        val items: ArrayList<SelectItemClass> = ArrayList()
        items.add(SelectItemClass("Tic\nTac\nToe", R.drawable.tictactoe, "zeroKaata"))
        items.add(SelectItemClass("Tower\nOf\nHanoi", R.drawable.toiletpaper, "towerOfHanoi"))
        items.add(SelectItemClass("COMING\nSOON", R.drawable.soon, "cs2"))
        items.add(SelectItemClass("COMING\nSOON", R.drawable.soon, "cs1"))
        items.add(SelectItemClass("COMING\nSOON", R.drawable.soon, "cs3"))

        val selectAdapter = SelectAdapter(items, this)
        val selectRecyclerView: RecyclerView = findViewById(R.id.selectRecyclerView)
        selectRecyclerView.layoutManager = LinearLayoutManager(this)
        selectRecyclerView.adapter = selectAdapter
    }

    fun backSelectScr(view: android.view.View) {
        finish()
    }

    override fun onItemClicked(item: SelectItemClass) {
        val zeroKaata = Intent(this, ZeroKaata::class.java)
        val towerOfHanoi = Intent(this, TowerOfHanoi::class.java)
        when(item.ID) {
            "zeroKaata" -> startActivity(zeroKaata)
            "towerOfHanoi" -> startActivity(towerOfHanoi)
        }
    }


}