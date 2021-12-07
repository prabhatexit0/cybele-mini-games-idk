package com.example.cybeleminigames.userprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.cybeleminigames.R

class UserProfile : AppCompatActivity(){
    lateinit var editText: EditText
    lateinit var createButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
    }

    fun backProfileScr(view: android.view.View) {
        finish()
    }


}