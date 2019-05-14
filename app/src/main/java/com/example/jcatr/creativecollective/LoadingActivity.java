package com.example.jcatr.creativecollective;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

public class LoadingActivity extends Activity {

    MediaPlayer mMediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        mMediaPlayer = MediaPlayer.create(this, R.raw.intro); //Play sound clip
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {  //Navigate to transitionactivity

                Intent i = new Intent( LoadingActivity.this, TransitionActivity.class);
                startActivity(i);
                finish();
            }
        }, 5500);

    }

    }

