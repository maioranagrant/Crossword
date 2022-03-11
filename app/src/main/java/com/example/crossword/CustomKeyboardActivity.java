package com.example.crossword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.HashMap;
import java.util.Map;

public class CustomKeyboardActivity extends AppCompatActivity {
    public String joe;
    public Map<String,Button> keysMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_keyboard);
        keysMap = new HashMap<String, Button>();
        joe = "";
        TableLayout t = findViewById(R.id.tabloLayout2);
        int max;
        for (int i = 0; i < 2; i++)
        {
            TableRow row = (TableRow)t.getChildAt(i);
            if (i == 0)
            {
                max = 10;
                for (int j = 0; j < max; j++)
                {
                    Button b = (Button)row.getChildAt(j);
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            joe += b.getText().toString().toLowerCase();
                            keysMap.put(b.getText().toString(),b);
                        }
                    });
                }
            }
            else if (i == 1)
            {
                max = 9;
                for (int j = 0; j < max; j++)
                {
                    Button b = (Button)row.getChildAt(j);
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            joe += b.getText().toString().toLowerCase();
                            keysMap.put(b.getText().toString(),b);
                        }
                    });
                }
            }
            else if (i == 2)
            {
                max = 7;
                for (int j = 1; j < max+1; j++)
                {
                    Button b = (Button)row.getChildAt(j);
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            joe += b.getText().toString().toLowerCase();
                            keysMap.put(b.getText().toString(),b);
                        }
                    });
                }
            }

        }
        Button enter = findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("here",joe);
            }
        });
    }
}