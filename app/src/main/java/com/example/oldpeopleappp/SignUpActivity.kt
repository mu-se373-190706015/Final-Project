package com.example.oldpeopleappp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.oldpeopleappp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var  binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonKaydol.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

}