package com.example.todolist.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.todolist.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val buttoncontinue = findViewById<Button>(R.id.buttoncontinue)
        buttoncontinue.setOnClickListener {
            val intent = Intent(this, LoginActivity1::class.java)
            startActivity(intent)

        }

    }
}