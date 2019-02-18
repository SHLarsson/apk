package com.example.simon.apk;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class apkViewModel extends AndroidViewModel {

    private apkRepository mRepository;

    private LiveData<List<apk>> mAllApks;

    public apkViewModel (Application application) {
        super(application);
        mRepository = new apkRepository(application);
        mAllApks = mRepository.getAllApks();
    }

    LiveData<List<apk>> getAllApks() { return mAllApks; }

    public void insert(apk apk) { mRepository.insert(apk); }
}
