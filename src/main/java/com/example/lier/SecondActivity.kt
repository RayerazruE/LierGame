package com.example.lier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.view.View

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.e("체크","------------------------");
        var btn2 = findViewById<Button>(R.id.btn2)

        var edt1 = findViewById<EditText>(R.id.edt1)
        var edt2 = findViewById<EditText>(R.id.edt2)
        var edt3 = findViewById<EditText>(R.id.edt3)
        var edt4 = findViewById<EditText>(R.id.edt4)
        var edt5 = findViewById<EditText>(R.id.edt5)
        var edt6 = findViewById<EditText>(R.id.edt6)
        var edt7 = findViewById<EditText>(R.id.edt7)
        var edt8 = findViewById<EditText>(R.id.edt8)

        var layout6 = findViewById<LinearLayout>(R.id.layout6)
        var layout7 = findViewById<LinearLayout>(R.id.layout7)
        var layout8 = findViewById<LinearLayout>(R.id.layout8)

        var btnminus = findViewById<Button>(R.id.btnminus)
        var btnplus = findViewById<Button>(R.id.btnplus)
        var mnum = findViewById<TextView>(R.id.mnum)

        btnminus.setOnClickListener {
            var num = mnum.text.toString().toInt()

            if (num > 5) {
                num--
                mnum.text = num.toString()
            }

            when (num) {
                5 -> {
                    layout6.visibility = View.GONE
                    layout7.visibility = View.GONE
                    layout8.visibility = View.GONE
                }
                6 -> {
                    layout6.visibility = View.VISIBLE
                    layout7.visibility = View.GONE
                    layout8.visibility = View.GONE
                }
                7 -> {
                    layout6.visibility = View.VISIBLE
                    layout7.visibility = View.VISIBLE
                    layout8.visibility = View.GONE
                }
                8 -> {
                    layout6.visibility = View.VISIBLE
                    layout7.visibility = View.VISIBLE
                    layout8.visibility = View.VISIBLE
                }
            }
        }

        btnplus.setOnClickListener {
            var num = mnum.text.toString().toInt()

            if (num < 8) {
                num++
                mnum.text = num.toString()
            }

            when (num) {
                5 -> {
                    layout6.visibility = View.GONE
                    layout7.visibility = View.GONE
                    layout8.visibility = View.GONE
                }
                6 -> {
                    layout6.visibility = View.VISIBLE
                    layout7.visibility = View.GONE
                    layout8.visibility = View.GONE
                }
                7 -> {
                    layout6.visibility = View.VISIBLE
                    layout7.visibility = View.VISIBLE
                    layout8.visibility = View.GONE
                }
                8 -> {
                    layout6.visibility = View.VISIBLE
                    layout7.visibility = View.VISIBLE
                    layout8.visibility = View.VISIBLE
                }
            }
        }

        btn2.setOnClickListener {
            val num = mnum.text.toString().toInt()
            val intent2 = Intent(this, ThirdActivity::class.java)

            intent2.putExtra("num", num)
            intent2.putExtra("name1", edt1.text.toString())
            intent2.putExtra("name2", edt2.text.toString())
            intent2.putExtra("name3", edt3.text.toString())
            intent2.putExtra("name4", edt4.text.toString())
            intent2.putExtra("name5", edt5.text.toString())
            Log.e("체크","2-유저5명데이터전송");

            if (num >= 6) {
                intent2.putExtra("name6", edt6.text.toString())
                Log.e("체크","2-유저6명데이터전송");
            }
            if (num >= 7) {
                intent2.putExtra("name7", edt7.text.toString())
                Log.e("체크","2-유저7명데이터전송");
            }
            if (num >= 8) {
                intent2.putExtra("name8", edt8.text.toString())
                Log.e("체크","2-유저8명데이터전송");
            }

            startActivity(intent2)
            this.finish();
        }
    }
}