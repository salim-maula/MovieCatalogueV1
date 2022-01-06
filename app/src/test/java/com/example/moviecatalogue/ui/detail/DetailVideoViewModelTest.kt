package com.example.moviecatalogue.ui.detail

import com.example.moviecatalogue.utils.DataDummy
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DetailVideoViewModelTest {

    private lateinit var viewModel: DetailVideoViewModel
    private val dummyVideo = DataDummy.generateDummyMovie()[0]
    private val videoId = dummyVideo.videoId

    @Before
    fun setUp() {
        viewModel = DetailVideoViewModel()
        viewModel.setSelectedVideo(videoId)
    }

    @Test
    fun getVideo() {
        viewModel.setSelectedVideo(dummyVideo.videoId)
        val videoEntity = viewModel.getDetailVideo()
        Assert.assertNotNull(videoEntity)
        assertEquals(dummyVideo.videoId, videoEntity.videoId)
        assertEquals(dummyVideo.year, videoEntity.year)
        assertEquals(dummyVideo.description, videoEntity.description)
        assertEquals(dummyVideo.imagePath, videoEntity.imagePath)
        assertEquals(dummyVideo.title, videoEntity.title)
        assertEquals(dummyVideo.rating, videoEntity.rating)
        assertEquals(dummyVideo.duration, videoEntity.duration)
    }
}