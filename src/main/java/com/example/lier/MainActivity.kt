package com.example.lier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            var intent1 = Intent(this, SecondActivity::class.java)
            startActivity(intent1)
            this.finish();
        }
    }
}