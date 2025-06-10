package com.example.chatapp2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp2.databinding.ItemSelectedUserBinding
import com.example.chatapp2.model.User

class ParticipantAdapter(
    private val items: List<User>
) : RecyclerView.Adapter<ParticipantAdapter.VH>() {
    inner class VH(private val binding: ItemSelectedUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) = binding.tvUserName.setText(user.name)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        ItemSelectedUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size
}