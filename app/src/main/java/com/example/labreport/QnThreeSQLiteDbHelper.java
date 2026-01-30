package com.example.labreport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class QnThreeSQLiteDbHelper extends SQLiteOpenHelper {
    public static final String database_name = "College";
    public static final String table_name = "Student";
    public static final String col_roll = "roll";
    public static final String col_name = "name";
    public static final String col_address = "address";

    public QnThreeSQLiteDbHelper(@Nullable Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+table_name+" (Roll INTEGER, Name TEXT, Address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);
    }

    public void insertData(int roll, String name, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col_roll, roll);
        cv.put(col_name, name);
        cv.put(col_address, address);
        db.insert(table_name, null, cv);
        db.close();
    }

    public Cursor displayData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+table_name, null);
        return cursor;
    }
}
