package com.example.time_master_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity
{
    ImageView imageView6;
    EditText editTextText;
    EditText editTextTextPassword;
    ToggleButton toggleButton;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView6 = findViewById(R.id.imageView6);
        editTextText = findViewById(R.id.editTextText);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        toggleButton = findViewById(R.id.toggleButton);
        ImageView googleImageView = findViewById(R.id.imageView);
        ImageView instagramImageView = findViewById(R.id.imageView2);
        ImageView twitterImageView = findViewById(R.id.imageView3);

        //social media image links -- 1)
        googleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Google account creation page
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/SignUp"));
                startActivity(intent);
            }
        });

        instagramImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Instagram account creation page
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/accounts/emailsignup/"));
                startActivity(intent);
            }
        });

        twitterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Twitter account creation page
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/signup"));
                startActivity(intent);
            }
        });
        //social media image links -- 1)

        //pass eye -- 2)
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    // Show password
                    editTextTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    toggleButton.setBackgroundResource(R.drawable.eye_open);
                }
                else
                {
                    // Hide password
                    editTextTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    toggleButton.setBackgroundResource(R.drawable.ic_eye_visibility);
                }
            }
        });
        //pass eye -- 2)
    }

    public void accnt_create(View v)
    {
        String email = editTextText.getText().toString().trim();
        String password = editTextTextPassword.getText().toString().trim();
        if (TextUtils.isEmpty(email))
        {
            editTextText.setError("Email cannot be empty");
            return;
        } else if (!isValidEmail(email))
        {
            editTextText.setError("Invalid email format");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextTextPassword.setError("Password cannot be empty");
            return;
        } else if (!isValidPassword(password)) {
            editTextTextPassword.setError("Invalid password format");
            return;
        }
        Toast.makeText(this, "Account created, successfully!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Login_Page.class));


    }

    private boolean isValidEmail(CharSequence target)
    {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    private boolean isValidPassword(String password)
    {
        // Password must be at least 8 characters long, containing at least one uppercase letter, one special character, and one numeric digit
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


}
