package com.example.retrogamesapp.network;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor
        implements Interceptor {

    private Context context;

    public AuthInterceptor(Context context) {

        this.context = context;
    }

    @Override
    public Response intercept(
            Chain chain)
            throws IOException {

        SharedPreferences prefs =
                context.getSharedPreferences(
                        "APP_PREFS",
                        Context.MODE_PRIVATE
                );

        String token =
                prefs.getString(
                        "TOKEN",
                        ""
                );

        Request request =
                chain.request()
                        .newBuilder()
                        .addHeader(
                                "Authorization",
                                "Token " + token
                        )
                        .build();

        return chain.proceed(request);
    }
}
