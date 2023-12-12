package com.example.lier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SixthActivity : AppCompatActivity() {

    private lateinit var shuffledNames: ArrayList<String>
    private lateinit var lierName: String
    private lateinit var shuffledNounsArray: Array<String>
    private var currentIndex = 0
    private var stringIndex = 0
    private var gtv2Visible = false
    private var gtv3Visible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        Log.e("체크","6---------------------진입---");

        //데이터를 받아옵니다.
        shuffledNames = intent.getStringArrayListExtra("shuffledNames") ?: ArrayList()
        Log.e("체크","6-5${shuffledNames[0]}");
        Log.e("체크","6-5${shuffledNames[1]}");
        Log.e("체크","6-5${shuffledNames[2]}");
        Log.e("체크","6-5${shuffledNames[3]}");
        lierName = intent.getStringExtra("lierName") ?: ""
        Log.e("체크","6-유저데이터받아오기");
        Log.e("체크","6-$lierName");

        // 스트링인덱스 받아오기
        stringIndex = intent.getIntExtra("stringIndex", 0)
        Log.e("체크","6-스트링인덱스받아오기");
        Log.e("체크","6-$stringIndex");

        // 섞인 명사 배열을 Intent에서 가져옵니다.
        shuffledNounsArray = intent.getStringArrayExtra("shuffledNouns") as Array<String>;
        Log.e("체크","6-명사배열받아오기");
        Log.e("체크","6-${shuffledNounsArray[0]}");
        Log.e("체크","6-${shuffledNounsArray[1]}");
        Log.e("체크","6-${shuffledNounsArray[2]}");
        Log.e("체크","6-${shuffledNounsArray[3]}");

        // 초기 상태에서 첫 번째 요소를 표시합니다.
        showCurrentName()
        Log.e("체크","6-첫번째표시");

        val nextButton = findViewById<Button>(R.id.btn4)
        nextButton.setOnClickListener {
            Log.e("체크","6-화면클릭(토글)");
            // 다음 이름을 표시합니다.
            currentIndex++
            if (currentIndex < shuffledNames.size) {
                showCurrentName()
                // nextButton을 누를 때 gtv2, gtv3을 숨깁니다.
                hideGtv2()
                hideGtv3()
            } else {
                moveToFifthActivity()
            }
        }

        var gtv2 = findViewById<TextView>(R.id.gtv2)
        var gtv3 = findViewById<TextView>(R.id.gtv3)

        gtv2.text = "" // 처음에는 내용을 빈 문자열로 초기화합니다.
        gtv3.text = "" // 처음에는 내용을 빈 문자열로 초기화합니다.

        gtv2.setOnClickListener {
            // gtv2를 터치하면 내용을 표시 또는 숨깁니다.
            toggleGtv2Visibility()
        }
        gtv3.setOnClickListener {
            // gtv2를 터치하면 내용을 표시 또는 숨깁니다.
            toggleGtv2Visibility()
        }
    }

    private fun showCurrentName() {
        val currentNameTextView = findViewById<TextView>(R.id.gtv1)
        currentNameTextView.text = shuffledNames[currentIndex]
    }

    private fun hideGtv2() {
        val gtv2 = findViewById<TextView>(R.id.gtv2)
        gtv2.text = "" // gtv2를 숨깁니다.
        gtv2Visible = false
        gtv3Visible = false
    }

    private fun hideGtv3() {
        val gtv3 = findViewById<TextView>(R.id.gtv3)
        gtv3.text = "" // gtv3를 숨깁니다.
        gtv3Visible = false
        gtv2Visible = false
    }

    private fun toggleGtv2Visibility() {
        Log.e("체크","6-확인토글");
        val gtv2 = findViewById<TextView>(R.id.gtv2)
        val gtv3 = findViewById<TextView>(R.id.gtv3)
        if (gtv2Visible || gtv3Visible) {
            gtv2.text = ""
            gtv3.text = ""
        } else {
            if (shuffledNames[currentIndex] == lierName) {
                Log.e("체크","6-라이어아닌유저표기");
                gtv2.text = "라이어입니다."
                gtv3.text = ""
            } else {
                Log.e("체크","6-라이어인유저표기");
                gtv2.text = "라이어가 아닙니다."
                gtv3.text = shuffledNounsArray[stringIndex].toString()
            }
        }
        Log.e("체크","6-활성비활성화");
        gtv2Visible = !gtv2Visible
        gtv3Visible = !gtv3Visible
    }

    private fun moveToFifthActivity() {
        // FifthActivity로 이동하는 Intent를 생성하고 시작합니다.
        val intent = Intent(this, FifthActivity::class.java)

        intent.putStringArrayListExtra("shuffledNames", ArrayList(shuffledNames))
        Log.e("체크","6-이름셔플배열넘기기");
        intent.putExtra("stringIndex", stringIndex) // stringIndex를 넘겨줍니다
        Log.e("체크","6-스트링인덱스넘기기");
        intent.putExtra("shuffledNouns", shuffledNounsArray)
        Log.e("체크","6-셔플명사넘기기");
        intent.putExtra("lierName", lierName)
        Log.e("체크","6-라이어넘기기");
        startActivity(intent)
        this.finish();
    }
}