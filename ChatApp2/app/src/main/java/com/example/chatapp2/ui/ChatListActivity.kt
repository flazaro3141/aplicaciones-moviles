package com.example.chatapp2.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.databinding.ActivityChatListBinding
import com.example.chatapp.model.Chat
import com.example.chatapp2.com.example.chatapp2.adapter.ChatListAdapter

class ChatListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatListBinding
    private val chats = mutableListOf<Chat>() // TODO: persistir/recuperar datos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.rvChats.layoutManager = LinearLayoutManager(this)
        val adapter = ChatListAdapter(chats) { chat ->
            startActivity(Intent(this, ChatRoomActivity::class.java).apply {
                putExtra("chatId", chat.id)
                putExtra("chatName", chat.name)
            })
        }
        binding.rvChats.adapter = adapter
        binding.fabCreateChat.setOnClickListener {
            startActivity(Intent(this, CreateChatActivity::class.java))
        }
    }
}
