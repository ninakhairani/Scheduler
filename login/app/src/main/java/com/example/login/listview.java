package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class listview extends AppCompatActivity {

    ListView listView;
    SimpleAdapter adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] jdl; //deklarasi judul iem
    String[] ktr; //deklarasi keterangan item
    String[] img; //deklarasi image item

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView = (ListView) findViewById(R.id.list_item);
        jdl = new String[]{
                "Bali", "Paris", "Roma", "Istanbul", "New York City"
        };
        ktr = new String[]{
                "Ulun Danu Beratan Temple. Bali,Indonesia",
                "Menara Eiffel. Paris, Prancis.",
                "Colosseum. Kota Roma, Italia",
                "Mesjid Biru. Kota Istanbul,Turki",
                "New York City,AS"//jumlahnya harus sama dengan jumlah judul
        };
        img = new String[]{
                Integer.toString(R.drawable.bali), Integer.toString(R.drawable.paris), Integer.toString(R.drawable.roma),
                Integer.toString(R.drawable.istanbul), Integer.toString(R.drawable.ny)
        };
        mylist = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < jdl.length; i++) {
            map = new HashMap<String, String>();
            map.put("judul", jdl[i]);
            map.put("Keterangan", ktr[i]);
            map.put("Gambar", img[i]);
            mylist.add(map);
        }
        adapter = new SimpleAdapter(this, mylist, R.layout.list_view,
                new String[]{"judul", "Keterangan", "Gambar"}, new int[]{R.id.txt_judul, (R.id.txt_keterangan), (R.id.img)});
        listView.setAdapter(adapter);

    }

    public void back(View view) {
        Intent back = new Intent(this, MainActivity.class);
        this.startActivity(back);
    }

}