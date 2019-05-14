package com.example.jcatr.creativecollective;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;


//Takes speech recording of user, plays it back
//Message box thanking user for dumping emotions

//Second activity, navigates to PhotoActivity after user
public class SpeakActivity extends AppCompatActivity  {

    String pathSave = "";
    final int REQUEST_PERMISSION_CODE = 1000;
    MediaPlayer mMediaPlayer  = new MediaPlayer();
    MediaRecorder mMediaRecorder;
    Button btRecord, btStop;
    int conclusion;
    int recordingTime;
    Intent i = new Intent();
    private String outputFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             conclusion = extras.getInt("conc");
        }

        mMediaPlayer.stop();
        mMediaPlayer = MediaPlayer.create(this, R.raw.recording);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.start();

        final TextView editText = findViewById(R.id.tvRecord);
        recordingTime = 0;

        btRecord = findViewById(R.id.btRecord);
        btStop = findViewById(R.id.btStop);
        btStop.setEnabled(false);
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/speech.3gp";


        mMediaRecorder = new MediaRecorder();
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mMediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mMediaRecorder.setOutputFile(outputFile);

        btRecord.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                editText.setText("Press the stop button to end recording");

                try {
                    mMediaRecorder.prepare();
                    mMediaRecorder.start();
                } catch (IllegalStateException ise) {
                    // make something ...
                } catch (IOException ioe) {
                    // make something
                }

                btRecord.setEnabled(false);
                btStop.setEnabled(true);

                Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();

        }});

        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMediaRecorder.stop();
                mMediaRecorder.release();
                mMediaRecorder = null;

                Toast.makeText(getApplicationContext(), "Audio Recorder successful", Toast.LENGTH_LONG).show();
                //ss

                MediaPlayer player = new MediaPlayer();

                try {
                    player.setDataSource(outputFile);
                    player.prepare();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println("Exception of type : " + e.toString());
                    e.printStackTrace();
                }

                player.start();
                Toast.makeText(getApplicationContext(), "Playing Audio", Toast.LENGTH_LONG).show();


                //btRecord.setEnabled(true);
                btStop.setEnabled(false);


                new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                Intent i = new Intent( SpeakActivity.this, TransitionTwoActivity.class);
                                i.putExtra("conc",conclusion);
                                startActivity(i);
                                finish();
                            }
                        }, 9500);


            }
        });


    }
}










