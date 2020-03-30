package com.example.ustocktrade;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABSE_NAME = "register.db";


    public DBHelper(Context context) {
        super(context, DATABSE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String Users_Table = "CREATE TABLE "+ AppDBMaster.User.TABLE_NAME+" ("+
                AppDBMaster.User._ID+" INTEGER PRIMARY KEY,"+
                AppDBMaster.User.COLUMN_NAME_EMAIL+ " TEXT,"+
                AppDBMaster.User.COLUMN_NAME_PASSWORD+ " TEXT);";

        db.execSQL(Users_Table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUser(String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppDBMaster.User.COLUMN_NAME_EMAIL,email);
        values.put(AppDBMaster.User.COLUMN_NAME_PASSWORD,password);

        long reault = db.insert(AppDBMaster.User.TABLE_NAME,null,values);

        if (reault > 0){
            return true;
        }else{
            return false;
        }
    }
}
