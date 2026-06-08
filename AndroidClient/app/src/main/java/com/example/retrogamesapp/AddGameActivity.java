package com.example.retrogamesapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrogamesapp.network.ApiService;
import com.example.retrogamesapp.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddGameActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etPlatform;
    EditText etReleaseDate;
    EditText etDescription;

    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);

        etTitle = findViewById(R.id.etTitle);
        etPlatform = findViewById(R.id.etPlatform);
        etReleaseDate = findViewById(R.id.etReleaseDate);
        etDescription = findViewById(R.id.etDescription);

        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> saveGame());
    }

    private void saveGame() {

        Game game = new Game();

        game.setTitle(etTitle.getText().toString());
        game.setPlatform(etPlatform.getText().toString());
        game.setReleaseDate(etReleaseDate.getText().toString());
        game.setDescription(etDescription.getText().toString());

        ApiService api =
                RetrofitClient.getInstance().create(ApiService.class);

        api.addGame(game).enqueue(new Callback<Game>() {

            @Override
            public void onResponse(Call<Game> call,
                                   Response<Game> response) {

                Toast.makeText(
                        AddGameActivity.this,
                        "Game saved",
                        Toast.LENGTH_SHORT
                ).show();

                finish();
            }

            @Override
            public void onFailure(Call<Game> call,
                                  Throwable t) {

                Toast.makeText(
                        AddGameActivity.this,
                        "Save failed",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
