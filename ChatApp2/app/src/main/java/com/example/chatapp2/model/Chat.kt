package com.example.chatapp2.model

data class Chat(
    val id: String,
    val name: String,
    val participants: List<User>
)