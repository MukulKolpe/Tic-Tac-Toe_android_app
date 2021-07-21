package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
boolean gameActive = true;

//0=o and 1=x
        int activePlayer = 0;
        int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
//0- x
//1- o
//2- null

        int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                                {0, 4, 8}, {2, 4, 6}};
    public void PlayerTap(View view) {
        ImageView img=(ImageView)view;
        int tappedImaage= Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImaage] ==2) {
            gameState[tappedImaage] = activePlayer;
            img.setTranslationY(-1000f);

            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status= findViewById(R.id.status);
                status.setText("O's turn Tap to Play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status= findViewById(R.id.status);
                status.setText("X's turn Tap to Play");

            }

            img.animate().translationYBy(1000f).setDuration(300);
        }
        //check if any player has won
        for(int[] winPositions: winPositions){
           if( gameState[winPositions[0]]== gameState[winPositions[1]] &&
                   gameState[winPositions[1]]== gameState[winPositions[2]] &&
            gameState[winPositions[0]]!=2){
               //somebody has won-
               String WinnerStr;
               gameActive=false;
               if(gameState[winPositions [0]]==0){
                   WinnerStr="X has won!";
               }else{
                   WinnerStr="O has won!";
               }
               //Update the status bar for winner announcement
               TextView status= findViewById(R.id.status);
               status.setText(WinnerStr);
           }
        }
    }
    public void gameReset(View view) {
        gameActive= true;
        activePlayer=0;
        for(int i=0; i<gameState.length; i++){
            gameState[i]= 2;

        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status= findViewById(R.id.status);
        status.setText("X's turn Tap to Play");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private class ImageView0 {
    }
}