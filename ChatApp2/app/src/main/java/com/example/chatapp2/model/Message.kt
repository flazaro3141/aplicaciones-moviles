package com.example.chatapp2.model

data class Message(
    val id: String,
    val chatId: String,
    val sender: User,
    val text: String,
    val timestamp: Long
)