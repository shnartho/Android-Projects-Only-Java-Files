package com.example.lab5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Studdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table StudDetails(name TEXT , studentNumber TEXT primary key, feedBack TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists StudDetails");
    }

    public Boolean insertuserdata(String name, String index, String feed) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("studentNumber", index);
        contentValues.put("feedBack", feed);
        long result = DB.insert("StudDetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Boolean updateuserdata(String name, String index, String feed) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("feedBack", feed);
        Cursor cursor = DB.rawQuery("Select * from StudDetails where studentNumber = ?", new String[]{index});
        if (cursor.getCount() > 0) {
            long result = DB.update("StudDetails", contentValues, "studentNumber=?", new String[]{index});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public Boolean deletedata(String studentNumber) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from StudDetails where studentNumber = ?", new String[]{studentNumber});
        if (cursor.getCount() > 0) {
            long result = DB.delete("StudDetails", "studentNumber=?", new String[]{studentNumber});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from StudDetails", null);
        return cursor;

    }
}
