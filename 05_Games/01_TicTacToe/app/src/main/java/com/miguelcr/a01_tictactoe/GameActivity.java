package com.miguelcr.a01_tictactoe;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    TextView player;
    ImageView imageViewCell1, imageViewCell2, imageViewCell3,
            imageViewCell4,imageViewCell5,imageViewCell6,
    imageViewCell7,imageViewCell8,imageViewCell9;
    boolean isPlayingPlayer1 = true;
    String name1, name2;
    boolean gameFinished = false;
    boolean isRemiza;

    /*
    |  0  |  1 |  2 |
    -----------------
    |  3  |  4 |  5 |
    -----------------
    |  6  |  7 |  8 |
    -----------------

     |  0  |  0 |  0 |
    -----------------
    |  0  |  0 |  0 |
    -----------------
    |  0  |  0 |  0 |
    -----------------
    */

    //                     0 1 2 3 4 5 6 7 8
    int[] selectedCells = {0,0,0,0,0,0,0,0,0};

    // if Player1 select one cell > 1
    // if Player2 select one cell > 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        player = (TextView) findViewById(R.id.textViewPlayer);
        imageViewCell1 = (ImageView) findViewById(R.id.cell1);
        imageViewCell2 = (ImageView) findViewById(R.id.cell2);
        imageViewCell3 = (ImageView) findViewById(R.id.cell3);
        imageViewCell4 = (ImageView) findViewById(R.id.cell4);
        imageViewCell5 = (ImageView) findViewById(R.id.cell5);
        imageViewCell6 = (ImageView) findViewById(R.id.cell6);
        imageViewCell7 = (ImageView) findViewById(R.id.cell7);
        imageViewCell8 = (ImageView) findViewById(R.id.cell8);
        imageViewCell9 = (ImageView) findViewById(R.id.cell9);

        // Get the params that we receive in the Intent
        Bundle extras = getIntent().getExtras();
        name1 = extras.getString("player1");
        name2 = extras.getString("player2");

        player.setText(name1);


    }

    public void cellClicked(View v) {

        if (gameFinished) {
            Toast.makeText(this, "Game finished, restart the game", Toast.LENGTH_SHORT).show();
        } else {
            int id = v.getId();

            int position = 0;
            ImageView imageViewCurrent = null;

            switch (id) {
                case R.id.cell1:
                    imageViewCurrent = imageViewCell1;
                    position = 0;
                    break;
                case R.id.cell2:
                    imageViewCurrent = imageViewCell2;
                    position = 1;
                    break;
                case R.id.cell3:
                    imageViewCurrent = imageViewCell3;
                    position = 2;
                    break;
                case R.id.cell4:
                    imageViewCurrent = imageViewCell4;
                    position = 3;
                    break;
                case R.id.cell5:
                    imageViewCurrent = imageViewCell5;
                    position = 4;
                    break;
                case R.id.cell6:
                    imageViewCurrent = imageViewCell6;
                    position = 5;
                    break;
                case R.id.cell7:
                    imageViewCurrent = imageViewCell7;
                    position = 6;
                    break;
                case R.id.cell8:
                    imageViewCurrent = imageViewCell8;
                    position = 7;
                    break;
                case R.id.cell9:
                    imageViewCurrent = imageViewCell9;
                    position = 8;
                    break;
            }

            if (selectedCells[position] == 0) {
                if (isPlayingPlayer1) {
                    player.setText(name2);
                    imageViewCurrent.setImageResource(R.drawable.ic_player1);
                    selectedCells[position] = 1;

                    if (checkSolution()) {
                        if(isRemiza) {
                            Toast.makeText(this, "Nobody won!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
                        }
                        gameFinished = true;
                        showDialog();
                    } else {
                        isPlayingPlayer1 = false;
                    }
                } else {
                    player.setText(name1);
                    imageViewCurrent.setImageResource(R.drawable.ic_player2);
                    selectedCells[position] = 2;

                    if (checkSolution()) {
                        if(isRemiza) {
                            Toast.makeText(this, "Nobody won!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
                        }

                        gameFinished = true;
                        showDialog();
                    } else {
                        isPlayingPlayer1 = true;
                    }
                }


            } else {
                Toast.makeText(this, "The selected cell is not empty", Toast.LENGTH_SHORT).show();
            }
        }


    }

    public boolean checkSolution() {
        boolean existSolution = false;

        isRemiza = true;
        for(int i=0; i<9; i++) {
            if(selectedCells[i]==0)
                isRemiza = false;
        }

        if(isRemiza) {
            existSolution = true;
        } else if(selectedCells[0]==selectedCells[1] &&
                selectedCells[1]==selectedCells[2] && selectedCells[2]!=0) {
            // 0, 1, 2 > 1st row
            existSolution = true;
        } else if(selectedCells[3]==selectedCells[4] &&
                selectedCells[4]==selectedCells[5] && selectedCells[5]!=0) {
            // 3, 4, 5, > 2nd row
            existSolution = true;
        } else if(selectedCells[6]==selectedCells[7] &&
                selectedCells[7]==selectedCells[8] && selectedCells[8]!=0) {
            // 6,7,8 > 3rd row
            existSolution = true;
        } else if(selectedCells[0]==selectedCells[3] &&
                selectedCells[3]==selectedCells[6] && selectedCells[6]!=0) {
            // 0,3,6 > 1st col
            existSolution = true;
        } else if(selectedCells[1]==selectedCells[4] &&
                selectedCells[4]==selectedCells[7] && selectedCells[7]!=0) {
            // 1,4,7 > 2nd col
            existSolution = true;
        } else if(selectedCells[2]==selectedCells[5] &&
                selectedCells[5]==selectedCells[8] && selectedCells[8]!=0) {
            // 2,5,8 > 3rd col
            existSolution = true;
        } else if(selectedCells[0]==selectedCells[4] &&
                selectedCells[4]==selectedCells[8] && selectedCells[8]!=0) {
            // 0,4,8 > left diagonal
            existSolution = true;
        } else if(selectedCells[2]==selectedCells[4] &&
                selectedCells[4]==selectedCells[6] && selectedCells[6]!=0) {
            // 2,4,6 > right diagonal
            existSolution = true;
        }


        return existSolution;
    }

    public void showDialog() {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Select one option to restart the game or exit")
                        .setTitle("TicTacToe");

        // Add the buttons
        builder.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                restartGame();


            }
        });
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                // Destroy the current screen and return
                // to the login screen
                finish();
            }
        });

        // is not possible to close the dialog
        // if you want to close you must to select one dialog option
        builder.setCancelable(false);

        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();

        // Show the dialog in the screen
        dialog.show();


    }

    private void restartGame() {

        // Restart the selectedCells array to 0 value
        for(int i = 0; i<9; i++) {
            selectedCells[i] = 0;
        }

        // all the images View to empty icon
        imageViewCell1.setImageResource(R.drawable.ic_empty);
        imageViewCell2.setImageResource(R.drawable.ic_empty);
        imageViewCell3.setImageResource(R.drawable.ic_empty);
        imageViewCell4.setImageResource(R.drawable.ic_empty);
        imageViewCell5.setImageResource(R.drawable.ic_empty);
        imageViewCell6.setImageResource(R.drawable.ic_empty);
        imageViewCell7.setImageResource(R.drawable.ic_empty);
        imageViewCell8.setImageResource(R.drawable.ic_empty);
        imageViewCell9.setImageResource(R.drawable.ic_empty);

        // isPlayingPlayer1 = true and change textViewPlayer1
        gameFinished = false;
        player.setText(name1);
        isPlayingPlayer1 = true;

    }

}
