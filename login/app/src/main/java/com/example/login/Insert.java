package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {
    EditText nama, nim;
    String mNama, mNim;

    private static final String TABLE_NAME = "tb_student";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_NIM = "nim";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Insert");
        }

        nama = (EditText) findViewById(R.id.nama);
        nim = (EditText) findViewById(R.id.nim);
    }

    public void insert(View view) {
        mNama = nama.getText().toString();
        mNim = nim.getText().toString();

        handler helper = new handler(this);
        SQLiteDatabase db;
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, mNama);
        values.put(KEY_NIM, mNim);

        db.insert(TABLE_NAME, null, values);
        nama.setText("");
        nim.setText("");
        Toast.makeText(this, "Berhasil!", Toast.LENGTH_SHORT).show();
    }

    public void back7 (View view){
        Intent intent = new Intent(this, dbsql.class);
        this.startActivity(intent);
    }
}