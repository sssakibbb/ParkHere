package com.example.parkhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.parkhere.driver.Login;

public class DriverORGarageOwnerActivity extends AppCompatActivity {
    Button carOwnerButton;
    Button garageOwnerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_orgarage_owner);


        carOwnerButton = findViewById(R.id.carOwnerButton);
        garageOwnerButton = findViewById(R.id.garageOwnerButton);


        carOwnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent carOwnerIntent = new Intent(DriverORGarageOwnerActivity.this, Login.class);
                startActivity(carOwnerIntent);
            }
        });


        garageOwnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}