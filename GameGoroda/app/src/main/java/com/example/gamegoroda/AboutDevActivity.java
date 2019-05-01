package com.example.gamegoroda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutDevActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dev);
    }
    protected void buttonBacktoMenu (View view) {
        Intent intent = new Intent(AboutDevActivity.this, MenuActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
}
