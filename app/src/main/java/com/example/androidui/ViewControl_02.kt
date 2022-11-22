package com.example.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class ViewControl_02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_control02)

        // 뷰를 코틀린 파일(Activity)로 가져오는 방법
        val textViewOne = findViewById<TextView>(R.id.textViewOne)
        val buttonOne = findViewById<Button>(R.id.buttonOne)
        Log.d("testt", textViewOne.text.toString())

        // 풀버전
        val clickListener = object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Log.d("testt", "버튼 클릭!")
            }
        }
        buttonOne.setOnClickListener(clickListener)

        // 축약 버전1(익명 함수)
        buttonOne.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Log.d("testt", "버튼 클릭!")
            }
        })

        // Listener 사용 방법, 람다 버전
        buttonOne.setOnClickListener{
            // 버튼이 클릭되었을 때 동작할 코드
            Log.d("testt", "버튼 클릭!")
        }
    }
}