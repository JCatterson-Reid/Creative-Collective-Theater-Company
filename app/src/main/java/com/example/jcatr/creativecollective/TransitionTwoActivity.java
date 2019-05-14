package com.example.jcatr.creativecollective;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class TransitionTwoActivity extends Activity { //Navigates user to end page, using selections made by them

    Intent i = new Intent();
    int conclusion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            conclusion = extras.getInt("conc");
        }

            Intent front_translucent = new Intent(getApplication()
                    .getApplicationContext(), CameraService.class);
            front_translucent.putExtra("Front_Request", true);
            front_translucent.putExtra("Quality_Mode", 0);
            getApplication().getApplicationContext().startService(
                    front_translucent);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(conclusion==1) {

                    i = new Intent(TransitionTwoActivity.this, ConclusionActivity.class);
                }
                else if(conclusion ==2) {

                    i = new Intent(TransitionTwoActivity.this, ConclusionTwoActivity.class);
                }
                else if(conclusion==3) {

                    i = new Intent(TransitionTwoActivity.this, ConclusionThreeActivity.class);
                }
                Log.d("TEST", ""+i+" "+conclusion);
                startActivity(i);
                finish();
            }
        }, 2500);

    }
}
