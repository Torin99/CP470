package com.example.androidassignments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ChatDatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "messages";
    public static final int VERSION_NUM = 3;
    public static final String ID_COLUMN = "Id";
    public static final String MESSAGE_COLUMN = "Message";
    private SQLiteDatabase readDb;
    private SQLiteDatabase writeDb;
    public ChatDatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, VERSION_NUM);
        this.readDb = super.getReadableDatabase();
        this.writeDb = super.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i(this.getClass().getSimpleName(), "Calling onCreate()");

        String query = String.format("CREATE TABLE %s (%s INT AUTO_INCREMENT, %s VARCHAR(255))", TABLE_NAME, ID_COLUMN, MESSAGE_COLUMN);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(this.getClass().getSimpleName(), "Calling onUpgrade(), oldVersion=" + oldVersion + ", newVersion=" + newVersion);

        String query = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(query);
        this.onCreate(db);
    }
}
