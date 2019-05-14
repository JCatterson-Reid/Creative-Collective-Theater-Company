package com.example.jcatr.creativecollective;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class ConclusionThreeActivity extends Activity {

    ImageView warningImage;
    @Override
    protected void onCreate(Bundle savedInstanceState){ //Loops round to start of application
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclusion_three);

        warningImage = (ImageView) findViewById(R.id.concImageFour);

        MediaPlayer mMediaPlayer = new MediaPlayer();
        mMediaPlayer.stop();
        mMediaPlayer = MediaPlayer.create(this, R.raw.warning);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.start();

        Animation animation = new AlphaAnimation(1, 0); //to change visibility from visible to invisible
        animation.setDuration(1000); //1 second duration for each animation cycle
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE); //repeating indefinitely
        animation.setRepeatMode(Animation.REVERSE); //animation will start from end point once ended.
        warningImage.startAnimation(animation); //to start animation


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() { //Navigate to postphotoactivity

                Intent i = new Intent( ConclusionThreeActivity.this, PostPhotoActivity.class);
                startActivity(i);
                finish();
            }
        }, 14500); }
}
