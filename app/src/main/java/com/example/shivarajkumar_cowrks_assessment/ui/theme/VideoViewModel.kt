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
            VideoModel("https://file-examples.com/storage/fef44df12666d835ba71c24/2017/04/file_example_MP4_480_1_5MG.mp4"),
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
            VideoModel("https://file-examples.com/storage/fef44df12666d835ba71c24/2017/04/file_example_MP4_480_1_5MG.mp4"),
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
            VideoModel("https://file-examples.com/storage/fef44df12666d835ba71c24/2017/04/file_example_MP4_480_1_5MG.mp4"),
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
            VideoModel("https://file-examples.com/storage/fef44df12666d835ba71c24/2017/04/file_example_MP4_480_1_5MG.mp4"),
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
            VideoModel("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
        )
        _videoList.value = videos
    }
}
