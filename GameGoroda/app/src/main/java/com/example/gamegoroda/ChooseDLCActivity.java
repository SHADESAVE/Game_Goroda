package com.example.gamegoroda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseDLCActivity extends AppCompatActivity {

    String WhatDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_dlc);
        Intent intent = getIntent();
        WhatDo = intent.getStringExtra("WhatDo");
    }
    protected void buttonTowns (View view) {
        Intent intent = new Intent(ChooseDLCActivity.this, AddOrDelActivity.class);
        intent.putExtra("WhatDo", WhatDo);
        intent.putExtra("Theme", "ой город");
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    protected void buttonCountry (View view) {
        Intent intent = new Intent(ChooseDLCActivity.this, AddOrDelActivity.class);
        intent.putExtra("WhatDo", WhatDo);
        intent.putExtra("Theme", "ую страну");
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    protected void buttonName (View view) {
        Intent intent = new Intent(ChooseDLCActivity.this, AddOrDelActivity.class);
        intent.putExtra("WhatDo", WhatDo);
        intent.putExtra("Theme", "ое имя");
        startActivity(intent);
        overridePendingTransition(0,0);
    }
}
