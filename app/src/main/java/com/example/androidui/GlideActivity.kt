package com.example.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        val imageView = findViewById<ImageView>(R.id.image)

        // 이미지 가져오기
        Glide
            .with(this)
            .load("https://www.k9web.com/wp-content/uploads/2021/02/white-pom-shaking-hands.jpg")
            .centerCrop() // 중심을 기준으로 정리
            .into(imageView)
    }
}