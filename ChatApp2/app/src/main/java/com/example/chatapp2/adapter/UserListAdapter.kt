package com.example.chatapp2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp2.databinding.ItemUserBinding
import com.example.chatapp2.model.User

class UserListAdapter(
    private val items: List<User>,
    private val selected: Set<User>,
    private val onChecked: (User, Boolean) -> Unit
) : RecyclerView.Adapter<UserListAdapter.VH>() {
    inner class VH(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.cbSelect.text = user.name
            binding.cbSelect.isChecked = selected.contains(user)
            binding.cbSelect.setOnCheckedChangeListener { _, isChecked -> onChecked(user, isChecked) }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size
}