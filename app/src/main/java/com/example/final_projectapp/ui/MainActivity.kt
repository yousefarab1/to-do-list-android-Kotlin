
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

class MainActivity : AppCompatActivity() {

    lateinit var user: EditText
    lateinit var pass: EditText
    lateinit var btnSignUp: Button
    lateinit var textLogin: TextView

    lateinit var dbHelper: Database

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        user = findViewById(R.id.edt_user)
        pass = findViewById(R.id.edt_pass)
        btnSignUp = findViewById(R.id.btn_reg)
        textLogin = findViewById(R.id.text_login)

        dbHelper = Database(this)

        btnSignUp.setOnClickListener {

            val username = user.text.toString()
            val password = pass.text.toString()

            if (username.isEmpty() || password.isEmpty()) {

                Toast.makeText(this, "Enter data", Toast.LENGTH_SHORT).show()

            } else {

                val inserted = dbHelper.insertUser(username, password)

                if (inserted) {

                    Toast.makeText(this, "Sign Up Success", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, login::class.java)

                    startActivity(intent)

                } else {

                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

        textLogin.setOnClickListener {

            val intent = Intent(this, login::class.java)

            startActivity(intent)
        }
    }
}