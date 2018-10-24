package com.ahasanidea.kotlin.androidservice


import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.os.IBinder

import android.widget.Toast

class PlayService : Service() {
 private lateinit var mediaPlayer: MediaPlayer
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this,"Service Created",Toast.LENGTH_LONG).show()
        val defaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(applicationContext, RingtoneManager.TYPE_RINGTONE)
        mediaPlayer=MediaPlayer.create(this,R.raw.song)
        mediaPlayer.isLooping=true
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show()
        mediaPlayer.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"Service Stoped",Toast.LENGTH_LONG).show()
        mediaPlayer.stop()
    }
}
