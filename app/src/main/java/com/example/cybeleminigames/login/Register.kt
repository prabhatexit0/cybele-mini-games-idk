package com.example.cybeleminigames.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cybeleminigames.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val loginAccount = findViewById<TextView>(R.id.loginAccount)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val registerEmail = findViewById<EditText>(R.id.registerEmail)
        val registerUsername = findViewById<EditText>(R.id.registerUsername)
        val registerPassword = findViewById<EditText>(R.id.registerPassword)
        var fireUser: FirebaseUser?
        var fireStore: FirebaseFirestore

        loginAccount.setOnClickListener {
            val loginAct = Intent(this@Register, Login::class.java)
            startActivity(loginAct)
            finish()
        }

        registerButton.setOnClickListener {
            when {
                TextUtils.isEmpty(registerUsername.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        this@Register,
                        "Please Enter Username",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(registerEmail.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        this@Register,
                        "Please Enter Email",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(registerPassword.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        this@Register,
                        "Please Enter Password",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val email: String = registerEmail.text.toString().trim { it <= ' ' }
                    val password: String = registerPassword.text.toString().trim { it <= ' ' }
                    val username: String = registerUsername.text.toString().trim {it <= ' '}

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                            OnCompleteListener {
                                task ->
                                if(task.isSuccessful) {
                                    val firebaseUser = task.result!!.user!!
                                    Toast.makeText(
                                        this@Register,
                                        "You are Registered Successfully",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val loginActivity = Intent(this@Register, Login::class.java)
                                    loginActivity.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    loginActivity.putExtra("userId", firebaseUser.uid)
                                    loginActivity.putExtra("emailId", email)
                                    loginActivity.putExtra("userName", username)
                                    fireStore = FirebaseFirestore.getInstance()
                                    fireUser = FirebaseAuth.getInstance().currentUser
                                    val documentReference: DocumentReference = fireStore
                                        .collection("users")
                                        .document(firebaseUser.uid)


                                    val user: HashMap<String, String> = HashMap<String, String>()
                                    user["userName"] = username
                                    documentReference.set(user)

                                    startActivity(loginActivity)
                                    finish()
                                }
                            }
                        )
                }
            }
        }
    }
}