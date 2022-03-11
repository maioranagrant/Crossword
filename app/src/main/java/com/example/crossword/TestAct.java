package com.example.crossword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class TestAct extends AppCompatActivity {

    String currentAnswer = "";
    public String word;
    ArrayList<String> list;
    int counter = 0;
    int buttonNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_testing);
        EditText edit = findViewById(R.id.edt2);
        InputMethodManager im = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        edit.requestFocus();
        im.showSoftInput(edit, InputMethodManager.SHOW_FORCED);
//
//        list = new ArrayList<String>();
//
//        try {
//            InputStream is = getApplicationContext().getAssets().open("letters.txt");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            while(reader.ready()) {
//                String line = reader.readLine();
//                list.add(line);
//            }
//        }
//        catch (Exception e)
//        {
//            Log.d("debug",e.toString());
//        }
//        Random r = new Random();
//        word = list.get(r.nextInt(list.size()-1)).toLowerCase(Locale.ROOT);
//
//        //word = "sussy";
//        WordleBoard w = new WordleBoard(word);
//        w.setAnswer(word);
//
//
//
//        buttonNum = 0;
//
//        edit.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
//            {
//                TableLayout tblLayout = (TableLayout)findViewById(R.id.tableLayout);
//                TableRow row0 = (TableRow)tblLayout.getChildAt(counter); // Here get row id depending on number of row
//                for (int j = 0; j < 5; j++)
//                {
//                    Button select0 = (Button)row0.getChildAt(j);
//                    if (edit.getText().toString().length() < j)
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
//                    Log.d("t","ee");
//                    return true;
//                }
//                else if ((actionId == EditorInfo.IME_ACTION_DONE) || ((event.getKeyCode() == KeyEvent.KEYCODE_BACK) && (event.getAction() == KeyEvent.ACTION_UP )))
//                {
//                    Log.d("t","ef");
//                    return true;
//                }
//
//                return false;
//
//            }
//        });
//
//
//
//
//
//
//
////Read the lines of text into an ArrayList
//
//
//
//
////        TableLayout tblLayout = (TableLayout)findViewById(R.id.tableLayout);
////        TableRow row0 = (TableRow)tblLayout.getChildAt(0); // Here get row id depending on number of row
////        Button select0 = (Button)row0.getChildAt(0);
////        EditText e = new EditText(this);
////        AlertDialog dialog = new AlertDialog.Builder(this)
////                .setTitle("Title")
////                .setMessage("Message")
////                .setView(e)
////                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        currentAnswer = e.getText().toString();
////                        TableRow row0 = (TableRow)tblLayout.getChildAt(0);
////                        for (int k = 1; k < 6; k++)
////                        {
////                            Button chosen = (Button)row0.getChildAt(k);
////                            chosen.setText(currentAnswer.substring(k-1,k));
////                            w.setLetter(0,k-1,currentAnswer.substring(k-1,k).charAt(0));
////                        }
////                        changeColors(0);
////                        if (w.checkWord())
////                        {
////                            Intent intent = new Intent(MainActivity.this, WinActivity.class);
////                            intent.putExtra("board",w);
////                            startActivity(intent);
////                        }
////                    }
////                })
////                .setNegativeButton("Cancel", null)
////                .create();
////        select0.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////
////                dialog.show();
////
////
////            }
////        });
////
////        TableRow row1 = (TableRow)tblLayout.getChildAt(1); // Here get row id depending on number of row
////        Button select1 = (Button)row1.getChildAt(0);
////        EditText e1 = new EditText(this);
////        AlertDialog dialog1 = new AlertDialog.Builder(this)
////                .setTitle("Title")
////                .setMessage("Message")
////                .setView(e1)
////                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        currentAnswer = e1.getText().toString();
////                        TableRow row1 = (TableRow)tblLayout.getChildAt(1);
////                        for (int k = 1; k < 6; k++)
////                        {
////                            Button chosen = (Button)row1.getChildAt(k);
////                            chosen.setText(currentAnswer.substring(k-1,k));
////                            w.setLetter(1,k-1,currentAnswer.substring(k-1,k).charAt(0));
////                        }
////                        changeColors(1);
////                        if (w.checkWord())
////                        {
////                            Intent intent = new Intent(MainActivity.this, WinActivity.class);
////                            intent.putExtra("board",w);
////                            startActivity(intent);
////                        }
////                    }
////                })
////                .setNegativeButton("Cancel", null)
////                .create();
////        select1.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                dialog1.show();
////            }
////        });
////
////        TableRow row2 = (TableRow)tblLayout.getChildAt(2); // Here get row id depending on number of row
////        Button select2 = (Button)row2.getChildAt(0);
////        EditText e2 = new EditText(this);
////        AlertDialog dialog2 = new AlertDialog.Builder(this)
////                .setTitle("Title")
////                .setMessage("Message")
////                .setView(e2)
////                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        currentAnswer = e2.getText().toString();
////                        TableRow row2 = (TableRow)tblLayout.getChildAt(2);
////                        for (int k = 1; k < 6; k++)
////                        {
////                            Button chosen = (Button)row2.getChildAt(k);
////                            chosen.setText(currentAnswer.substring(k-1,k));
////                            w.setLetter(2,k-1,currentAnswer.substring(k-1,k).charAt(0));
////                        }
////                        changeColors(2);
////                        if (w.checkWord())
////                        {
////                            Intent intent = new Intent(MainActivity.this, WinActivity.class);
////                            intent.putExtra("board",w);
////                            startActivity(intent);
////                        }
////                    }
////                })
////                .setNegativeButton("Cancel", null)
////                .create();
////        select2.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                dialog2.show();
////            }
////        });
////        TableRow row3 = (TableRow)tblLayout.getChildAt(3); // Here get row id depending on number of row
////        Button select3 = (Button)row3.getChildAt(0);
////        EditText e3 = new EditText(this);
////        AlertDialog dialog3 = new AlertDialog.Builder(this)
////                .setTitle("Title")
////                .setMessage("Message")
////                .setView(e3)
////                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        currentAnswer = e3.getText().toString();
////                        TableRow row3 = (TableRow)tblLayout.getChildAt(3);
////                        for (int k = 1; k < 6; k++)
////                        {
////                            Button chosen = (Button)row3.getChildAt(k);
////                            chosen.setText(currentAnswer.substring(k-1,k));
////                            w.setLetter(3,k-1,currentAnswer.substring(k-1,k).charAt(0));
////                        }
////                        changeColors(3);
////                        if (w.checkWord())
////                        {
////                            Intent intent = new Intent(MainActivity.this, WinActivity.class);
////                            intent.putExtra("board",w);
////                            startActivity(intent);
////                        }
////                    }
////                })
////                .setNegativeButton("Cancel", null)
////                .create();
////        select3.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                dialog3.show();
////            }
////        });
////        TableRow row4 = (TableRow)tblLayout.getChildAt(4); // Here get row id depending on number of row
////        Button select4 = (Button)row4.getChildAt(0);
////        EditText e4 = new EditText(this);
////        AlertDialog dialog4 = new AlertDialog.Builder(this)
////                .setTitle("Title")
////                .setMessage("Message")
////                .setView(e4)
////                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        currentAnswer = e4.getText().toString();
////                        TableRow row4 = (TableRow)tblLayout.getChildAt(4);
////                        for (int k = 1; k < 6; k++)
////                        {
////                            Button chosen = (Button)row4.getChildAt(k);
////                            chosen.setText(currentAnswer.substring(k-1,k));
////                            w.setLetter(4,k-1,currentAnswer.substring(k-1,k).charAt(0));
////                        }
////                        changeColors(4);
////                        if (w.checkWord())
////                        {
////                            Intent intent = new Intent(MainActivity.this, WinActivity.class);
////                            intent.putExtra("board",w);
////                            startActivity(intent);
////                        }
////                    }
////                })
////                .setNegativeButton("Cancel", null)
////                .create();
////        select4.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                dialog4.show();
////            }
////        });
////
////        TableRow row5 = (TableRow)tblLayout.getChildAt(5); // Here get row id depending on number of row
////        Button select5 = (Button)row5.getChildAt(0);
////        EditText e5 = new EditText(this);
////        AlertDialog dialog5 = new AlertDialog.Builder(this)
////                .setTitle("Title")
////                .setMessage("Message")
////                .setView(e5)
////                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        currentAnswer = e5.getText().toString();
////                        TableRow row5 = (TableRow)tblLayout.getChildAt(5);
////                        for (int k = 1; k < 6; k++)
////                        {
////                            Button chosen = (Button)row5.getChildAt(k);
////                            chosen.setText(currentAnswer.substring(k-1,k));
////                            w.setLetter(5,k-1,currentAnswer.substring(k-1,k).charAt(0));
////                        }
////                        changeColors(5);
////                        if (w.checkWord())
////                        {
////                            Intent intent = new Intent(MainActivity.this, WinActivity.class);
////                            intent.putExtra("board",w);
////                            startActivity(intent);
////                        }
////                        else {
////                            Intent j = new Intent(MainActivity.this,LossActivity.class);
////                            j.putExtra("board",w);
////                            startActivity(j);
////                        }
////                    }
////                })
////                .setNegativeButton("Cancel", null)
////                .create();
////        select5.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                dialog5.show();
////            }
////        });
//
//
//
//    }
//
//    public void changeColors(int r)
//    {
//        TableLayout tblLayout = (TableLayout)findViewById(R.id.tableLayout);
//        TableRow row = (TableRow)tblLayout.getChildAt(r); // Here get row id depending on number of row
//        for(int i = 1; i < 6; i++)
//        {
//            Button select0 = (Button)row.getChildAt(i);
//            if (inCorrectSpot(word,select0.getText().toString(),i-1))
//            {
//                select0.setBackgroundColor(Color.GREEN);
//            }
//            else if (in(word,select0.getText().toString()))
//            {
//                select0.setBackgroundColor(Color.YELLOW);
//            }
//            else
//            {
//                select0.setBackgroundColor(Color.LTGRAY);
//            }
//
//        }
//    }
//    public boolean in(String big, String small)
//    {
//        for (int i = 0; i < big.length(); i++)
//        {
//            if (big.substring(i,i+1).equals(small))
//            {
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean inCorrectSpot(String big, String small,int ind)
//    {
//        if (big.substring(ind,ind+1).equals(small))
//        {
//            return true;
//        }
//        return false;
//    }
    }
}