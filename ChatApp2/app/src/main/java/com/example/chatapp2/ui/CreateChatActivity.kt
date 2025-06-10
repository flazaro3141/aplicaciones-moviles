package com.example.chatapp2.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp2.databinding.ActivityCreateChatBinding
import com.example.chatapp2.model.User
import com.example.chatapp2.adapter.SelectedUserAdapter
import com.example.chatapp2.adapter.ParticipantAdapter
import com.example.chatapp2.ui.UserListActivity

class CreateChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateChatBinding
    private val selected = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.rvSelectedUsers.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvSelectedUsers.adapter = SelectedUserAdapter(selected)

        binding.rvParticipants.layoutManager = LinearLayoutManager(this)
        binding.rvParticipants.adapter = ParticipantAdapter(selected)

        binding.fabAddUsers.setOnClickListener {
            startActivityForResult(Intent(this, UserListActivity::class.java), 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            data?.getParcelableArrayListExtra<User>("selected_users")?.let {
                selected.clear()
                selected.addAll(it)
                binding.rvSelectedUsers.adapter?.notifyDataSetChanged()
                binding.rvParticipants.adapter?.notifyDataSetChanged()
            }
        }
    }
}