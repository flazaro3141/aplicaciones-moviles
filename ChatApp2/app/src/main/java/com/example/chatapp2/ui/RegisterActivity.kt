package com.example.chatapp2.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp2.databinding.ActivityChatListBinding
import com.example.chatapp2.model.Chat
import com.example.chatapp2.adapter.ChatListAdapter
import com.example.chatapp2.ui.ChatRoomActivity

class ChatListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatListBinding
    private val chats = mutableListOf<Chat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.rvChats.layoutManager = LinearLayoutManager(this)
        binding.rvChats.adapter = ChatListAdapter(chats) { chat ->
            startActivity(Intent(this, ChatRoomActivity::class.java).apply {
                putExtra("chatId", chat.id)
                putExtra("chatName", chat.name)
            })
        }

        binding.fabCreateChat.setOnClickListener {
            startActivity(Intent(this, CreateChatActivity::class.java))
        }
    }
}