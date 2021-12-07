package com.example.cybeleminigames.tictactoe

import android.widget.ImageView

class Block (i: ImageView, l: Int, r: Int, ch: String) {
    val imgView = i
    val left = l
    val right = r
    var c = ch
    var vis: Boolean = false
}