package com.example.protalktime.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.protalktime.R
import com.example.protalktime.data.model.meeting.MatchingListBody
import com.example.protalktime.data.repository.meeting.MatchingRepository
import com.example.protalktime.databinding.ItemMeetingListBinding
import com.example.protalktime.presentation.main.viewmodel.MatchingViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MatchingListAdapter(): ListAdapter<MatchingListBody, MatchingListAdapter.MatchingListViewHolder>(MatchingListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchingListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMeetingListBinding.inflate(layoutInflater, parent, false)
        binding.btRequest.setOnClickListener{
//            Toast.ma/keText(this@MatchingListAdapter,"밥약 전송완료",Toast.LENGTH_SHORT)
        }
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