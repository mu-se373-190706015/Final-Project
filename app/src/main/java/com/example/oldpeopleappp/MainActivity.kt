package com.example.oldpeopleappp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.oldpeopleappp.databinding.ActivityMainBinding
import com.example.oldpeopleappp.databinding.ActivityMedicineRememberBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener {
            val intent = Intent(this, AppInsideactivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.registerButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }


    }
}