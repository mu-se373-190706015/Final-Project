package com.example.oldpeopleappp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.oldpeopleappp.databinding.ActivityCallBinding

class CallActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.comebackbutton.setOnClickListener {
            val intent = Intent(this, AppInsideactivity::class.java)
            startActivity(intent)

        }
        binding.button155.setOnClickListener {
                val number1="+90115"
                val intent = Intent( Intent.ACTION_CALL)
                intent.setData(Uri.parse("tel:" +number1))
                if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED ){

                    print("error")
                }
                startActivity(intent)
            }



        binding.button112.setOnClickListener {
            val number="+90112"
            val intent = Intent( Intent.ACTION_CALL)
            intent.setData(Uri.parse("tel:" +number))
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED ){

             print("error")
            }
           startActivity(intent)
        }
    }


}