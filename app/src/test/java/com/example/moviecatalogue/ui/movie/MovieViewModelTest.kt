package com.example.moviecatalogue.ui.movie


import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getVideo() {
        val videoEntity = viewModel.getVideo()
        assertNotNull(videoEntity)
        assertEquals(10, videoEntity.size)
    }
}