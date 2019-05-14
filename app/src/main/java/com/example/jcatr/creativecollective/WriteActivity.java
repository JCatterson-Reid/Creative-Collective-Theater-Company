package com.example.jcatr.creativecollective;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;



//First activity, navigates to SpeakActivity after user
//Class records user inut through use of buttons
public class WriteActivity extends MyBaseActivity {


    int conclusion;
    MediaPlayer mMediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        mMediaPlayer.reset(); //Play sound clip
        mMediaPlayer = MediaPlayer.create(this, R.raw.selection);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.start();



        //Initialise buttons, save selection for later use
        Button smileOne = findViewById(R.id.btnSmile1);
        smileOne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                conclusion = 1;
                Intent i = new Intent(WriteActivity.this, SpeakActivity.class);
                i.putExtra("conc",conclusion);
                startActivity(i);
            }
        });

        Button smileTwo = findViewById(R.id.btnSmile2);
        smileTwo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                conclusion = 1;
                Intent i = new Intent(WriteActivity.this, SpeakActivity.class);
                i.putExtra("conc",conclusion);
                startActivity(i);
            }
        });

        Button neutral = findViewById(R.id.btnNeutral);
        neutral.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                conclusion = 2;
                Intent i = new Intent(WriteActivity.this, SpeakActivity.class);
                i.putExtra("conc",conclusion);
                startActivity(i);
            }
        });

        Button frownOne  = findViewById(R.id.btnFrown1);
        frownOne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                conclusion = 3;
                Intent i = new Intent(WriteActivity.this, SpeakActivity.class);
                i.putExtra("conc",conclusion);
                startActivity(i);
            }
        });

        Button frownTwo = findViewById(R.id.btnFrown2);
        frownTwo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                conclusion = 3;
                Intent i = new Intent(WriteActivity.this, SpeakActivity.class);
                i.putExtra("conc",conclusion);
                startActivity(i);
            }
        });


    }

}
