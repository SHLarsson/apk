package com.example.simon.apk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.apk.REPLY";

    private EditText mEditWordView;
    Intent replyIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        Intent intent = getIntent();
        String message = intent.getStringExtra(ResultActivity.APK_RESULT);
        String sort = intent.getStringExtra(ResultActivity.ALCOHOL_SORT);

        TextView displaySort = findViewById(R.id.display_sort_end);
        displaySort.setText("Sort: " + sort);

        TextView displayApk = findViewById(R.id.display_apk_end);
        displayApk.setText("APK: " + message + " ml/kr");

        mEditWordView = findViewById(R.id.edit_word);

        replyIntent = new Intent(this, SavedActivity.class);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditWordView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, replyIntent);
                }
                startActivity(replyIntent);
                //finish();
            }
        });
    }
}