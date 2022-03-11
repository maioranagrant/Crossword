package com.example.crossword;

import android.util.Log;

import java.io.Serializable;

public class WordleBoard implements Serializable {
    public char[][] board = {{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '}};
    public String answer;
    WordleBoard(String a)
    {
        answer = a;
    }
    public char[][] getBoard()
    {
        return board;
    }
    public char[][] setLetter(int r, int c, char l)
    {
        board[r][c] = l;
        return board;
    }
    public boolean checkWord()
    {
        for (int i = 0; i < 6; i++)
        {
            String joe = (Character.toString(board[i][0]).toLowerCase()  + Character.toString(board[i][1]).toLowerCase() + Character.toString(board [i][2]).toLowerCase() + Character.toString(board[i][3]).toLowerCase() + Character.toString(board[i][4])).toLowerCase();
            Log.d("joe",joe);
            if (joe.equals(answer.toLowerCase()))
            {

                return true;
            }
        }
        return false;
    }
    public void printBoard()
    {
        Log.d("test",Character.toString(board[0][0]));
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
        if (big.substring(ind,ind+1).equals(small))
        {
            return true;
        }
        return false;
    }
    public void setAnswer(String s)
    {
        answer = s;
    }





}
