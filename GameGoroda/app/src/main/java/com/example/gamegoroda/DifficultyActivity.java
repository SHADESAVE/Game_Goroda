package com.example.gamegoroda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
    }

    public void buttonEasy (View view) {
        Intent intent = new Intent (DifficultyActivity.this, GameActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

    public void buttonNormal (View view) {
        Intent intent = new Intent (DifficultyActivity.this, GameActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

    public void buttonHard (View view) {
        Intent intent = new Intent (DifficultyActivity.this, GameActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);

    }

    public void buttonFull (View view) {
        Intent intent = new Intent (DifficultyActivity.this, GameActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
}
