package com.example.shivarajkumar_cowrks_assessment.ui.theme


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.OptIn
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.recyclerview.widget.RecyclerView
import com.example.shivarajkumar_cowrks_assessment.R

class VideoAdapter(private val videos: List<VideoModel>) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {
    private var currentPlayingPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    @androidx.media3.common.util.UnstableApi
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videos[position])

        // Only play the video if it's the first visible item
        if (position == currentPlayingPosition) {
            holder.playVideo()
        } else {
            holder.pauseVideo()
        }
    }

    override fun getItemCount(): Int = videos.size
    fun updateCurrentPlayingPosition(position: Int) {
        if (position != currentPlayingPosition) {
            val previousPlayingPosition = currentPlayingPosition
            currentPlayingPosition = position

            // Notify the adapter to update both the previous and current playing items
            notifyItemChanged(previousPlayingPosition)
            notifyItemChanged(currentPlayingPosition)
        }
    }
    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val playerView: PlayerView = itemView.findViewById(R.id.player_view)
        private var player: ExoPlayer? = null

        @androidx.media3.common.util.UnstableApi
        fun bind(video: VideoModel) {

            if (player == null) {
                player = ExoPlayer.Builder(itemView.context).build()
                playerView.player = player
            }

            // Load video into player
            val mediaItem = MediaItem.fromUri(video.videoUri)
            player?.setMediaItem(mediaItem)
            player?.prepare()

        }
        fun playVideo() {
            player?.playWhenReady = true
        }

        fun pauseVideo() {
            player?.playWhenReady = false
        }
        fun releasePlayer() {
            player?.release()
            player = null
        }
    }
}

