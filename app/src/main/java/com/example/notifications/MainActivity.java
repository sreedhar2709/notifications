package com.example.notifications;

import static com.example.notifications.MyFirebaseMessagingService.getToken;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,getToken(getApplicationContext()), Toast.LENGTH_SHORT).show();

    }
}