package com.example.time_master_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class activity_splash extends AppCompatActivity
{

        private static final int SPLASH_DURATION = 3000; // 2 seconds
        private ImageView logoImageView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logoImageView = findViewById(R.id.logoImageView);

        // Apply blinking animation
        applyBlinkingAnimation();

        // Delay the launch of the main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity
                Intent intent = new Intent(activity_splash.this, Login_Page.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DURATION);
    }

        private void applyBlinkingAnimation() {
        Animation blinkAnimation = new AlphaAnimation(1.0f, 0.0f);
        blinkAnimation.setDuration(700); // 500 milliseconds for each phase (on and off)
        blinkAnimation.setRepeatMode(Animation.REVERSE);
        blinkAnimation.setRepeatCount(Animation.INFINITE);

        logoImageView.startAnimation(blinkAnimation);
    }
}