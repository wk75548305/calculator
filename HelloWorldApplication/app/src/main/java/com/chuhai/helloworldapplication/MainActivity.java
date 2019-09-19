package com.chuhai.helloworldapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Sets up initial points and random numbers on the buttons.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: initialize the point to 0,
        //       and call function pickRandomNumbers
    }

    private void pickRandomNumbers() {
        // TODO: Chooses two random numbers from 0-9 and
        //       places them on the left/right buttons.
        Random rand = new Random();
        int n = rand.nextInt(50);
    }

    // Called when the left number button is clicked.
    public void leftButtonClick(View view) {
        // TODO: Call the function buttonClickHelper and
        //       specify isLeft = true
    }

    // Called when the right number button is clicked.
    public void rightButtonClick(View view) {
        // TODO: Call the function buttonClickHelper and
        //       specify isLeft = false
    }

    // A helper to handle a click on the left or right button,
    // since their behavior is similar.
    // Checks whether the user clicked the larger number and awards points accordingly.
    private void buttonClickHelper(boolean isLeft) {
        // TODO: Obtain the value from the buttons, and
        // determine the button that clicked by user is larger or smaller.
        // If larger, increment the point by 1, and show the message “Great Job”
        // Otherwise, decrement the point by 1, and show the message “Wrong ans”

        // TODO: update display of points


        // TODO: choose two new random numbers for next round
    }

}
