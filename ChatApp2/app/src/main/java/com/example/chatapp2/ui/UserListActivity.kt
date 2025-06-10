package com.example.chatapp2.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp2.databinding.ActivityUserListBinding
import com.example.chatapp2.model.User
import com.example.chatapp2.adapter.UserListAdapter

class UserListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserListBinding
    private val users = listOf(
        User("1","Alice"), User("2","Bob"), User("3","Charlie"), User("4","Diana")
    )
    private val selected = mutableSetOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        binding.rvUsers.adapter = UserListAdapter(users, selected) { u, c ->
            if (c) selected.add(u) else selected.remove(u)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> { returnSelected(); true }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() { returnSelected() }

    private fun returnSelected() {
        setResult(Activity.RESULT_OK, Intent().putParcelableArrayListExtra(
            "selected_users", ArrayList(selected)
        ))
        finish()
    }
}