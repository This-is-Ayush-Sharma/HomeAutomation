package com.ayush.homeautomation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : AppCompatActivity() {
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button

    val baseUrl = "http://172.32.0.111:5000/api/v1/"
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // get btn by id frm layout
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)


        // Setting up listner on the btn
        btn1.setOnClickListener {
            ChangeStatus(btn1)
        }

        btn2.setOnClickListener {
            ChangeStateOfApplicances()
            ChangeStatus(btn2)
        }

        btn3.setOnClickListener {
            ChangeStatus(btn3)
        }

        btn4.setOnClickListener {
            ChangeStatus(btn4)
        }
    }

    private fun ChangeStateOfApplicances() {
        val retrofit_builder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(ApiInterface::class.java)

            CoroutineScope(Dispatchers.Main).launch{
                val retrofitData = retrofit_builder.getData().body()
                Log.i("MyTag",retrofitData.toString())
            }
    }

    // State Change
    fun ChangeStatus(button: Button){
        if(button.getTag().toString().toInt() == 0)
        {
            button.setBackgroundColor(Color.rgb(82,152,12))
            button.setTag(1)
        }
        else
        {
            button.setBackgroundColor(Color.rgb(241,51,51))
            button.setTag(0)
        }
    }
}

