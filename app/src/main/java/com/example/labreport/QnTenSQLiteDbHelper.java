package com.example.labreport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class QnTenSQLiteDbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "CarDB";
    private static final String TABLE_NAME = "cars";

    public QnTenSQLiteDbHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, model TEXT, year INTEGER, price REAL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertCar(String model, int year, double price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("model", model);
        cv.put("year", year);
        cv.put("price", price);
        db.insert(TABLE_NAME, null, cv);
    }

    public ArrayList<QnTenCarModel> getAllCars() {
        ArrayList<QnTenCarModel> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        while (cursor.moveToNext()) {
            list.add(new QnTenCarModel(
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getDouble(3)
            ));
        }
        cursor.close();
        return list;
    }
}
