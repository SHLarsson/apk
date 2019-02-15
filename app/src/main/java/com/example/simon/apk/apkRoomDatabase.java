package com.example.simon.apk;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {apk.class}, version = 1)
public abstract class apkRoomDatabase extends RoomDatabase {

    public abstract apkDao apkDao();

    private static volatile apkRoomDatabase INSTANCE;

    static apkRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (apkRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            apkRoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}



