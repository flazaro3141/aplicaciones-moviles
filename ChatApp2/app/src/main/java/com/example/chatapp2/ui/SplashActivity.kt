package com.example.chatapp2.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chatapp2.databinding.ActivitySplashBinding
import com.example.chatapp2.ui.ChatListActivity
import com.example.chatapp2.ui.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        if (auth.currentUser == null) {
            auth.signInAnonymously().addOnCompleteListener { proceed() }
        } else proceed()
    }

    private fun proceed() {
        binding.ivLogo.postDelayed({
            val prefs = getSharedPreferences("prefs", MODE_PRIVATE)
            val firstRun = prefs.getBoolean("first_run", true)
            if (firstRun) {
                prefs.edit().putBoolean("first_run", false).apply()
                startActivity(Intent(this, RegisterActivity::class.java))
            } else {
                startActivity(Intent(this, ChatListActivity::class.java))
            }
            finish()
        }, 1500)
    }
}