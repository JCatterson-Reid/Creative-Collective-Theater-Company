package com.example.jcatr.creativecollective;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

public class MyBaseActivity extends Activity { //Used to reset application if idle

    public static final long DISCONNECT_TIMEOUT = 60000; // 1 min = 1 * 60 * 1000 ms


    private Handler disconnectHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            // todo
            return true;
        }
    });

    private Runnable disconnectCallback = new Runnable() {
        @Override
        public void run() {
            // Perform any required operation on disconnect
            Intent i = new Intent( getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
    };

    public void resetDisconnectTimer(){
        disconnectHandler.removeCallbacks(disconnectCallback);
        disconnectHandler.postDelayed(disconnectCallback, DISCONNECT_TIMEOUT);
    }

    public void stopDisconnectTimer(){
        disconnectHandler.removeCallbacks(disconnectCallback);
    }

    @Override
    public void onUserInteraction(){
        resetDisconnectTimer();
    }

    @Override
    public void onResume() {
        super.onResume();
        resetDisconnectTimer();
    }

    @Override
    public void onStop() {
        super.onStop();
        stopDisconnectTimer();
    }
}