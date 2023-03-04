package com.ayush.homeautomation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Timer
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ChangeAfterTime() // calls the fuction
    }
    // defined function to change the acitvity after 5s used timer class
    fun ChangeAfterTime(){
        val timeTasks = timerTask {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }
        val timer = Timer()
        timer.schedule(timeTasks,5000)
    }
}