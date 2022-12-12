package com.example.androidui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHomework : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_homework)

        val chatList = mutableListOf<Chat>()

        chatList.add(Chat("안녕하세요", false))
        chatList.add(Chat("안녕하세요", true))
        chatList.add(Chat("안녕하세요", false))
        chatList.add(Chat("안녕하세요", true))
        chatList.add(Chat("안녕하세요", false))
        chatList.add(Chat("안녕하세요", true))
        chatList.add(Chat("안녕하세요", false))
        chatList.add(Chat("안녕하세요", true))
        chatList.add(Chat("안녕하세요", false))
        chatList.add(Chat("안녕하세요", true))

        val recyclerView = findViewById<RecyclerView>(R.id.chatRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@RecyclerViewHomework)
        recyclerView.adapter = ChatRecyclerViewAdapter(chatList, LayoutInflater.from(this), this)
    }
}

class Chat(val taxt: String, val if_My: Boolean) {
}

class ChatRecyclerViewAdapter(
    val chatList: MutableList<Chat>,
    val inflater: LayoutInflater,
    val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView

        init {
            textView = itemView.findViewById(R.id.leftText)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = inflater.inflate(R.layout.chat_item_left, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = chatList.get(position)
        (holder as ViewHolder).textView.text = chat.taxt
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}
