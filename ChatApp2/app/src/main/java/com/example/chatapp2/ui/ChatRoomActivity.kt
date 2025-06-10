package com.example.chatapp2.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp2.databinding.ActivityChatRoomBinding
import com.example.chatapp2.model.Message
import com.example.chatapp2.adapter.MessageAdapter
import com.example.chatapp2.ui.UserListActivity

class ChatRoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatRoomBinding
    private val messages = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = intent.getStringExtra("chatName")

        binding.rvMessages.layoutManager = LinearLayoutManager(this)
        binding.rvMessages.adapter = MessageAdapter(messages)
        binding.btnSend.setOnClickListener {
            val text = binding.etMessage.text.toString().trim()
            if (text.isNotEmpty()) {
                // TODO: enviar mensaje a Firebase
                binding.etMessage.text?.clear()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu) =
        menuInflater.inflate(R.menu.menu_chat_room, menu).let { true }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_add -> {
            startActivity(Intent(this, UserListActivity::class.java).apply {
                putExtra("chatId", intent.getStringExtra("chatId"))
            })
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
}
