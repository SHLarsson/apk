package com.example.simon.apk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String message = intent.getStringExtra(apkActivity.APK_RESULT);
        String sort = intent.getStringExtra(apkActivity.ALCOHOL_SORT);

        TextView displaySort = findViewById(R.id.display_sort);
        displaySort.setText("Sort: " + sort);

        TextView displayResult = findViewById(R.id.display_result);
        displayResult.setText(message + " ml/kr");



    }
    void done(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    void save(View view){

    }
}
