package com.example.oldpeopleappp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.oldpeopleappp.databinding.ActivityAppInsideactivityBinding

class AppInsideactivity : AppCompatActivity() {

     private lateinit var binding:ActivityAppInsideactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAppInsideactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.callbutton.setOnClickListener {
            val intent = Intent(this, CallActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.reminderbutton.setOnClickListener {
            val intent = Intent(this, MedicineRememberActivity::class.java)
            startActivity(intent)

        }
        binding.todolistbutton.setOnClickListener {
            val intent = Intent(this, TodoListActivity::class.java)
            startActivity(intent)

        }
    }
}