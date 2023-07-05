package com.example.todolist.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.todolist.MainActivity
import com.example.todolist.databinding.ActivityLogin2Binding

class LoginActivity2 : AppCompatActivity() {
    private lateinit var  binding: ActivityLogin2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        passwordFocusListener()
        usernameFocusListener()

        binding.buttonsignup.setOnClickListener{submitForm()}

    }
    private fun submitForm(){
        val intent = Intent(this, MainActivity::class.java)
        val validpass = binding.inputpass.helperText == null
        val validusername = binding.inputusername.helperText == null

        if(validpass && validusername )
            startActivity(intent)
    }

    private fun passwordFocusListener(){
        binding.editpass.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.inputpass.helperText = validpassword()
            }
        }
    }

    private fun validpassword(): String?{
        val passwordText = binding.editpass.text.toString()
        if(passwordText.length < 8){
            return "Minimum 8 Character"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex())){
            return "Must input Min 1 Uppercase Character"
        }
        if(!passwordText.matches(".*[a-z].*".toRegex())){
            return "Must input Min 1 Lowercase Character"
        }
        if(!passwordText.matches(".*[@#$%^&*+=,.].*".toRegex())){
            return "Must input Min Special Character"
        }
        return null
    }

    private fun usernameFocusListener(){
        binding.editusername.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.inputusername.helperText = validusername()
            }
        }
    }
    private fun validusername(): String? {
        val usernametext = binding.editusername.toString()
        if (usernametext.isEmpty()) {
            return "User Name is not Empty"
        }
        return null
    }
}