package com.example.alarmapp


import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var timePicker: TimePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timePicker = findViewById(R.id.timePicker)
        timePicker.setIs24HourView(true)
    }

    fun setAlarm(view: View) {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val hour = timePicker.hour
        val minute = timePicker.minute

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        calendar.set(Calendar.SECOND, 0)

        val intent = Intent(this, AlarmManager::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)

        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)

        Toast.makeText(this, "Alarm ayarlandı", Toast.LENGTH_SHORT).show()
    }
}
