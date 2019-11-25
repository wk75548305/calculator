package com.example.madlibs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;

public class result extends AppCompatActivity implements View.OnClickListener {

    String essay;
    ArrayList userinput;
    int length;
    String regex, output;
    TextView result, record;
    Button back;
    Button history;
    Button closehistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = findViewById(R.id.result);
        record = findViewById(R.id.record);
        back = findViewById(R.id.back);
        closehistory = findViewById(R.id.unshowrecord);
        String regex = "<.*?>";

        record.setText(output);

        Bundle extradata = getIntent().getExtras();
        essay = extradata.getString("essay");
        userinput = extradata.getStringArrayList("userinput");
        length = extradata.getInt("occurance");

        output = essay;

        for (int i = 0; i < length; i++) {
            String dummy = (String) userinput.get(i);
            output = output.replaceFirst(regex, dummy);
        }

        result.setText(output);



        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                record.setVisibility(View.VISIBLE);
                history.setVisibility(View.GONE);
                closehistory.setVisibility(View.VISIBLE);
            }
        });

        closehistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                record.setVisibility(View.GONE);
                history.setVisibility(View.VISIBLE);
                closehistory.setVisibility(View.GONE);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(result.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}