package com.example.simon.apk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class apkActivity extends AppCompatActivity {

    public static final String  APK_RESULT = "com.example.apk.RESULT";
    public static final String  ALCOHOL_SORT = "com.example.apk.SORT";

    public int price = 0;
    public int amount = 0;
    public int alcohol = 0;

    public double APKresult;

    public String sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apk);

        Intent intent = getIntent();
        sort = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);



        TextView displayMessageView = findViewById(R.id.display_sort);
        displayMessageView.setText("Sort: " + sort);
    }
    void changeView(View view){
        Intent intent = new Intent(this, ResultActivity.class);

        EditText inputPrice = findViewById(R.id.input_price);
        price = Integer.parseInt(inputPrice.getText().toString());

        EditText inputAmount = findViewById(R.id.input_amount);
        amount = Integer.parseInt(inputAmount.getText().toString());

        EditText inputAlcohol = findViewById(R.id.input_alcohol);
        alcohol = Integer.parseInt(inputAlcohol.getText().toString());

        Log.d("intTestPrice","" + price);
        Log.d("intTestAmount","" + amount);
        Log.d("intTestAlcohol","" + alcohol);


        APKresult = ((alcohol * 0.01) * (amount * 10))/price;


        Log.d("intTestAPK","" + APKresult + " ml/kr");

        String message = APKresult + "";

        intent.putExtra(APK_RESULT , message);
        intent.putExtra(ALCOHOL_SORT , sort);

        startActivity(intent);
    }
}
