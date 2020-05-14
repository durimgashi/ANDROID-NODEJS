package com.up.fiekproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button carsButton;
    Button rentsButton;
    Button usersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        carsButton = findViewById(R.id.carsButton);
        rentsButton = findViewById(R.id.rentsButton);
        usersButton = findViewById(R.id.usersButton);

        carsButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CarsActivity.class);
            startActivity(intent);
        });
        usersButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, UsersActivity.class);
            startActivity(intent);
        });
    }
}
