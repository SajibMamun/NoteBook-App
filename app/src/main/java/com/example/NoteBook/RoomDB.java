package com.example.NoteBook;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//add database entities
@Database(entities = {MainData.class},version = 1,exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    //create database instance
    private static RoomDB database;


    //Define Database name

    private static String DATABASE_NAME="database";

    public synchronized static RoomDB getInstance(Context context){
        if(database==null){
            database= Room.databaseBuilder(context.getApplicationContext(),RoomDB.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    public abstract MainDao mainDao();

}
