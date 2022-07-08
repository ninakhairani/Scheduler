package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;

public class audio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        String url ="https://www.soundjay.com/nature/sounds/river-5.mp3";
        final MediaPlayer player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            player.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            player.prepare();
        }catch (IOException e){
            e.printStackTrace();
        }
        final ImageButton play = findViewById(R.id.playBtn);
        final ImageButton stop = findViewById(R.id.stopBtn);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.stop();
            }
        });
    }
}


