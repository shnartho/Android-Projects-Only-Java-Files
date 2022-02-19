package com.example.task_6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = null;
    }

    public void music(View view) {
        switch (view.getId()){
            case R.id.play:

                if(mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.havana);
                }

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {

                        stopMusic();
                    }
                });

                mediaPlayer.start();
                break;
            case R.id.pause:
                if(mediaPlayer != null) {
                    mediaPlayer.pause();
                }
                break;
            case R.id.stop:
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                    stopMusic();
                }
                break;
        }
    }

    private void stopMusic() {
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopMusic();
    }
}