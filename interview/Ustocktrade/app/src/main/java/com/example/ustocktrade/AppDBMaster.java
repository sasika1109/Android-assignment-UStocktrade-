package com.example.ustocktrade;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public final class AppDBMaster {

    public AppDBMaster() {
    }

    protected static class User implements BaseColumns{

        protected static final String TABLE_NAME = "users";
        protected static final String COLUMN_NAME_EMAIL = "email";
        protected static final String COLUMN_NAME_PASSWORD = "password";
    }


}
