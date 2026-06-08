package com.example.retrogamesapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText titleInput;
    EditText dateFromInput;
    EditText dateToInput;

    Button searchBtn;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleInput = findViewById(R.id.titleInput);
        dateFromInput = findViewById(R.id.dateFromInput);
        dateToInput = findViewById(R.id.dateToInput);

        searchBtn = findViewById(R.id.searchBtn);
        addButton = findViewById(R.id.btnAddGame);

        searchBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    ResultsActivity.class
            );

            intent.putExtra("title",
                    titleInput.getText().toString());

            intent.putExtra("dateFrom",
                    dateFromInput.getText().toString());

            intent.putExtra("dateTo",
                    dateToInput.getText().toString());

            startActivity(intent);
        });

        addButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    AddGameActivity.class
            );

            startActivity(intent);
        });
    }
}
