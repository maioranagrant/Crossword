package com.example.crossword;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    String currentAnswer = "";
    public String word;
    ArrayList<String> list;
    public TableLayout tblLayout;
    private Map<String,Button> keysMap;
    private Map<String,String> validGuessesMap;
    String joe;
    int counter = 0;
    int buttonNum;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
//        EditText edit = findViewById(R.id.edt4);
//        edit.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        Random r = new Random();
        buttonNum = 0;

        tblLayout = findViewById(R.id.tableLayout);
//        InputMethodManager im = (InputMethodManager)getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//        edit.requestFocus();
//        im.showSoftInput(edit, InputMethodManager.SHOW_FORCED);


        list = new ArrayList<String>();
        validGuessesMap = new HashMap<String,String>();

        try {
            InputStream is = getApplicationContext().getAssets().open("answerwords.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while(reader.ready()) {
                String line = reader.readLine();
                list.add(line);
            }
        }
        catch (Exception e)
        {
            Log.d("debug",e.toString());
        }

        word = list.get(r.nextInt(list.size()-1)).toLowerCase(Locale.ROOT);


        WordleBoard w = new WordleBoard(word);
        w.setAnswer(word);

        try {
            InputStream is = getApplicationContext().getAssets().open("unusable-words.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while(reader.ready()) {
                String line = reader.readLine();
                validGuessesMap.put(line,line);
            }
        }
        catch (Exception e)
        {
            Log.d("debug",e.toString());
        }




        Button buttonEnter = findViewById(R.id.enter);
        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validGuessesMap.containsKey(joe))
                {
                    return;
                }
                for (int i = 0; i < 5; i++)
                {
                    w.setLetter(counter,i,joe.charAt(i));
                }
                changeColors(counter);


                if (counter < 5)
                {
                    counter++;
                    joe = "";
                    if (w.checkWord())
                    {
                        Intent intent = new Intent(MainActivity.this, WinActivity.class);
                        intent.putExtra("board",w);
                        startActivity(intent);
                    }


                }
                else
                {
                    if (w.checkWord())
                    {
                        Intent intent = new Intent(MainActivity.this, WinActivity.class);
                        intent.putExtra("board",w);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent = new Intent(MainActivity.this, LossActivity.class);
                        intent.putExtra("board",w);
                        startActivity(intent);
                    }
                }
            }
        });
        Button buttonBackspace = findViewById(R.id.backspace);
        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (joe.length() > 0)
                {
                    joe = joe.substring(0,joe.length()-1);
                    Log.d("h",joe);
                    tblLayout = (TableLayout)findViewById(R.id.tableLayout);
                    TableRow row0 = (TableRow)tblLayout.getChildAt(counter); // Here get row id depending on number of row
                    for (int j = 0; j < 5; j++)
                    {
                        Button select0 = (Button)row0.getChildAt(j);
                        if (j > joe.length()-1)
                        {
                            select0.setText("");
                        }
                        else
                        {
                            select0.setText(joe.substring(j,j+1));
                        }

                    }
                }

            }
        });
//        edit.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
//            {
//                tblLayout = (TableLayout)findViewById(R.id.tableLayout);
//                TableRow row0 = (TableRow)tblLayout.getChildAt(counter); // Here get row id depending on number of row
//                for (int j = 0; j < 5; j++)
//                {
//                    Button select0 = (Button)row0.getChildAt(j);
//                    if (j > edit.getText().toString().length()-1)
//                    {
//                        select0.setText("");
//                    }
//                    else
//                    {
//                        select0.setText(edit.getText().toString().substring(j,j+1));
//                    }
//
//                }
//
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//        edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
//                if ( (actionId == EditorInfo.IME_ACTION_DONE) || ((event.getKeyCode() == KeyEvent.KEYCODE_ENTER) && (event.getAction() == KeyEvent.ACTION_UP ))){
//                    for (int i = 0; i < 5; i++)
//                    {
//                        w.setLetter(counter,i,edit.getText().toString().toLowerCase().charAt(i));
//                    }
//                    changeColors(counter);
//
//                    if (counter < 5)
//                    {
//                        counter++;
//                        edit.setText("");
//                        if (w.checkWord())
//                        {
//                            Intent intent = new Intent(MainActivity.this, WinActivity.class);
//                            intent.putExtra("board",w);
//                            startActivity(intent);
//                        }
//
//
//                    }
//                    else
//                    {
//                        if (w.checkWord())
//                        {
//                            Intent intent = new Intent(MainActivity.this, WinActivity.class);
//                            intent.putExtra("board",w);
//                            startActivity(intent);
//                        }
//                        else
//                        {
//                            Intent intent = new Intent(MainActivity.this, LossActivity.class);
//                            intent.putExtra("board",w);
//                            startActivity(intent);
//                        }
//                    }
//
//
//                    return true;
//                }
//                else if ((actionId == EditorInfo.IME_ACTION_DONE) || ((event.getKeyCode() == KeyEvent.KEYCODE_BACK) && (event.getAction() == KeyEvent.ACTION_UP )))
//                {
//
//                    return true;
//                }
//
//                    return false;
//
//            }
//        });


        keysMap = new HashMap<String, Button>();
        joe = "";
        TableLayout t = findViewById(R.id.tabloLayout2);
        int max;
        for (int k = 0; k < 3; k++)
        {
            TableRow row = (TableRow)t.getChildAt(k);
            if (k == 0)
            {
                max = 10;
                for (int j = 0; j < max; j++)
                {
                    Button b = (Button)row.getChildAt(j);
                    b.setBackgroundColor(Color.WHITE);
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (joe.length() == 5)
                            {
                                return;
                            }
                            joe += b.getText().toString().toLowerCase();
                            if (keysMap.get(b.getText()) == null)
                            {
                                keysMap.put(b.getText().toString(), b);
                            }
                            tblLayout = (TableLayout)findViewById(R.id.tableLayout);
                            TableRow row0 = (TableRow)tblLayout.getChildAt(counter); // Here get row id depending on number of row
                            for (int j = 0; j < 5; j++)
                            {
                                Button select0 = (Button)row0.getChildAt(j);
                                if (j > joe.length()-1)
                                {
                                    select0.setText("");
                                }
                                else
                                {
                                    select0.setText(joe.substring(j,j+1));
                                }

                            }
                        }
                    });
                }
            }
            else if (k == 1)
            {
                max = 9;
                for (int j = 0; j < max; j++)
                {
                    Button b = (Button)row.getChildAt(j);
                    b.setBackgroundColor(Color.WHITE);
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (joe.length() == 5)
                            {
                                return;
                            }
                            joe += b.getText().toString().toLowerCase();
                            if (keysMap.get(b.getText()) == null)
                            {
                                keysMap.put(b.getText().toString(), b);
                            }
                            tblLayout = (TableLayout)findViewById(R.id.tableLayout);
                            TableRow row0 = (TableRow)tblLayout.getChildAt(counter); // Here get row id depending on number of row
                            for (int j = 0; j < 5; j++)
                            {
                                Button select0 = (Button)row0.getChildAt(j);
                                if (j > joe.length()-1)
                                {
                                    select0.setText("");
                                }
                                else
                                {
                                    select0.setText(joe.substring(j,j+1));
                                }

                            }
                        }
                    });
                }
            }
            else if (k == 2)
            {
                max = 7;
                for (int j = 1; j < max+1; j++)
                {
                    Button b = (Button)row.getChildAt(j);
                    b.setBackgroundColor(Color.WHITE);
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (joe.length() == 5)
                            {
                                return;
                            }
                            joe += b.getText().toString().toLowerCase();
                            if (keysMap.get(b.getText()) == null)
                            {
                                keysMap.put(b.getText().toString(), b);
                            }
                            tblLayout = (TableLayout)findViewById(R.id.tableLayout);
                            TableRow row0 = (TableRow)tblLayout.getChildAt(counter); // Here get row id depending on number of row
                            for (int j = 0; j < 5; j++)
                            {
                                Button select0 = (Button)row0.getChildAt(j);
                                if (j > joe.length()-1)
                                {
                                    select0.setText("");
                                }
                                else
                                {
                                    select0.setText(joe.substring(j,j+1));
                                }

                            }
                        }
                    });
                }
            }

        }

    }

    public void changeColors(int r)
    {
        tblLayout = (TableLayout)findViewById(R.id.tableLayout);
        TableRow row = (TableRow)tblLayout.getChildAt(r); // Here get row id depending on number of row
        for(int i = 0; i < 5; i++)
        {
            Button select0 = (Button)row.getChildAt(i);
            if (inCorrectSpot(word,select0.getText().toString(),i))
            {
                select0.setBackgroundColor(Color.GREEN);
                Button select1 = keysMap.get(select0.getText().toString());
                select1.setBackgroundColor(Color.GREEN);
            }
            else if (in(word,select0.getText().toString()))
            {
                select0.setBackgroundColor(Color.YELLOW);
                Button select1 = keysMap.get(select0.getText().toString());
                select1.setBackgroundColor(Color.YELLOW);
            }
            else
            {
                select0.setBackgroundColor(Color.GRAY);
                Button select1 = keysMap.get(select0.getText().toString());
                select1.setBackgroundColor(Color.GRAY);
            }

        }
    }
    public boolean in(String big, String small)
    {
        for (int i = 0; i < big.length(); i++)
        {
            if (big.substring(i,i+1).equals(small))
            {
                return true;
            }
        }
        return false;
    }
    public boolean inCorrectSpot(String big, String small,int ind)
    {
        return big.substring(ind, ind + 1).equals(small);
    }
    public int[] getColorList(String correct, int r)
    {
        tblLayout = (TableLayout)findViewById(R.id.tableLayout);
        int[] colors = new int[5];
        TableRow row = (TableRow)tblLayout.getChildAt(r);
        String guess = "";
        for (int i = 0; i < 5; i++)
        {
            Button chosen =  (Button)row.getChildAt(i);
            guess += chosen.getText().toString();
        }
        for (int i = 0; i < 5; i++)
        {
            if (!in(word,String.valueOf(guess.charAt(i))))
            {
                colors[i] = Color.GRAY;
            }
            else if (in(word,String.valueOf(guess.charAt(i))))
            {
                colors[i] = Color.YELLOW;
            }
            else if (word.charAt(i) == guess.charAt(i))
            {
                colors[i] = Color.GREEN;
            }
        }
        return colors;
    }



}