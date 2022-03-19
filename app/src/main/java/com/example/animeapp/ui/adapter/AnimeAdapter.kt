package com.example.animeapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animeapp.data.model.Info
import com.example.animeapp.databinding.ItemAnimeBinding

class AnimeAdapter(
    val onItemClick: (Info) -> Unit
) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {
    private var list: List<Info> = arrayListOf()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimeAdapter.AnimeViewHolder {
        return AnimeViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeAdapter.AnimeViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    fun setList(list: List<Info>) {
        this.list = list
    }


    override fun getItemCount(): Int {
        return list.size
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(animeModel: Info) {
            binding.nameTv.text = animeModel.title
            binding.imageTv.setImageResource(animeModel.image)
            binding.root.setOnClickListener {
                onItemClick(animeModel)
            }
        }
    }
}