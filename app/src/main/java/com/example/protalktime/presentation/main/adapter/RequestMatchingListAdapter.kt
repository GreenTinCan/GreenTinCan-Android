package com.example.protalktime.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.protalktime.data.model.meeting.MatchingListBody
import com.example.protalktime.databinding.ItemMeetingListBinding

class RequestMatchingListAdapter(): ListAdapter<MatchingListBody, RequestMatchingListAdapter.MatchingListViewHolder>(MatchingListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchingListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMeetingListBinding.inflate(layoutInflater, parent, false)
        return MatchingListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchingListViewHolder, position: Int) {
        holder.bindItems(getItem(position))
    }

    inner class MatchingListViewHolder(private val binding: ItemMeetingListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(matchingInfo: MatchingListBody) {
            binding.matchingInfo = matchingInfo
            binding.executePendingBindings()
        }
    }

    class MatchingListDiffCallback() : DiffUtil.ItemCallback<MatchingListBody>() {
        override fun areItemsTheSame(
            oldItem: MatchingListBody,
            newItem: MatchingListBody
        ): Boolean {
            return oldItem.gatherId == newItem.gatherId
        }

        override fun areContentsTheSame(
            oldItem: MatchingListBody,
            newItem: MatchingListBody
        ): Boolean {
            return oldItem == newItem
        }
    }
}