package com.example.androidveritabankullanm_sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listemiz;
    Context context = this;
    SQliteHelper db = new SQliteHelper(context);
    List<kitap> list;
    ArrayAdapter<String>mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listemiz = findViewById(R.id.listemiz);
        db.onUpgrade(db.getWritableDatabase(), 1, 2);
        db.kitapEkle(new kitap("çalıkuşu", "REşat NURİ Güntekin" ));
        db.kitapEkle(new kitap("Spiens", "HARANİ" ));
        db.kitapEkle(new kitap("SHerloch homes", "Anonim" ));
        db.kitapEkle(new kitap("Sokrates", "ssss" ));
        list = db.kitaplari_getir();
        List<String>lisBaslık=new ArrayList<>();
        for (int i =0;i<list.size();i++){
            lisBaslık.add(i,list.get(i).getBaslık());
        }
       mAdapter=new ArrayAdapter<>(context,R.layout.satir_layout,R.id.listMetin,lisBaslık);
        //listemiz.setAdapter(mAdapter);

    }
}
