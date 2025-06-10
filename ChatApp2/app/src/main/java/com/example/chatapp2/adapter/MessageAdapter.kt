package com.example.chatapp2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp2.databinding.ItemMessageBinding
import com.example.chatapp2.model.Message

class MessageAdapter(
    private val items: List<Message>
) : RecyclerView.Adapter<MessageAdapter.VH>() {
    inner class VH(private val binding: ItemMessageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(msg: Message) {
            binding.tvSender.text = msg.sender.name
            binding.tvText.text = msg.text
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size
}