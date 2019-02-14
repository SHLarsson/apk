package com.example.simon.apk;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "apk_table")
public class apk {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "sort")
    private String sort;

    @ColumnInfo(name = "value")
    private double apkValue;

    public apk(String name,String sort,double apkValue) {
        this.name = name;
        this.sort = sort;
        this.apkValue = apkValue;
    }

    public String getName(){
        return this.name;
    }

    public String getSort(){
        return this.sort;
    }

    public double getValue(){
        return this.apkValue;
    }
}
