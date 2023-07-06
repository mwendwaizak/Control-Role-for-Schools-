package com.example.controlroleforschools

import android.app.AlertDialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class F3s_Activity : AppCompatActivity() {
    lateinit var Form3s: TextView
    lateinit var edtName: EditText
    lateinit var edtNum: EditText
    lateinit var edtHouse: EditText
    lateinit var btnRegister: Button
    lateinit var mAuth: FirebaseAuth
    lateinit var progress: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_f3s)
        Form3s = findViewById(R.id.Form3s)
        edtName = findViewById(R.id.edtName)
        edtNum = findViewById(R.id.edtNum)
        edtHouse = findViewById(R.id.edtHouse)
        btnRegister = findViewById(R.id.btnRegister)
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("PLease Wait....")
        btnRegister.setOnClickListener {
            var name = edtName.text.toString().trim()
            var houseNum = edtHouse.text.toString().trim()
            var admNo = edtNum.text.toString().trim()
            //check if the user is submitting empty fields
            if (name.isEmpty())
            {Toast.makeText(this, "Sorry cannot submit an empty name", Toast.LENGTH_SHORT).show()}
            else if (houseNum.isEmpty()) {
                Toast.makeText(this, "Cannot Submit an empty number", Toast.LENGTH_SHORT).show()
            }
            else if (admNo.isEmpty()) {
                Toast.makeText(this, "Cannot Submit an empty number", Toast.LENGTH_SHORT).show()
            } else {
                //proceed to register the user
                progress.show()
                var time = System.currentTimeMillis().toString()
                var ref = FirebaseDatabase.getInstance().getReference().
                child("F3s/"+time)
                var studentData = Studentdata(name,admNo,houseNum,time)
                ref.setValue(studentData).addOnCompleteListener {
                    progress.dismiss()
                    if (it.isSuccessful){
                        Toast.makeText(this, "Data submitted successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Data submission failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    fun displayMessage(tittle:String, message:String){
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(tittle)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Ok",null)
        alertDialog.create().show()
    }
}