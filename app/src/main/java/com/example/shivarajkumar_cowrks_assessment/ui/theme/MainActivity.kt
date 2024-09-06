package com.example.shivarajkumar_cowrks_assessment.ui.theme


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shivarajkumar_cowrks_assessment.R


class MainActivity : AppCompatActivity() {
    private lateinit var videoViewModel: VideoViewModel
    private lateinit var videoAdapter: VideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.video_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        videoViewModel = ViewModelProvider(this).get(VideoViewModel::class.java)
        videoViewModel.videoList.observe(this, { videos ->
            videoAdapter = VideoAdapter(videos)
            recyclerView.adapter = videoAdapter
        })
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                // first visible item
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()
                // Update the currently playing video
                (recyclerView.adapter as VideoAdapter).updateCurrentPlayingPosition(firstVisiblePosition)
            }
        })

    }
}