package com.manue.smanuefy

import android.widget.MediaController
import android.widget.VideoView
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi

class VideoView : AppCompatActivity() {

    var simpleVideoView: VideoView? = null
    var mediaControls: MediaController? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        simpleVideoView = findViewById<View>(R.id.videoView) as VideoView

        if (mediaControls == null) {
            mediaControls = MediaController(this)
            mediaControls!!.setAnchorView(this.simpleVideoView)
        }

        simpleVideoView!!.setMediaController(mediaControls)
        simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.video))
        simpleVideoView!!.requestFocus()
        simpleVideoView!!.start()

        simpleVideoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video Completed", Toast.LENGTH_LONG).show()
        }

        simpleVideoView!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(applicationContext, "Error mientras se reproducia", Toast.LENGTH_LONG).show()
            false
        }
    }
}