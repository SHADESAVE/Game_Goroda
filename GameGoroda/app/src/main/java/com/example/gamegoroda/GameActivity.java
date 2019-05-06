package com.example.gamegoroda;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class GameActivity extends AppCompatActivity {
    TextView textView;
    String theme;
    int k;
    int Score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        theme = intent.getStringExtra("Theme");

        switch (theme) {

            case "names":
                k = 2;
                break;

            case "towns":
                k = 29;
                break;

            case "country":
                k = 1;
                break;
        }
        textView = (TextView)findViewById(R.id.textView4);
    }
    protected void buttonSend (View view) {

        Data data = new Data();
        ((TextView)findViewById(R.id.textView4)).setText("");
        String pastText = ((TextView)findViewById(R.id.textView)).getText().toString(); //Считываем введённое программой слово
        String Message = ((EditText)findViewById(R.id.userText)).getText().toString().trim(); //Считываем введённое пользователем слово

        if(Message.isEmpty()) {
            ((TextView)findViewById(R.id.textView4)).setText(" - Поле ввода не должно быть пустым");
            return;
        }
        String lSymb = Message.substring(Message.length()-1);

        switch (lSymb) {
            case "ь":
            case "ъ":
            case "ы":
                lSymb = Message.substring(Message.length()-2, Message.length()-1);
                lSymb = lSymb.toUpperCase();
                break;

            default:
                lSymb = lSymb.toUpperCase();
        }
        String Responce = data.confirmWord(Message, lSymb, pastText, theme, k, getApplicationContext());
        Intent intent = new Intent(GameActivity.this, LooseActivity.class);

        switch (Responce) {
            case " - Это имя уже называлось":
            case " - Этот город уже назывался":
            case " - Эта страна уже называлась":
            case " - Указанного имени не существует":
            case " - Указанного города не существует":
            case " - Указанной страны не существует":
                ((TextView)findViewById(R.id.textView4)).setText(Responce);
                break;

            case "IAmWin":
                intent.putExtra("Message", "ВЫ ПРОИГРАЛИ!");
                intent.putExtra("Score", "" + Score);
                data.deleteHistory(this, k);
                startActivity(intent);
                break;

            case "YouWin":
                Score = Score + 1;
                intent.putExtra("Message", "ВЫ ВЫЙГРАЛИ!");
                intent.putExtra("Score", "" + Score);
                data.deleteHistory(this, k);
                startActivity(intent);
                break;

            default:
                ((TextView)findViewById(R.id.textView)).setText(Responce);
                ((EditText) findViewById(R.id.userText)).setText("");
                Score = Score + 1;
        }
    }
    protected void buttonDefeated(View view) {

        Intent intent = new Intent(GameActivity.this, LooseActivity.class);
        intent.putExtra("Message", "ВЫ ПРОИГРАЛИ!");
        intent.putExtra("Score", "" + Score);

        Data data = new Data();
        data.deleteHistory(this, k);
        startActivity(intent);
        //overridePendingTransition(0,0);
    }

    protected void buttonHowToPlay (View view) {
        Intent intent = new Intent(GameActivity.this, HowToPlayActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

    protected void buttonSearchHistory (View view) {
        Intent intent = new Intent(GameActivity.this, HistoryActivity.class);
        intent.putExtra("K",""+k);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
}
