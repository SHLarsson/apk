package com.example.simon.apk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    public static final String  APK_RESULT = "com.example.apk.RESULT";
    public static final String  ALCOHOL_SORT = "com.example.apk.SORT";
    private String message;
    private String sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        message = intent.getStringExtra(apkActivity.APK_RESULT);
        sort = intent.getStringExtra(apkActivity.ALCOHOL_SORT);

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
        Intent intent = new Intent(this, NewWordActivity.class);
        intent.putExtra(APK_RESULT , message);
        intent.putExtra(ALCOHOL_SORT , sort);
        startActivity(intent);
    }
}
