@file:Suppress("DEPRECATION")

package com.example.controlroleforschools

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity() : AppCompatActivity() {
    lateinit var txtView: TextView
    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var btnLogin: Button
    lateinit var progress: ProgressDialog
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtView = findViewById(R.id.tvTitle)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.Login)
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("PLease Wait....")
        btnLogin.setOnClickListener {
            //Start by receiving data from the user
            var email = edtEmail.text.toString().trim()
            var password = edtPassword.text.toString().trim()
            //Check if the user is submitting empty fields
            if (email.isEmpty()){
                edtEmail.setError("Please fill this input")
                edtEmail.requestFocus()
            }else if (password.isEmpty()){
                edtPassword.setError("Please fill this input")
                edtPassword.requestFocus()
            }else if (password.length <6){
                edtPassword.setError("Password too short")
                edtPassword.requestFocus()
            }
            else{
                //Proceed to login the user
                progress.show()
                mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener{
                        progress.dismiss()
                        if (it.isSuccessful){
                            Toast.makeText(this, "Login successful",
                                Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, ClassesActivity::class.java))
                            finish()
                        }else{
                            displayMessage("ERROR", it.exception!!.message.toString())
                        }
                    }
            }
        }
    }

    fun displayMessage(title:String, message:String){
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Ok",null)
        alertDialog.create().show()
        }



}



