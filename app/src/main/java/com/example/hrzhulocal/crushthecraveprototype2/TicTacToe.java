package com.example.hrzhulocal.crushthecraveprototype2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
//credit to http://lyndonarmitage.com/making-tic-tac-toe-in-android/
/**
 * Tic Tac Toe Game
 * ---
 * Layout Code by Lyndon Armitage
 * For learning purposes
 *
 * Coded by Henry Zhu
 * added checking, scoring, and AI features
 */
public class TicTacToe extends ActionBarActivity {

    //Representing the game state: who's turn is it?
    private boolean whosTurn = false;  //false = X true = O
    private char board[][] = new char[3][3];
    // boolean vari gameOver represent whether game is over
    private boolean gameOver = false;

    public static final char HUMAN_PLAYER = 'X';
    public static final char AI = '0';

    public static int x = 0;
    public static int counter = 0;

    String xString= "X";
    boolean firstTime = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        x=0;
        if(!gameOver) {
            setupOnClickListeners();
            addListenerOnRestart();
        }
        x=0;
        //OnClickListenersNewGame();
        addListenerOnRestart();
    }
    /**
     * This will add the OnClickListener to each button inside out TableLayout
     * it grabs the tableLayout and loops through each of it’s children
     * (making sure each one is a TableRow) and then loops through each child’s
     * children and sets up what they do upon a click. I had to edit my TableLayout
     * and give it an ID to it in order to find it using findViewById() I simply
     * set up it’s android:id attribute in the xml to:
     */
    private void setupOnClickListeners() {
        TableLayout T = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < T.getChildCount(); y++) {
            if (T.getChildAt(y) instanceof TableRow) {
                TableRow R = (TableRow) T.getChildAt(y);
                for (int x = 0; x < R.getChildCount(); x++) {
                    View V = R.getChildAt(x); // In our case this will be each button on the grid
                    V.setOnClickListener(new PlayOnClick(x, y));
                }
            }
        }
    }
    /*
     PlayOnClick is a custom OnClickListener I created for this program. I could of instead created 9
     different methods (one for each button) and set each button to call one each using the UI
     designer but instead opted to create an OnClickListener and dynamically set each button to use
     one with it’s unique coordinates. An implementation of this for our game looks like this
     (it’s an inner class of my MainActivity class):
     */
    private class PlayOnClick implements View.OnClickListener {

        private int x = 0;
        private int y = 0;

        public PlayOnClick(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public void onClick(View view) {

            if (view instanceof Button) {
                Button B = (Button) view;
                B.setTextColor(Color.BLUE);

                if (whosTurn) {
                    board[x][y] = 'O';
                    B.setText("O");
                    //EASYAI(view, board);
                    checkWinner(board);

                } else {
                    //computer play X first
                    if(firstTime){
                        board[1][1] = 'X';
                        B.setText(""+xString);
                    }
                    //board[x][y] = 'X';
                    //B.setText("X");
                    MEDIUMAI(view, board);
                    checkWinner(board);
                }
                    //after click that specific button, it can no longer respond to change to events
                    B.setEnabled(false);
                    whosTurn = !whosTurn;
            }
        }
    }
    //You can never lose in EASYAI mode
    private void EASYAI(View view, char[][] board) {
        if (view instanceof Button) {

            Button B = (Button) view;
            B.setTextColor(Color.BLUE);
            if (x == 0 && board[1][1] != 'X') {
                board[1][1] = 'O';
                B.setText("O");
            }
        }
    }

    private void MEDIUMAI(View view, char[][] board){
        if(view instanceof Button){
            Button B = (Button) view;
            B.setTextColor(Color.BLUE);
            if( x > 0 ){
                board[1][1] = 'X';
                B.setText(""+xString);
            }
        }
    }
        /*if (whosTurn) {
            Random rand = new Random();
            int nX = rand.nextInt(3);
            int nY = rand.nextInt(3);

            if(x == 0 && board[1][1] != 'X') {
                board[1][1] = 'O';
                B.setText("O");

            }
            else if (x==0 && board[1][1] == 'X'){
                board[0][0] = 'O';
                B.setText("O");
            }

            else if(nX != 0){
                board[nX][nY] = 'O';
                B.setText("O");

            }*/




        private void addListenerOnRestart() {
            final Context context = this;
            Button button = (Button) findViewById(R.id.button20);

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    Intent intent = new Intent(context, TicTacToe.class);
                    startActivity(intent);
                }
            });
        }
        //Check for a win or a lose or a tie
        private void checkWinner(char[][] board) {
            // Get instance of Vibrator from current Context
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            TextView textView = (TextView) findViewById(R.id.textView68);

            //check for vertical line
            if ((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||
                    (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||
                    (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O')) {
                // Vibrate for 350 milliseconds
                v.vibrate(350);
                textView.setText("Player O wins!");
                gameOver = true;

            }
            //check for horizontal line
            else if ((board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||
                    (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||
                    (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O')) {

                v.vibrate(350);
                textView.setText("Player O wins!");
                gameOver = true;

            }
            //check for diagonal line
            else if ((board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||
                    (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O')) {
                v.vibrate(350);

                textView.setText("Player O wins!");
                gameOver = true;
            }

            //check for vertical line
            if ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
                    (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
                    (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X')) {

                textView.setText("Player X wins!");
                gameOver = true;

            }
            //check for horizontal line
            else if ((board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
                    (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
                    (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X')) {
                textView.setText("Player X wins!");
                gameOver = true;
            }
            //check for diagonal line
            else if ((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
                    (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X')) {
                textView.setText("Player X wins!");
                gameOver = true;
            }
            x++;
            // after 9 moves and when game is over then is a tie!
            if (x == 9 && gameOver == false){
                Toast.makeText(getBaseContext(), "It is a tie!", Toast.LENGTH_SHORT).show();
                x=0;
            }
        }
    }


