package com.example.dictionary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dictionary.databinding.ActivitySignupScreenBinding

class SignupScreen : AppCompatActivity(R.layout.activity_signup_screen) {

    private lateinit var binding: ActivitySignupScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.icBack.setOnClickListener {
            finish()
        }

        binding.textLogin.setOnClickListener {
            //TODO: move to log in activity
        }

        binding.signupButton.setOnClickListener {
            val name: String = binding.textName.editText?.text.toString()
            val email: String = binding.textEmail.editText?.text.toString()
            val password: String = binding.textPassword.editText?.text.toString()

            when {
                name.isEmpty() -> Toast.makeText(
                    this,
                    "You did not enter a username",
                    Toast.LENGTH_SHORT
                ).show()

                email.isEmpty() -> Toast.makeText(
                    this,
                    "You did not enter an email",
                    Toast.LENGTH_SHORT
                ).show()

                password.isEmpty() -> Toast.makeText(
                    this,
                    "You did not enter a password",
                    Toast.LENGTH_SHORT
                ).show()

                else -> {
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}