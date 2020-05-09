package com.example.androidveritabankullanm_sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import androidx.annotation.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SQliteHelper extends SQLiteOpenHelper {
    private static final int database_VERSION=1;
    private static final String database_NAME="kitapDB";
    private static final String TABLE_BOOKS="kitaplar";
    private static final String book_id="id";
    private static final String book_TITLE="baslık";
    private static final String book_AUTHOR="yazar";
    private static final String CREATE_BOOK_TABLE="CREATE TABLE "
            +TABLE_BOOKS+ "(" +
            book_id +" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + book_TITLE+" TEXT,"
            + book_AUTHOR+" TEXT)";
        ;


    public SQliteHelper( Context context) {
       super(context, database_NAME, null, database_VERSION);//factory null geçilir
      //super(context, String.valueOf(context.getDatabasePath(database_NAME)), null, database_VERSION);//inter hafısaında
       // super(context,new File(Environment.getExternalStorageDirectory(),database_NAME).toString(),null,database_VERSION);//Telefonun hafıza kartına
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_BOOKS);//tablonun kendisini siler
        this.onCreate(db);
    }
    public void kitapEkle(kitap kitap){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues degerler =new ContentValues();
        degerler.put(book_TITLE,kitap.getBaslık());
        degerler.put(book_AUTHOR,kitap.getYazar());
        db.insert(TABLE_BOOKS,null,degerler);
        db.close();

    }
    public List<kitap>kitaplari_getir(){
        List<kitap>kitaplar=new ArrayList<>();
        String query="SElect + FROM"+TABLE_BOOKS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor  =db.rawQuery(query,null);
        kitap kitap= null;
        if (cursor.moveToFirst()){
            do{
                 kitap=new kitap();// boş constructor oluşturduk
                kitap.setId(Integer.parseInt(cursor.getString(0)));
                kitap.setBaslık(cursor.getString(1));
                kitap.setYazar(cursor.getString(2));
                kitaplar.add(kitap);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return kitaplar;

    }
}
