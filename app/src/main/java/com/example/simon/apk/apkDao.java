package com.example.simon.apk;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface apkDao {

    @Insert
    void insert(apk APK);

    @Query("DELETE FROM apk_table")
    void deleteAll();

    @Query("SELECT * from apk_table ORDER BY APK ASC")
    LiveData< List<apk>> getAllNames();

}
