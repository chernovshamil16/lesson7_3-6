package com.example.lesson7_3.presentation.fragment.notes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson7_3.databinding.ItemNoteBinding
import com.example.lesson7_3.domain.model.Note

class NotesAdapter : androidx.recyclerview.widget.ListAdapter<Note , NotesAdapter.NoteViewHolder>(
    NoteDiffUtil()
) {
    var onLongClick:((pos:Int) -> Unit)? = null
    var onClick: ((note: Note) ->Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context) , parent , false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NoteViewHolder(private var binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : Note) {
            binding.textTitle.text = item.title
            binding.textDesc.text = item.desc

            itemView.setOnClickListener {
                onClick?.invoke(item)
            }

            itemView.setOnLongClickListener {
                onLongClick?.invoke(adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }

    private class NoteDiffUtil : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

    }
}