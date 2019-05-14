package com.example.jcatr.creativecollective;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class LoopActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Loops round to start of application
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);

        MediaPlayer mMediaPlayer = new MediaPlayer();
        mMediaPlayer.stop();
        mMediaPlayer = MediaPlayer.create(this, R.raw.curtain);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {  //Navigate to mainactivity

                Intent i = new Intent(LoopActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 6250);
    }
}
