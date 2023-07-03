package com.learningphase.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity2 extends AppCompatActivity {


    TextView textView3,textView4;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        int lucky_num = Integer.parseInt(getLucky().toString());
        textView4.setText(String.valueOf(lucky_num));
        button1 = findViewById(R.id.shareButton);

        Intent i = getIntent();
        String userName = i.getStringExtra("UserName");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(lucky_num,userName);
            }
        });

    }

    public Integer getLucky(){
        Random random = new Random();
        return random.nextInt(500);
    }

    public void shareData(int random_num , String userName){
        Intent  i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String s= String.valueOf(random_num);
        i.putExtra(Intent.EXTRA_SUBJECT,userName + " got lucky today !!");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is : "+s);

        startActivity(Intent.createChooser(i,"Choose a Platform : "));

    }

}