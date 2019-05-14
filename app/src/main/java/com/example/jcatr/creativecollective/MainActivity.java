package com.example.jcatr.creativecollective;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Splash Screen for Creative Collective

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        Intent i = new Intent( MainActivity.this, LoadingActivity.class);
        startActivity(i);
        finish();
        return true;
    }
}
