package com.example.simon.apk;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SavedActivity extends AppCompatActivity {

    private apkViewModel mApkViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        final WordListAdapter adapter = new WordListAdapter(this);
        mApkViewModel = ViewModelProviders.of(this).get(apkViewModel.class);

        mApkViewModel.getAllApks().observe(this, new Observer<List<apk>>() {
            @Override
            public void onChanged(@Nullable final List<apk> apks) {

                adapter.setWords(apks);
            }
        });


        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            apk name = new apk(data.getStringExtra(NewWordActivity.EXTRA_REPLY),"wine",10);
            Log.d("apkName","Name:" + name);
            mApkViewModel.insert(name);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
