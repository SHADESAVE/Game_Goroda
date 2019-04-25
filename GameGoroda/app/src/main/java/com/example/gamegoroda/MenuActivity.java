package com.example.gamegoroda;

import android.app.ActionBar;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;


public class MenuActivity extends AppCompatActivity {
    String Theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Data data = new Data();

        Button buttonStart = (Button)findViewById(R.id.buttonStart);
        Button buttonResume = (Button)findViewById(R.id.buttonResume);

        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)buttonStart.getLayoutParams();
        params.bottomToBottom = R.id.buttonResume;
        float dp = this.getResources().getDisplayMetrics().density;

        if(data.checkFiles("UserHistory1",this)) {

            buttonResume.setVisibility(View.VISIBLE);
            params.topMargin = 204*(int)dp;
            buttonStart.requestLayout();
            Theme = "country";
        }

        if(data.checkFiles("UserHistory2",this)) {

            buttonResume.setVisibility(View.VISIBLE);
            params.topMargin = 204*(int)dp;
            buttonStart.requestLayout();
            Theme = "names";
        }

        if(data.checkFiles("UserHistory29",this)) {

            buttonResume.setVisibility(View.VISIBLE);
            params.topMargin = 204*(int)dp;
            buttonStart.requestLayout();
            Theme = "towns";
        }
    }

    public void buttonNewGame(View view) {

        Intent intent = new Intent (MenuActivity.this, ChooseActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

    public void buttonResume(View view) {

        Intent intent = new Intent (MenuActivity.this, GameActivity.class);
        intent.putExtra("Theme", Theme);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

    public void buttonSupport(View view){

        Intent intent = new Intent (MenuActivity.this, HowToPlayActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    public void buttonDLC(View view){

        Intent intent = new Intent (MenuActivity.this, DLCActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
}
