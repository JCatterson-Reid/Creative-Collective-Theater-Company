package com.example.jcatr.creativecollective;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

//Takes photo but never saves it
//Message box thanking user for dumping emotions


public class PhotoActivity extends Activity { //Used to call CameraService

    public static final int CAMERA_REQUEST = 9999;
    ImageView tempPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        MediaPlayer mMediaPlayer = new MediaPlayer(); //Play audio clip
        mMediaPlayer.reset();
        mMediaPlayer = MediaPlayer.create(this, R.raw.post_camera);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        // mMediaPlayer.start();

        if(mMediaPlayer.isPlaying()){
            mMediaPlayer.stop();
            try {
                mMediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mMediaPlayer.start();

       // tempPhoto = (ImageView) findViewById(R.id.tempPhoto);

        // Find the last picture
        String[] projection = new String[]{
                MediaStore.Images.ImageColumns._ID,
                MediaStore.Images.ImageColumns.DATA,
                MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
                MediaStore.Images.ImageColumns.DATE_TAKEN,
                MediaStore.Images.ImageColumns.MIME_TYPE
        };

        //String selection = MediaStore.Audio.Media.DATA + " like " + "'%" + "/storage/emulated/0/Others/MYGALLERY" + "/%'";
        //Display image, using most recently taken photo

        final Cursor cursor = getApplicationContext().getContentResolver()
                .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, "",
                        null, MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC");

         // Put it in the image view
        if (cursor.moveToFirst()) {
            final ImageView imageView = (ImageView) findViewById(R.id.tempPhoto);
            String imageLocation = cursor.getString(1);
            File imageFile = new File(imageLocation);
            if (imageFile.exists()) {   // TODO: is there a better way to do this?
                Bitmap bm = BitmapFactory.decodeFile(imageLocation);
                imageView.setRotation(-90);
                imageView.setImageBitmap(bm);
            }
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(PhotoActivity.this, WriteActivity.class);
                startActivity(i);
                finish();
            }
        }, 6500 );
    }

}




