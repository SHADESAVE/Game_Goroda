package com.example.gamegoroda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DLCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dlc);
    }
    protected void buttonAboutDev (View view) {
        Intent intent = new Intent(DLCActivity.this, AboutDevActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    protected void buttonAddWord (View view) {
        Intent intent = new Intent(DLCActivity.this, ChooseDLCActivity.class);
        intent.putExtra("WhatDo","добавить");
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    protected void buttonDelWord (View view) {
        Intent intent = new Intent(DLCActivity.this, ChooseDLCActivity.class);
        intent.putExtra("WhatDo","удалить");
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    protected  void buttonBackToMenu (View view) {
        Intent intent = new Intent(DLCActivity.this, MenuActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
}
