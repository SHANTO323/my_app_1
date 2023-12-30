package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DB_Handler extends SQLiteOpenHelper {

    private Context context;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myDB";
    private static final String DATABASE_TABLE = "TABLE_LIST";

    private static final String COLUMN_ID = "Id";
    private static final String COLUMN_NAME = "NAME";
    private static final String COLUMN_PRICE = "PRICE";
    public DB_Handler(Context context) {
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("ADD" , "DATABASE CREATED");
        String create = "CREATE TABLE " + DATABASE_TABLE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_PRICE + " TEXT" + ")";

        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + DATABASE_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addDatabase(model add){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME , add.getName());
        values.put(COLUMN_PRICE , add.getPrice());
        database.insert(DATABASE_TABLE,null,values);
        database.close();
        Log.d("ADD" , "DATA ADDED");
    }

    List<model> getData (){
        List<model> list = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        String select = "SELECT * FROM " + DATABASE_TABLE;
        Cursor cursor = database.rawQuery(select,null);
        if (cursor.moveToFirst()){
            do {
                model add = new model();
                add.setId(Integer.parseInt(cursor.getString(0)));
                add.setName(cursor.getString(1));
                add.setPrice(cursor.getString(2));
                list.add(add);
            }while(cursor.moveToNext());
        }
        return list;
    }
}
