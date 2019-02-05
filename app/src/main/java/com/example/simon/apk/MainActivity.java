package com.example.simon.apk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public static final String  EXTRA_MESSAGE = "com.example.apk.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.Aspinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.alkohol_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



    }

    void changeView(View view){
        Intent intent = new Intent(this, apkActivity.class);

        Spinner spinner = (Spinner) findViewById(R.id.Aspinner);

        String message = spinner.getSelectedItem().toString();

        intent.putExtra(EXTRA_MESSAGE , message);

        startActivity(intent);
    }
}
