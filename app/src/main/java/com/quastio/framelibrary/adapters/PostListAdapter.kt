package com.quastio.framelibrary.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.quastio.framelibrary.Frame
import com.quastio.framelibrary.R
import com.quastio.framelibrary.models.Child

class PostListAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Child>() {

        override fun areItemsTheSame(oldItem: Child, newItem: Child): Boolean {
            return oldItem.data.thumbnail == newItem.data.thumbnail
        }

        override fun areContentsTheSame(oldItem: Child, newItem: Child): Boolean {
            return oldItem==newItem
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return PostListAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.post_list_list_item,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostListAdapterViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Child>) {
        differ.submitList(list)
    }

    class PostListAdapterViewHolder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView=itemView.findViewById(R.id.image_view)

        fun bind(item: Child) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }

            Frame.with(itemView.context)
                .load(imageView,item.data.thumbnail)

        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Child)
    }
}

