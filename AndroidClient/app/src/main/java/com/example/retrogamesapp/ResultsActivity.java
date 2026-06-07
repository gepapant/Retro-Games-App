package com.example.retrogamesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrogamesapp.adapter.GameAdapter;
import com.example.retrogamesapp.network.ApiService;
import com.example.retrogamesapp.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultsActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        recyclerView = findViewById(R.id.recyclerGames);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String title = getIntent().getStringExtra("title");
        String dateFrom = getIntent().getStringExtra("dateFrom");
        String dateTo = getIntent().getStringExtra("dateTo");

        ApiService apiService =
                RetrofitClient.getInstance().create(ApiService.class);

        Call<List<Game>> call =
                apiService.getGames(title, dateFrom, dateTo);

        call.enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {

                if(response.isSuccessful() && response.body() != null){

                    GameAdapter adapter =
                            new GameAdapter(response.body());

                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {

                Toast.makeText(
                        ResultsActivity.this,
                        "Error loading games",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
