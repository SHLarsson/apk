package com.example.simon.apk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //String sort = intent.getStringExtra(MainActivity.ALCOHOL_SORT);

        TextView displayMessageView = findViewById(R.id.display_result);
        displayMessageView.setText(message + " ml/kr");



    }
}
