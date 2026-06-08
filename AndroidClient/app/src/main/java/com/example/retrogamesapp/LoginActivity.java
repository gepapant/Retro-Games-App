package com.example.retrogamesapp;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class LoginActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> login());
    }

    private void login() {

        LoginRequest request = new LoginRequest(
                etUsername.getText().toString(),
                etPassword.getText().toString()
        );

        ApiService api =
                RetrofitClient.getInstance().create(ApiService.class);

        api.login(request).enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(
                    Call<LoginResponse> call,
                    Response<LoginResponse> response) {

                if(response.isSuccessful()) {

                    String token =
                            response.body().getToken();

                    SharedPreferences prefs =
                            getSharedPreferences(
                                    "APP_PREFS",
                                    MODE_PRIVATE);

                    prefs.edit()
                            .putString("TOKEN", token)
                            .apply();

                    startActivity(
                            new Intent(
                                    LoginActivity.this,
                                    MainActivity.class
                            )
                    );

                    finish();
                }
            }

            @Override
            public void onFailure(
                    Call<LoginResponse> call,
                    Throwable t) {

                Toast.makeText(
                        LoginActivity.this,
                        "Login Failed",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
