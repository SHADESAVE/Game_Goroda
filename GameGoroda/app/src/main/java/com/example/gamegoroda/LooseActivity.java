package com.example.gamegoroda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.InputStreamReader;

public class LooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loose);

        Intent intent = getIntent();
        String mess = intent.getStringExtra("Message");
        String Score = intent.getStringExtra("Score");
        Score = "Ваш счёт: " + Score;

        ((TextView)findViewById(R.id.textView2)).setText(mess);
        ((TextView)findViewById(R.id.textView3)).setText(Score);
    }

    public void buttonRestartGame(View view) {

        Intent intent = new Intent(LooseActivity.this, ChooseActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

    public void buttonBackToMenu(View view) {

        Intent intent = new Intent(LooseActivity.this, MenuActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
}
