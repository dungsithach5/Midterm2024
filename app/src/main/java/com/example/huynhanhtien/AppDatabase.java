package com.example.huynhanhtien;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Question.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract Question questionDAO();
    private static AppDatabase instance;
    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance  = Room.databaseBuilder(context,
                    AppDatabase.class, "database_questions").build();
        }
        return instance;
    }

}