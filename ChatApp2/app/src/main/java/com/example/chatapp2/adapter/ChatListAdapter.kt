package com.example.chatapp2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp2.databinding.ItemChatBinding
import com.example.chatapp2.model.Chat

class ChatListAdapter(
    private val items: List<Chat>,
    private val onClick: (Chat) -> Unit
) : RecyclerView.Adapter<ChatListAdapter.VH>() {
    inner class VH(private val binding: ItemChatBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            binding.tvChatName.text = chat.name
            binding.tvParticipants.text = chat.participants.joinToString { it.name }
            binding.root.setOnClickListener { onClick(chat) }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size
}