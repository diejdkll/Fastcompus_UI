package com.example.androidui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import java.util.zip.Inflater

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

        val phoneBookList = mutableListOf<PhoneBook>()
        for (i in 0..30) {
            phoneBookList.add(PhoneBook("" + i, "010-1111-000" + i))
        }

        val container = findViewById<LinearLayout>(R.id.container)
        val inflater = LayoutInflater.from(this)

        phoneBookList.forEach { phoneBook ->
            val phoneBookItem = inflater.inflate(R.layout.phonebook_item, null)

            val image = phoneBookItem.findViewById<ImageView>(R.id.image)
            val name = phoneBookItem.findViewById<TextView>(R.id.name)
            val number = phoneBookItem.findViewById<TextView>(R.id.number)

            image.setImageDrawable(resources.getDrawable(R.drawable.yellow_background, null))
            name.text = phoneBook.name
            number.text = phoneBook.number

            container.addView(phoneBookItem)

            phoneBookItem.setOnClickListener {
                startActivity(
                    Intent(this, PhoneBookDetailActivity::class.java).apply {
                        this.putExtra("name", phoneBook.name)
                        this.putExtra("number", phoneBook.number)
                    }
                )
            }

        }

    }
}

class PhoneBook(val name: String, val number: String)