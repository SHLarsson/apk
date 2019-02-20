package com.example.simon.apk;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

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

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final apkDao mDao;

        PopulateDbAsync(apkRoomDatabase db) {
            mDao = db.apkDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            apk word = new apk("wine""wine",10);
            mDao.insert(word);
            apk word2= new apk("beer","wine",10);
            mDao.insert(word2);
            return null;
        }
    }
}




