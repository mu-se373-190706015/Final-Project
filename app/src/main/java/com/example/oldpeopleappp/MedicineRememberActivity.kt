package com.example.oldpeopleappp

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.oldpeopleappp.databinding.ActivityMedicineRememberBinding
import java.util.*

class MedicineRememberActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMedicineRememberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMedicineRememberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createNotificationChannel()
        binding.submitButton.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                scheduleNotification()
            }
        }

        binding.comebackremainder.setOnClickListener {
            val intent = Intent(this, AppInsideactivity::class.java)
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun scheduleNotification(){
        val intent = Intent(applicationContext, Notification::class.java)
        val title = binding.titleET.text.toString()
        val message = binding.messageET.text.toString()
        intent.putExtra(titleExtra, title)
        intent.putExtra(messageExtra, message)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            notificationID,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getTime()
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            time,
            pendingIntent
        )
        showAlert(time, title, message)
    }

    private fun showAlert(time: Long, title: String, message: String){
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(applicationContext)
        val timeFormat = android.text.format.DateFormat.getTimeFormat(applicationContext)

        AlertDialog.Builder(this)
            .setTitle("Notification Scheduled")
            .setMessage(
                "Title: " + title +
                        "\nMessage: " + message +
                        "\nAt: " + dateFormat.format(date) + " " + timeFormat.format(date))
            .setPositiveButton("Okay"){_,_ ->}
            .show()
    }
    private fun getTime(): Long
    {
        val minute = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.timePicker.minute
        } else {
          print("Doesnt work")
        }
        val hour = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.timePicker.hour
        } else {
            print("Doesnt work")
        }
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month
        val year = binding.datePicker.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour as Int, minute as Int)
        return calendar.timeInMillis
    }
    private fun createNotificationChannel()
    {
        val name = "Notif Channel"
        val desc = "A Description of the Channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(channelID, name, importance)
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        channel.description = desc
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

}