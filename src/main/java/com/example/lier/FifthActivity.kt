package com.example.lier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class FifthActivity : AppCompatActivity() {

    lateinit var fifthbtn1 : Button
    lateinit var fifthbtn2 : Button
    lateinit var fifthtv1 : TextView
    lateinit var fifthtv2 : TextView
    lateinit var shuffledNounsArray: Array<String>
    lateinit var shuffledNames: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        Log.e("체크","5------------------------");

        fifthbtn1 = findViewById(R.id.fifthbtn1)
        fifthbtn2 = findViewById(R.id.fifthbtn2)
        fifthtv1 = findViewById(R.id.fifthtv1)
        fifthtv2 = findViewById(R.id.fifthtv2)

        // FourthActivity로부터 데이터를 받아옵니다.
        shuffledNounsArray = intent.getStringArrayExtra("shuffledNouns") as Array<String>;
        shuffledNames = intent.getStringArrayListExtra("shuffledNames") ?: ArrayList()
        var lierName = intent.getStringExtra("lierName")
        var stringIndex = intent.getIntExtra("stringIndex", 0) // stringIndex를 가져옵니다
        Log.e("체크", "5-데이터받아오기")

        fifthbtn1.setOnClickListener {
            fifthtv1.text = "라이어는 $lierName 입니다."
            fifthtv2.text = "제시어는 ${shuffledNounsArray[stringIndex]} 입니다."

            fifthbtn1.visibility = View.GONE
            fifthbtn2.visibility = View.VISIBLE

            Log.e("체크", "5-라이어공개")
        }


        fifthbtn2.setOnClickListener {
            // 랜덤하게 lier 이름 선택
            val randomIndex = (0 until shuffledNames.size).random()
            val lierName = shuffledNames[randomIndex]
            shuffledNames.removeAt(randomIndex) // lier 이름을 배열에서 제거
            Log.e("체크","5-3라이어선택하기");
            Log.e("체크","5-3${shuffledNames[0]}");
            Log.e("체크","5-3${shuffledNames[1]}");
            Log.e("체크","5-3${shuffledNames[2]}");
            Log.e("체크","5-3${shuffledNames[3]}");

            // 입력된 데이터를 랜덤한 순서로 섞음
            val shuffledNames = shuffledNames.shuffled().toMutableList()
            Log.e("체크","5-3유저랜덤섞기");

            // lier 이름을 배열의 무작위 위치에 삽입
            val randomPosition = (0..shuffledNames.size).random()
            shuffledNames.add(randomPosition, lierName)
            Log.e("체크","5-3라이어임의위치배치하기");
            Log.e("체크","5-3$lierName");

            //stringIndex ++
            stringIndex++
            Log.e("체크","5-스트링인덱스상승 "+ stringIndex);

            // Intent삽입.
            var intent = Intent(this, FourthActivity::class.java)
            intent.putStringArrayListExtra("shuffledNames", ArrayList(shuffledNames))
            intent.putExtra("lierName", lierName)
            intent.putExtra("stringIndex", stringIndex) // stringIndex를 넘겨줍니다
            Log.e("체크","5-데이터전송" + stringIndex);
            intent.putExtra("shuffledNouns", shuffledNounsArray)
            Log.e("체크","5-셔플명사넘기기" + shuffledNounsArray);

            startActivity(intent)
            this.finish();
        }

    }
}