package com.chuhai.helloworldapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] button = new Button[3][3];
    private boolean playerturn = true;                  /*0=p1,1=p2*/
    private int roundcount;
    private int player1pt;
    private int player2pt;
    private TextView player1score;
    private TextView player2score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1score = findViewById(R.id.player1score);
        player2score = findViewById(R.id.player2score);

        for(int i = 0 ; i<3 ; i++){
            for(int j=0;j<3;j++){
                String buttonid = "button"+i+j;
                int resourceid = getResources().getIdentifier(buttonid,"id",getPackageName());
                button[i][j] = findViewById(resourceid);
                button[i][j].setOnClickListener(this);
            }
        }
    }


    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (playerturn) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }

        roundcount++;

        /*if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }

    }*/
}}
