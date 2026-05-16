package com.example.final_projectapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.final_projectapp.R
import com.example.final_projectapp.data.Database
import com.example.final_projectapp.list_activity

class login : AppCompatActivity() {
    lateinit var user: EditText
    lateinit var pass: EditText
    lateinit var btn_login: Button
    lateinit var dbHelper: Database
    lateinit var text_reg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        user = findViewById(R.id.edt_user2)
        pass = findViewById(R.id.edt_pass2)
        text_reg = findViewById(R.id.text_reg)

        dbHelper = Database(this)
        btn_login = findViewById(R.id.btn_login)


        btn_login.setOnClickListener {

            val username = user.text.toString()
            val password = pass.text.toString()

            if (username.isEmpty() || password.isEmpty()) {

                Toast.makeText(this, "Enter data", Toast.LENGTH_SHORT).show()

            } else {

                val inserted = dbHelper.checkUser(username, password)

                if (inserted) {

                    Toast.makeText(this, "Login  Successful", Toast.LENGTH_SHORT).show()
                    val intentt = Intent(this, list_activity::class.java)

                    startActivity(intentt)

                } else {

                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
        text_reg.setOnClickListener {
            val intentt = Intent(this, MainActivity::class.java)
            startActivity(intentt)
        }

    }
}