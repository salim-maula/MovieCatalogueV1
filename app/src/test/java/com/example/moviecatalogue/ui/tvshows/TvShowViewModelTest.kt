package com.example.moviecatalogue.ui.tvshows

import com.example.moviecatalogue.ui.movie.MovieViewModel
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest  {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getVideo() {
        val videoEntity = viewModel.getVideo()
        Assert.assertNotNull(videoEntity)
        Assert.assertEquals(10, videoEntity.size)
    }
}