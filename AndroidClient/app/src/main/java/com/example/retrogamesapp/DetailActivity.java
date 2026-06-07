package com.example.retrogamesapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView imgCover;
    TextView title, platform, date, description;
    Button btnTrailer;

    String youtubeUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgCover = findViewById(R.id.imgCover);
        title = findViewById(R.id.txtTitle);
        platform = findViewById(R.id.txtPlatform);
        date = findViewById(R.id.txtReleaseDate);
        description = findViewById(R.id.txtDescription);
        btnTrailer = findViewById(R.id.btnTrailer);

        Intent intent = getIntent();

        String gameTitle = intent.getStringExtra("title");
        String gamePlatform = intent.getStringExtra("platform");
        String gameDate = intent.getStringExtra("date");
        String gameDescription = intent.getStringExtra("description");
        String imageUrl = intent.getStringExtra("imageUrl");
        youtubeUrl = intent.getStringExtra("youtubeUrl");

        title.setText(gameTitle);
        platform.setText(gamePlatform);
        date.setText(gameDate);
        description.setText(gameDescription);

        Glide.with(this)
                .load(imageUrl)
                .into(imgCover);

        btnTrailer.setOnClickListener(v -> {

            Intent browserIntent =
                    new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl));

            startActivity(browserIntent);
        });
    }
}
