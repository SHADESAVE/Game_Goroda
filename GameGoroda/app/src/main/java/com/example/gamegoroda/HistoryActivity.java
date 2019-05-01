package com.example.gamegoroda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent intent = getIntent();
        boolean key = true;
        String k = intent.getStringExtra("K");
        String str = "";
        String fname = "UserHistory"+k;
        try {
            InputStream inputStream = this.openFileInput(fname);
            if(inputStream != null) {

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String tempString = "";

                while ((tempString = bufferedReader.readLine()) != null) {
                    if (key) {
                        str += "Вы: "+tempString+"\n";
                        key = false;
                    } else {
                        str += "Компьютер: "+tempString+"\n";
                        key = true;
                    }
                }
                inputStream.close();
            }

        } catch (FileNotFoundException e) {
            Log.e("FNFE", fname);
        } catch (IOException e) {

        }
        ((TextView)findViewById(R.id.textView9)).setText(str);
        ((TextView)findViewById(R.id.textView9)).setMovementMethod(new ScrollingMovementMethod());
    }
}
