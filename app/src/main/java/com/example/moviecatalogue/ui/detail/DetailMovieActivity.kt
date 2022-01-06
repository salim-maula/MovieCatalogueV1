package com.example.moviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.moviecatalogue.data.VideoEntity
import com.example.moviecatalogue.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_VIDEO = "extra_video"
    }

    private lateinit var detailMovieBinding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(detailMovieBinding.root)
        supportActionBar?.hide()

        detailMovieBinding.back.setOnClickListener {
            finish()
        }

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailVideoViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val videoId = extras.getString(EXTRA_VIDEO)
            if (videoId != null) {
                viewModel.setSelectedVideo(videoId)
                detailMovie(viewModel.getDetailVideo() as VideoEntity)

            }
        }
    }


    private fun detailMovie(videoEntity: VideoEntity)  {
        detailMovieBinding.tvTitleDetail.text =videoEntity.title
        detailMovieBinding.tvGendreDetail.text = videoEntity.gendre
        detailMovieBinding.tvYearDetail.text = videoEntity.year
        detailMovieBinding.tvDurationDetail.text = videoEntity.duration
        detailMovieBinding.ratingDetail.rating = videoEntity.rating.div(2)
        detailMovieBinding.tvDescDetail.text = videoEntity.description
        Glide.with(this)
            .load(videoEntity.imagePath)
            .into(detailMovieBinding.imgPosterDetail)
    }
}