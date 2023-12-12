package com.example.lier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.Collections
import java.util.Random

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        Log.e("체크","------------------------");
        val receivedData = intent.extras
        val num = intent.getIntExtra("num", 0)
        val names = ArrayList<String>()

        if (receivedData != null) {
            for (i in 1..num) {
                val name = receivedData.getString("name$i", "")
                names.add(name)
                Log.e("체크","3-유저수만큼데이터받기");
            }
        }

//        if (receivedData != null) {
//            names.add(receivedData.getString("name1", ""))
//            names.add(receivedData.getString("name2", ""))
//            names.add(receivedData.getString("name3", ""))
//            names.add(receivedData.getString("name4", ""))
//            names.add(receivedData.getString("name5", ""))
//            names.add(receivedData.getString("name6", ""))
//            names.add(receivedData.getString("name7", ""))
//            names.add(receivedData.getString("name8", ""))
//        }

        // strings.xml에서 명사 가져오기
        val nounsArray = resources.getStringArray(R.array.nouns)
        Log.e("체크","3-명사배열가져오기");

        // 배열을 MutableList로 변환하고 무작위로 섞기
        val shuffledNouns = nounsArray.toMutableList().shuffled()
        Log.e("체크","3-명사배열무작위섞기");

        // 섞인 명사를 배열로 변환
        val shuffledNounsArray = shuffledNouns.toTypedArray()
        Log.e("체크","3-명사배열재배치하기");

        // 랜덤하게 lier 이름 선택
        val randomIndex = (0 until names.size).random()
        val lierName = names[randomIndex]
        names.removeAt(randomIndex) // lier 이름을 배열에서 제거
        Log.e("체크","3-라이어선택하기");

        // 입력된 데이터를 랜덤한 순서로 섞음
        val shuffledNames = names.shuffled().toMutableList()
        Log.e("체크","3-유저랜덤섞기");

        // lier 이름을 배열의 무작위 위치에 삽입
        val randomPosition = (0..shuffledNames.size).random()
        shuffledNames.add(randomPosition, lierName)
        Log.e("체크","3-라이어임의위치배치하기");

        var tv8 = findViewById<TextView>(R.id.tv8)

        tv8.setText("설정을 완료했습니다!")

        var btn3 = findViewById<Button>(R.id.btn3)

        btn3.setOnClickListener {
            // Intent삽입.
            var intent3 = Intent(this, FourthActivity::class.java)

            intent3.putStringArrayListExtra("shuffledNames", ArrayList(shuffledNames))
            intent3.putExtra("lierName", lierName)

            intent3.putExtra("shuffledNouns", shuffledNounsArray)
            Log.e("체크","3-데이터전송");
            startActivity(intent3)
            this.finish();
        }
    }
}