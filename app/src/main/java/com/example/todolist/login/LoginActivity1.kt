package com.example.todolist.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.todolist.databinding.ActivityLogin1Binding

class LoginActivity1 : AppCompatActivity() {
    private lateinit var  binding: ActivityLogin1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        emailFocusListener()

        binding.buttonnext.setOnClickListener{submitForm()}

    }
    private fun submitForm(){
        val intent = Intent(this, LoginActivity2::class.java)
        val validEmail = binding.inputemail.helperText == null

        if(validEmail)
            startActivity(intent)
        else
            invalidForm()
    }

    private fun invalidForm(){
        val emailtext = binding.editemail.toString()
        if(emailtext.isEmpty()){
            Toast.makeText(this,"Enter Your E-mail", Toast.LENGTH_LONG).show()
        }
        else if(!emailtext.contains("@")){
            Toast.makeText(this,"Enter Right E-mail", Toast.LENGTH_LONG).show()
        }
        else if(!emailtext.contains(".com")){
            Toast.makeText(this,"Enter Right E-mail", Toast.LENGTH_LONG).show()
        }
    }

    private fun emailFocusListener(){
        binding.editemail.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.inputemail.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String?{
        val emailText = binding.editemail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            return "Enter Valid E-mail!"
        }
        return null
    }
}