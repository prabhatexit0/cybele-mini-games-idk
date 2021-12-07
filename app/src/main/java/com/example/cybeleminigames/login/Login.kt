package com.example.cybeleminigames.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cybeleminigames.MainActivity
import com.example.cybeleminigames.R
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.loginButton)
        val loginEmail = findViewById<EditText>(R.id.loginEmail)
        val loginPassword = findViewById<EditText>(R.id.loginPassword)


        loginButton.setOnClickListener {
            when {
                TextUtils.isEmpty(loginEmail.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@Login, "Please Enter Email ID",Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(loginPassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@Login, "Please Enter Password",Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email = loginEmail.text.toString().trim { it <= ' ' }
                    val password = loginPassword.text.toString().trim { it <= ' ' }

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener {
                            task ->
                            if(task.isSuccessful) {
                                Toast.makeText(
                                    this, "Login Successfull", Toast.LENGTH_SHORT
                                ).show()

                                val mainAcitvityIntent = Intent(this@Login, MainActivity::class.java)

                                mainAcitvityIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                mainAcitvityIntent.putExtra("emailId", email)

                                startActivity(mainAcitvityIntent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this@Login, task.exception!!.message.toString(), Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }
    }

    fun registerClick(view: android.view.View) {
        val registerAct: Intent = Intent(this@Login, Register::class.java)
        startActivity(registerAct)
        finish()
    }
}