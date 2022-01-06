package com.example.moviecatalogue.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.data.VideoEntity
import com.example.moviecatalogue.databinding.ItemsMovieBinding
import com.example.moviecatalogue.ui.detail.DetailMovieActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.VideoViewHolder>() {

    private var listVideo = ArrayList<VideoEntity>()

    fun setVideo(video: List<VideoEntity>?) {
        if (video == null) return
        this.listVideo.clear()
        this.listVideo.addAll(video)
    }

    class VideoViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(video: VideoEntity) {
            with(binding) {
                tvTitleMovie.text = video.title
                tvGendre.text = video.gendre
                chipAge.text = video.age
                chipDuration.text = video.duration
                rating.rating = video.rating.div(2)
                chipYear.text = video.year
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_VIDEO, video.videoId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(video.imagePath)
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemMovieBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = listVideo[position]
        holder.bind(video)
    }

    override fun getItemCount(): Int = listVideo.size
}