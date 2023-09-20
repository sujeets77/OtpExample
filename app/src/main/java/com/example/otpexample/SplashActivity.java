package com.example.otpexample;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity after the splash delay
                // Storing the token when the user logs in
                SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE);
                // Retrieving the token on app launch
                String accessToken = sharedPreferences.getString("access_token", null);
                Intent mainIntent;// Close the splash activity
                if (accessToken != null) {
                    // Token is valid, proceed with API requests
                    mainIntent = new Intent(SplashActivity.this, HomeActivity.class);
                } else {
                    // User needs to log in
                    mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                }
                startActivity(mainIntent);
                finish(); // Close the splash activity


            }
        }, SPLASH_DELAY);
    }
}
