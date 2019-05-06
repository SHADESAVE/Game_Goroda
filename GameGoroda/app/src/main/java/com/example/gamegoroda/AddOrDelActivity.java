package com.example.gamegoroda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class AddOrDelActivity extends AppCompatActivity {

    String theme;
    String Message;
    String WhatDo;
    int k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_del);
        Intent intent = getIntent();

        WhatDo = intent.getStringExtra("WhatDo");
        theme = intent.getStringExtra("Theme");

        ((Button)findViewById(R.id.button15)).setText(WhatDo);
        Message = "Как"+theme+" вы хотите "+WhatDo;
        ((TextView)findViewById(R.id.textView8)).setText(Message);

        switch (theme) {
            case "ой город":
                theme = "towns";
                k = 29;
                break;
            case "ую страну":
                theme = "country";
                k = 1;
                break;
            case "ое имя":
                theme = "names";
                k = 2;
                break;
        }
    }
    protected void buttonDoIt (View view) {
        ((TextView)findViewById(R.id.textViewAlert)).setText("");
        Message = ((EditText)findViewById(R.id.editText)).getText().toString().trim();

        if(Message.isEmpty()) {
            ((TextView)findViewById(R.id.textViewAlert)).setText(" - Поле ввода не должно быть пустым");
            return;
        }

        Message = Message.substring(0, 1).toUpperCase()+Message.substring(1);
        String fSymb = Message.substring(0,1).toLowerCase();

        switch (fSymb) {
            case "ь":
            case "ъ":
            case "ы":
                ((TextView)findViewById(R.id.textViewAlert)).setText(" - Слово не может начинаться с \"ь\", \"ъ\", \"ы\"");
                return;
            default:
        }
        boolean answer = false;

        switch (WhatDo) {
            case "добавить":
                answer = addWord(Message);
                if (!answer) {
                    ((TextView)findViewById(R.id.textViewAlert)).setText(" - Это слово уже присутствует в списке");
                    return;
                }
                ((TextView)findViewById(R.id.textViewAlert)).setText(" - Добавлено");
                //Toast toast = Toast.makeText(this, "Слово добавлено", Toast.LENGTH_SHORT);
                //toast.show();
                break;
            case "удалить":
                answer = deleteWord(Message);
                if (!answer) {
                    ((TextView)findViewById(R.id.textViewAlert)).setText(" - Это слово отсутсвует в списке");
                    return;
                }
                ((TextView)findViewById(R.id.textViewAlert)).setText(" - Удалено");
                //Toast toast2 = Toast.makeText(this, "Слово удалено", Toast.LENGTH_SHORT);
                //toast2.show();
                break;
        }
    }
    protected void buttonBackToMenu (View view) {
        Intent intent = new Intent(AddOrDelActivity.this, DLCActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

    protected boolean addWord (String message) {
        if (!checkWord(message))
            return false;
        int i = k-1;
        String FileName = theme + i;
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.openFileOutput(FileName, this.MODE_APPEND));
            outputStreamWriter.write("\n"+message+"\n");
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return true;

    }
    protected boolean deleteWord (String message) {
        if (checkWord(message))
            return false;
        String[] str = new String[k];
        str[0] = "";
        for (int i = 0; i < k; i++){
            String fName = theme+i;
            try {

                InputStream inputStream = this.openFileInput(fName);
                if(inputStream != null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String tempString = "";

                    while ((tempString = bufferedReader.readLine()) != null) {
                        if (!tempString.equals(message)) {
                            str[i] += tempString+"\n";
                            Log.e("dW", "this ->" + str[i]);
                        }
                    }
                    inputStream.close();
                }
            } catch (IOException e) {
                Log.e("Exception", "Failed reader: " + e.toString());
            }
        }

        for (int i = 0; i < k; i++) {
            String FileName = theme + i;
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.openFileOutput(FileName, this.MODE_PRIVATE));
                outputStreamWriter.write(str[i]);
                outputStreamWriter.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }
        }
        return true;
    }
    protected boolean checkWord (String message) {

        for (int i = 0; i < k; i++){

            String fName = theme+i;
            try {

                InputStream inputStream = this.openFileInput(fName);
                if(inputStream != null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String tempString = "";

                    while ((tempString = bufferedReader.readLine()) != null) {
                        if (tempString.equals(message))
                            return false;
                    }
                    inputStream.close();
                }
            } catch (IOException e) {
                Log.e("Exception", "Failed reader: " + e.toString());
            }
        }
        return true;
    }
}
