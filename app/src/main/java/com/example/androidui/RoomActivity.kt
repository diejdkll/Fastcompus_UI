package com.example.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
    }
}

@Entity
class UserProfile(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    @ColumnInfo(name = "first_name")
    val firstName: String
)