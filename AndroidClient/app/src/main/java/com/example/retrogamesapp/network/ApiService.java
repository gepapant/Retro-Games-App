package com.example.retrogamesapp.network;

import com.example.retrogamesapp.Game;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Body;
import retrofit2.http.POST;

import com.example.retrogamesapp.LoginRequest;
import com.example.retrogamesapp.LoginResponse;

public interface ApiService {

    @GET("games")
    Call<List<Game>> getGames(
            @Query("title") String title,
            @Query("dateFrom") String dateFrom,
            @Query("dateTo") String dateTo
    );
    @POST("games")
    Call<Game> addGame(@Body Game game);

    @POST("login/")
    Call<LoginResponse> login(
        @Body LoginRequest request
);
}
