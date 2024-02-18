package com.example.time_master_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity
{
    EditText editTextText3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        editTextText3 = findViewById(R.id.editTextText3);
    }


    private boolean isValidEmail(CharSequence target)
    {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public void OTP_SEND(View view)
    {
        String email = editTextText3.getText().toString().trim();

        if (TextUtils.isEmpty(email))
        {
            editTextText3.setError("Email cannot be empty");
            return;
        }
        if (!isValidEmail(email)) {
            editTextText3.setError("Invalid email format");
            return;
        }

//         TODO: Implement logic to send reset link to user's email

        Toast.makeText(this, "Reset link sent to " + email, Toast.LENGTH_SHORT).show();
    }


}