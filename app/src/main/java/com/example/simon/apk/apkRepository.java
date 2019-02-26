package com.example.simon.apk;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class apkRepository {

    private apkDao mApkDao;
    private LiveData<List<apk>> mAllApks;

    apkRepository(Application application) {
        apkRoomDatabase db = apkRoomDatabase.getDatabase(application);
        mApkDao = db.apkDao();
        mAllApks = mApkDao.getAllApks();
    }

    LiveData<List<apk>> getAllApks() {
        return mAllApks;
    }
    //Log.d();


    public void insert (apk apk) {
        new insertAsyncTask(mApkDao).execute(apk);
    }

    private static class insertAsyncTask extends AsyncTask<apk, Void, Void> {

        private apkDao mAsyncTaskDao;

        insertAsyncTask(apkDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final apk... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}