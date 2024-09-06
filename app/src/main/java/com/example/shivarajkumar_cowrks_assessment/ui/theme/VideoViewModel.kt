package com.example.shivarajkumar_cowrks_assessment.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class VideoViewModel : ViewModel() {

    private val _videoList = MutableLiveData<List<VideoModel>>()
    val videoList: LiveData<List<VideoModel>> = _videoList

    init {
        loadVideos()
    }

    private fun loadVideos() {
        val videos = listOf(
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
            VideoModel("https://filesamples.com/samples/video/mp4/sample_640x360.mp4"),
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
                    VideoModel("https://filesamples.com/samples/video/mp4/sample_640x360.mp4"),
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
                    VideoModel("https://filesamples.com/samples/video/mp4/sample_640x360.mp4"),
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
                    VideoModel("https://filesamples.com/samples/video/mp4/sample_640x360.mp4"),
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
        )
        _videoList.value = videos
    }
}
