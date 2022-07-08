package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AksesMultimedia extends AppCompatActivity {

    Button audioBtn, imageBtn, videoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioBtn = findViewById(R.id.audioBtn);
        imageBtn = findViewById(R.id.imageBtn);
        videoBtn = findViewById(R.id.videoBtn);

        audioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AksesMultimedia.this, audio.class);
                startActivity(intent);
            }
        });

        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AksesMultimedia.this, Image.class);
                startActivity(intent);
            }
        });

        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AksesMultimedia.this, video.class);
                startActivity(intent);
            }
        });
    }
    public void back8(View v) {
        Intent intent = new Intent(AksesMultimedia.this, dbsql.class);
        startActivity(intent);
    }
}
