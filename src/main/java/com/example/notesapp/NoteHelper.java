package com.example.notesapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class NoteHelper extends SQLiteOpenHelper {

    private static final String DATABASE="DATABASE";
    private  static final int VERSION=2;

    public NoteHelper(@Nullable Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table my_table(id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT,content TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists my_table");

    }

    public void insertData(String title,String content){


        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("content",content);
        database.insert("my_table",null,values);

    }

    public Cursor showData(){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =  sqLiteDatabase.rawQuery("select * from my_table order by id desc ",null);

        return cursor;
    }

    public void deleteData(String id){

        SQLiteDatabase database = this.getWritableDatabase();
        database.delete("my_table","id=?",new String[]{id});

    }
    public void updateData(String title, String content, String id){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("content", content);
        sqLiteDatabase.update("my_table",values,"id=?",new String[]{id});

    }

}
