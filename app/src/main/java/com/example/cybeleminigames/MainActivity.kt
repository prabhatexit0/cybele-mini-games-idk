package com.example.cybeleminigames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.example.cybeleminigames.selectscreen.SelectGame
import com.example.cybeleminigames.userprofile.UserProfile
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)



    }

    fun selectScr(view: android.view.View) {
        val switchToSelectScr = Intent(this, SelectGame::class.java)
        startActivity(switchToSelectScr)
    }

    fun exitMain(view: android.view.View) {
        finish()
    }

    fun onClickLoginMain(view: android.view.View) {
        val profile: Intent = Intent(this, UserProfile::class.java)
        startActivity(profile)
    }

}