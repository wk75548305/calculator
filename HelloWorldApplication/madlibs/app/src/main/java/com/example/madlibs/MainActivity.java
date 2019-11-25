package com.example.madlibs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button goresult;
    Button submit;
    TextView paragraph;
    int length;
    String para,inputs, output;
    TextView banner;
    EditText editText;
    int occurance = 0;
    ArrayList userinput;
    int dummy;
    Pattern pattern;
    Matcher matcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goresult = findViewById(R.id.goresult);
        submit = findViewById(R.id.next);
        editText = findViewById(R.id.userinput);
        banner = findViewById(R.id.banner);

        userinput = new ArrayList();
        para = "";
        final Intent intentresult = new Intent(this,result.class);

        Scanner scan = new Scanner( getResources().openRawResource(R.raw.sample));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            para += line;
        }
        scan.close();

        pattern = Pattern.compile("<*>");
        matcher = pattern.matcher(para);

        while(matcher.find())
            occurance++;

        banner.setText("this is mad lib, so insert your words please." + System.getProperty("line.separator") +"There are " + occurance + " more to go");

        dummy = occurance;

        submit.setOnClickListener(this);

        goresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentresult.putExtra("essay", para);
                intentresult.putExtra("userinput",userinput);
                intentresult.putExtra("occurance",occurance);
                intentresult.putExtra("output", output);
                startActivity(intentresult);
            }
        });
    }

    public void onClick(View view) {
        inputs = editText.getText().toString();
        userinput.add(inputs);
        dummy -= 1;
        banner.setText("this is mad lib, so insert your words please." + System.getProperty("line.separator") +"There are " + dummy + " more to go");

        if(dummy == 0){
            submit.setVisibility(Button.GONE);
            goresult.setVisibility(Button.VISIBLE);
        }
    }
}

