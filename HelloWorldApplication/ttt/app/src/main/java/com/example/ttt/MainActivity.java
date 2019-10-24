package com.example.ttt;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] button = new Button[3][3];
    private boolean playerturn = true;                  /*true=p1,false=p2*/
    private int player1pt;
    private int player2pt;
    private TextView player1score;
    private TextView player2score;
    MediaPlayer nice;
    MediaPlayer stopit;
    MediaPlayer headshot;
    MediaPlayer succ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1score = findViewById(R.id.player1score);
        player2score = findViewById(R.id.player2score);

        nice = MediaPlayer.create(MainActivity.this, R.raw.kongoushit);
        stopit = MediaPlayer.create(MainActivity.this, R.raw.stopit);
        headshot = MediaPlayer.create(MainActivity.this, R.raw.headshot);
        succ = MediaPlayer.create(MainActivity.this, R.raw.succ);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonid = "button" + i + j;
                int resourceid = getResources().getIdentifier(buttonid,"id", getPackageName());
                button[i][j] = findViewById(resourceid);
                button[i][j].setOnClickListener(this);
            }
        }

        if(playerturn){

        }

        Button resetbutton = findViewById(R.id.reset);
        Button resetallbutton = findViewById(R.id.resetall);

        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset(0);
            }
        });

        resetallbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset(1);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (playerturn) {
            ((Button) v).setText("X");
            headshot.start();
        } else {
            ((Button) v).setText("O");
            stopit.start();
        }

        if (checkwin()) {
            if (playerturn) {
                playerWins(1);
            } else {
                playerWins(2);
            }
        } else if (checkdraw()) {
            draw();
        } else {
            playerturn = !playerturn;
        }

    }

    private void playerWins(int p){
        if(p == 1){
            player1pt++;
            Toast.makeText(getApplicationContext(),"Player1Wins",Toast.LENGTH_SHORT).show();
            player1score.setText("Player 1 Score:" + player1pt);
        }else{
            player2pt++;
            Toast.makeText(getApplicationContext(),"Player2Wins",Toast.LENGTH_SHORT).show();
            player2score.setText("Player 2 Score:" + player2pt);
        }
        succ.start();
        reset(0);
    }

    private boolean checkwin() {
        String[][] field = new String[3][3];
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                field[i][j] = button[i][j].getText().toString();                             /*map field*/
            }
        }

        for(int i=0;i<3;i++){
            if( field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")){
                return true;
            }
        }
        for(int i=0;i<3;i++){
            if( field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")){
                return true;
            }
        }
        for(int i=0;i<3;i++){
            if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals("")){
                return true;
            }
        }
        for(int i=0;i<3;i++){
            if(field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("")){
                return true;
            }
        }

        return false;
    }

    private boolean checkdraw(){
        String[][] field = new String[3][3];
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                field[i][j] = button[i][j].getText().toString();
            }
        }
        if( checkfill() && !checkwin() ){
            return true;
        }
        return false;
    }

    private boolean checkfill(){
        String[][] field = new String[3][3];
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                field[i][j] = button[i][j].getText().toString();                             /*map field*/
            }
        }

        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(field[i][j].equals(""))
                    return false;
            }
        }
        return true;
    }

    private void draw(){
        Toast.makeText(getApplicationContext(),"Draw",Toast.LENGTH_SHORT).show();
        nice.start();
        reset(0);
    }

    private void reset(int p){                                              /*0=clear map, 1=clear all*/
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                button[i][j].setText("");
            }
        }

        if(p == 1){
            player1pt = 0;
            player2pt = 0;
            player1score.setText("Player 1 Score:" + player1pt);
            player2score.setText("Player 2 Score:" + player2pt);
        }
    }
}
