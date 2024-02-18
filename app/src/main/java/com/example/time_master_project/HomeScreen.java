package com.example.time_master_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class HomeScreen extends AppCompatActivity
{
    TextView textView6, textView5;
    ImageView imageView8;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        textView6 = findViewById(R.id.textView6);
        textView5 = findViewById(R.id.textView5);
        imageView8 = findViewById(R.id.imageView8);

        //time and date - 1)
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.getDefault());
        String currentDate = dateFormat.format(calendar.getTime());
        textView6.setText(currentDate);
        //time and date - 1)

        //greetings+username - 2)
        Intent intent = getIntent();
        String userName = intent.getStringExtra("EXTRA_USERNAME");
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour < 12)
        {
            textView5.setText("Good morning!, " + userName);
        } else if (hour >= 12 && hour < 18)
        {
            textView5.setText("Good afternoon!, " + userName);
        } else {
            textView5.setText("Good evening!, " + userName);
        }
        //greetings+username - 2)
    }

    public void showPopupMenu(View view)
    {
        PopupMenu popupMenu = new PopupMenu(HomeScreen.this, imageView8);

        // Inflating popup menu from popup_menu.xml file
        popupMenu.getMenuInflater().inflate(R.menu.profile_popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem)
            {
                // Determine which menu item was clicked
                int id = menuItem.getItemId();

                // Handle menu item clicks
                if (id == R.id.menu_profile) {
                    // Handle click on Profiles menu item
                    Intent profilesIntent = new Intent(HomeScreen.this, Profiles.class);
                    startActivity(profilesIntent);
                    return true;
                } else if (id == R.id.menu_settings) {
                    // Handle click on Settings menu item
                    Intent settingsIntent = new Intent(HomeScreen.this, Settings.class);
                    startActivity(settingsIntent);
                    return true;
                } else if (id == R.id.menu_logout) {
                    // Handle click on Log Out menu item
                    Intent loginIntent = new Intent(HomeScreen.this, Login_Page.class);
                    startActivity(loginIntent);
                    finish(); // Close current activity to prevent going back
                    return true;
                }
                else
                {
                    return false;
                }
            }
        });
        popupMenu.show();
    }
}

