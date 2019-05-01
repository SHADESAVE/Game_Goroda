package com.example.gamegoroda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class HowToPlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);
        TextView textView = findViewById(R.id.textView6);
        String text = "Итак, перед начало игры Вам предстоит выбрать тему, по которой Вы будете играть. На данный момент их три:\n-Города\n-Страны\n-Имена\n\n" +
                "После выбора темы, вы попадаете на экран игры. Вы всегда начинаете игру первым, вводите слово в специальном поле посередине, между кнопкой \"Отправить\" и текстовым полем сверху.\n" +
                "\nПодробнее о том, как играть:\nКаждый участник игры называет реально существующий(ую) город/страну/имя, название которого(ой) начинается на ту букву, которой оканчивается название предыдущего участника.\n" +
                "Исключением в правилах игры являются названия, оканчивающиеся на «Ь» (мягкий знак) и «Ъ» (твёрдый знак), а так же «Ы»." +
                "При этом ранее названные города нельзя употреблять снова. Первый участник выбирает любой город. Во время игры запрещается пользоваться справочным материалом. " +
                "Игра оканчивается, когда очередной участник не может назвать нового(ой) города/страны/имени, или когда закончатся слова на эту букву." +
                "\n\nПример игры:\n" +
                "1-й участник: Ростов\n" +
                "2-й участник: Вологда\n" +
                "1-й участник: Актюбинск\n" +
                "2-й участник: Краков\n" +
                "1-й участник: Витебск\n" +
                "2-й участник: Краснодар\n" +
                "1-й участник: Рим и т.д.\n";
        textView.setText(text);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    protected void buttonBackToMenu (View view) {
        Intent intet = new Intent(HowToPlayActivity.this, MenuActivity.class);
        startActivity(intet);
        overridePendingTransition(0,0);
    }
}
