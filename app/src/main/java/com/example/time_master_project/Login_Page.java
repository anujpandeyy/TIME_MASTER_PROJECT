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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Login_Page extends AppCompatActivity
{
    TextView textView4;
    EditText editTextText;

    EditText editTextTextPassword;

    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        textView4 = findViewById(R.id.textView4);
        editTextText = findViewById(R.id.editTextText);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        toggleButton = findViewById(R.id.toggleButton);
        ImageView twitterImageView = findViewById(R.id.imageView3);
        ImageView googleImageView = findViewById(R.id.imageView);
        ImageView instagramImageView = findViewById(R.id.imageView2);

        //IMAGE to social links -- 1)
        twitterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Twitter app or website
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"));
                startActivity(intent);
            }
        });

        googleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Google login page
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/"));
                startActivity(intent);
            }
        });

        instagramImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Instagram app or website
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"));
                startActivity(intent);
            }
        });
        //IMAGE to social links -- 1)



        //pass eye button -- 2)
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
        //pass eye button -- 2)
    }
    private boolean isValidEmail(CharSequence target)
    {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    public void create_account_page(View v)
    {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void Home_Screen(View v)
    {
        //from here we are doing validation --1)
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
        }
        //until here form validation --1)

        int atIndex = email.indexOf("@");
        String userName = email.substring(0, atIndex);

        // Pass the substring (user name) to HomeScreen
        Intent intent = new Intent(this, HomeScreen.class);
        intent.putExtra("EXTRA_USERNAME", userName);
        startActivity(intent);
    }

    public void forgotPassword(View view)
    {
        startActivity(new Intent(this, ForgotPasswordActivity.class));
    }

}