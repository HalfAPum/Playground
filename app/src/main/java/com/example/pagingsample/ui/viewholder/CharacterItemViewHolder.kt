package com.example.pagingsample.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pagingsample.databinding.ListItemLayoutBinding
import com.example.pagingsample.model.Character
import com.example.pagingsample.ui.viewholder.base.BaseItemViewHolder

class CharacterItemViewHolder(private val binding: ListItemLayoutBinding) :
    BaseItemViewHolder<Character>(binding.root) {

    override fun update(item: Character) {
        binding.name.text = item.name
    }

    companion object {

        fun create(parent: ViewGroup) = CharacterItemViewHolder(
            ListItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }
}