package com.example.androidui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class ResourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        findViewById<TextView>(R.id.text).setOnClickListener {
            (it as TextView).text = resources.getText(R.string.app_name) // text 바꾸기

            // background 바꾸기
           it.background = resources.getDrawable(R.drawable.blue_background, null)
//            it.background = ContextCompat.getDrawable(this, R.drawable.blue_background)
//            it.background = ResourcesCompat.getDrawable(resources, R.drawable.blue_background, null)
        }

        findViewById<ImageView>(R.id.image).setOnClickListener {
            // imageview 바꾸기
            (it as ImageView).setImageDrawable(
                resources.getDrawable(
                    R.drawable.logo_fb,
                    this.theme
                )
            )
        }

    }
}