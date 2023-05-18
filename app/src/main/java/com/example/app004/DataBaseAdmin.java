package com.example.app004;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class DataBaseAdmin extends SQLiteOpenHelper {

    private static final String TABLE_CLIENTES = "CREATE TABLE Clients "+
            "(Code INT PRIMARY KEY AUTOINCREMENT, Name TEXT, "+
            " LastName TEXT, Phone TEXT, Email TEXT) ";



    private static final String DROP_TABLE = "DROP TABLE IF EXISTS Clients";




    public DataBaseAdmin(@Nullable Context context,
                         @Nullable String name,
                         @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creacion de la estructura de las tablas

        String TABLE_CLIENTES = "CREATE TABLE Clients "+
                "(Code INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, "+
                " LastName TEXT, Phone TEXT, Email TEXT) ";

        db.execSQL(TABLE_CLIENTES);
        //inset into clients

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //los comandos requeridos cuando hay cambios en la estructura de las tablas





        db.execSQL(DROP_TABLE);
        db.execSQL(TABLE_CLIENTES);


    }
}
