package com.example.crossword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        WordleBoard w = (WordleBoard)getIntent().getSerializableExtra("board");
        String display = "";
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 5; j++) {
                if (w.inCorrectSpot(w.answer, Character.toString(w.board[i][j]), j)) {
                    display += "\uD83D\uDFE9";
                    display += " ";
                } else if (w.in(w.answer, Character.toString(w.board[i][j])))
                {
                    display += "\uD83D\uDFE8";
                    display += " ";
                }
                else
                {
                    display += "\uD83D\uDD33";
                    display += " ";
                }

            }
            display += "\n";
        }
        TextView t = findViewById(R.id.textView);
        t.setText(display);

        Button b = findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WinActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}