package com.example.swapper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button swapButton;
    private Button compareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        swapButton = findViewById(R.id.swapButton);
        compareButton = findViewById(R.id.compareButton);

        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapTextFields();
            }
        });

        compareButton.setOnClickListener(v -> compareTextFields());
    }

    private void swapTextFields() {
        String temp = editText1.getText().toString();
        editText1.setText(editText2.getText().toString());
        editText2.setText(temp);
    }

    private void compareTextFields() {
        String text1 = editText1.getText().toString();
        String text2 = editText2.getText().toString();

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("text1", text1);
        intent.putExtra("text2", text2);
        startActivity(intent);
    }
}