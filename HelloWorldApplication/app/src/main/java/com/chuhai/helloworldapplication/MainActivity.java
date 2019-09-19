package com.chuhai.helloworldapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/*import android.widget.TextView;*/
import android.widget.TextView;
import android.widget.Toast;

/*import java.util.Random;*/

public class MainActivity extends AppCompatActivity {

    // Sets up initial points and random numbers on the buttons.

    private Button leftbutton;
    private Button rightbutton;
    private int score = 0;
    private int leftvalue = 0;
    private int rightvalue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;
        pickRandomNumbers();


        // TODO: initialize the point to 0,
        //       and call function pickRandomNumbers
    }

    private void pickRandomNumbers() {
        // TODO: Chooses two random numbers from 0-9 and
        //       places them on the left/right buttons.
        leftbutton = findViewById(R.id.theleftbutton);
        rightbutton = findViewById(R.id.therightbutton);

        do {
            leftvalue = (int) (Math.random() * (10));
            rightvalue = (int) (Math.random() * (10));
        } while (leftvalue == rightvalue);

        leftbutton.setText(String.valueOf(leftvalue));
        rightbutton.setText(String.valueOf(rightvalue));
    }

    // Called when the left number button is clicked.
    public void leftButtonClick(View view) {
        // TODO: Call the function buttonClickHelper and
        //       specify isLeft = true
        boolean isLeft = true;
        buttonClickHelper(isLeft);
    }

    // Called when the right number button is clicked.
    public void rightButtonClick(View view) {
        // TODO: Call the function buttonClickHelper and
        //       specify isLeft = false
        boolean isLeft = false;
        buttonClickHelper(isLeft);
    }

    // A helper to handle a click on the left or right button,
    // since their behavior is similar.
    // Checks whether the user clicked the larger number and awards points accordingly.
    private void buttonClickHelper(boolean isLeft) {
        // TODO: Obtain the value from the buttons, and
        // determine the button that clicked by user is larger or smaller.
        // If larger, increment the point by 1, and show the message “Great Job”
        // Otherwise, decrement the point by 1, and show the message “Wrong ans”



        if(isLeft == true){

            if (leftvalue > rightvalue){
                Toast.makeText(this, "Great Job", Toast.LENGTH_SHORT).show();
                score ++;
            }
            else {
                Toast.makeText(this, "nah", Toast.LENGTH_SHORT).show();
                score --;
            }
        }


        if(isLeft == false){

            if (leftvalue < rightvalue){
                Toast.makeText(this, "Great Job", Toast.LENGTH_SHORT).show();
                score ++;
            }
            else {
                Toast.makeText(this, "nah", Toast.LENGTH_SHORT).show();
                score --;

                if(score < 0)
                    score = 0;
            }
        }
        // TODO: update display of points

        ((TextView)findViewById(R.id.scores)).setText(String.valueOf(score));

        // TODO: choose two new random numbers for next round

        pickRandomNumbers();
    }

}
