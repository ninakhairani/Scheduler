package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class dbsql extends AppCompatActivity {
    private Button insert, read, updel;
    private ImageView photo;
    Button btnCamera, media;
    private static int REQUEST_IMAGE_CAPTURE = 0;
    private static final int CAMERA_PERMISSION_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbsql);

        insert = findViewById(R.id.insert);
        read = findViewById(R.id.read);
        updel = findViewById(R.id.updet);
        btnCamera = findViewById(R.id.cam);
        photo = findViewById(R.id.takeimg);
        media = findViewById(R.id.btn_multimedia);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dbsql.this, Insert.class));
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dbsql.this, ReadData.class));
            }
        });

        updel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dbsql.this, UpdateDelete.class));
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
            }
        });

        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dbsql.this, AksesMultimedia.class));
            }
        });
    }

    public void checkPermission(String permission, int requestCode){
        if(ContextCompat.checkSelfPermission(this, permission)== PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
            REQUEST_IMAGE_CAPTURE = 1;
            TakePicture();
        } else {
            Toast.makeText(this, "Permission already Granted", Toast.LENGTH_SHORT).show();
            REQUEST_IMAGE_CAPTURE = 1;
            TakePicture();
        }
    }

    private void TakePicture() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==CAMERA_PERMISSION_CODE){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Camera permission Granted", Toast.LENGTH_SHORT).show();
                REQUEST_IMAGE_CAPTURE = 1;
                TakePicture();
            } else {
                Toast.makeText(this, "Camera permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            photo.setImageBitmap(imageBitmap);
        }
    }
    public void back3(View view) {
        Intent back = new Intent(this,  MainActivity.class);
        this.startActivity(back);
    }

}