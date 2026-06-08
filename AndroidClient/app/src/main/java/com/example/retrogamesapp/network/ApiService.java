package com.example.retrogamesapp.network;

import com.example.retrogamesapp.Game;
import com.example.retrogamesapp.LoginRequest;
import com.example.retrogamesapp.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @GET("games/")
    Call<List<Game>> getGames(
            @Query("search") String search
    );

    @POST("games/")
    Call<Game> addGame(
            @Body Game game
    );

    @POST("login/")
    Call<LoginResponse> login(
            @Body LoginRequest request
    );
}
