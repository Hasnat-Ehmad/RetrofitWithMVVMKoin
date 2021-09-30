package com.example.retrofitwithmvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitwithmvvm.model.Volume
import com.example.retrofitwithmvvm.model.VolumesResponse

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var movies = mutableListOf<Volume>()

    fun setMovieList(movies: VolumesResponse) {
        this.movies = movies.items!!.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_movie, parent, false)
        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.name.text = movie.volumeInfo?.getTitle()
        //Glide.with(holder.itemView.context).load(movie.volumeInfo?.getImageLinks()?.getThumbnail()).into(holder.imageview)
        if (movie.volumeInfo!!.getImageLinks() != null) {
            val imageUrl = movie.volumeInfo!!.getImageLinks()?.getSmallThumbnail()
                ?.replace("http://", "https://")
            Glide.with(holder.itemView)
                .load(imageUrl)
                .into(holder.imageview)
        }

    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.name)
    val imageview: ImageView = itemView.findViewById(R.id.imageview)
}