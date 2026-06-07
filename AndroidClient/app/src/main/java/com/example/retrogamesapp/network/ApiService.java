package com.example.retrogamesapp.network;

import com.example.retrogamesapp.Game;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("games")
    Call<List<Game>> getGames(
            @Query("title") String title,
            @Query("dateFrom") String dateFrom,
            @Query("dateTo") String dateTo
    );
}
