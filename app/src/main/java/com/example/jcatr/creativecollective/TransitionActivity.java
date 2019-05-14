package com.example.jcatr.creativecollective;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class TransitionActivity extends Activity { //Displays loading gif

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);



            Intent front_translucent = new Intent(getApplication()
                    .getApplicationContext(), CameraService.class);
            front_translucent.putExtra("Front_Request", true);
            front_translucent.putExtra("Quality_Mode", 0);
            getApplication().getApplicationContext().startService(
                    front_translucent);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent( TransitionActivity.this, PhotoActivity.class);
                startActivity(i);
                finish();
            }
        }, 5500);

    }
}
