package com.example.reflexgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    public Button button1, button2;
    public RelativeLayout relativeLayout;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relativeLayout.setBackgroundResource(R.color.green);
            final long time = System.currentTimeMillis();
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    long time1 = System.currentTimeMillis();
                    Toast.makeText(getApplicationContext(), "Your reflexes takes " + (time1 - time) + " time to work", Toast.LENGTH_LONG).show();
                    relativeLayout.setBackgroundResource(0);
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.rlVar1);
        button1 = findViewById(R.id.btVar1);
        button2 = findViewById(R.id.btVar2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int num = random.nextInt(10);
                Handler handler = new Handler();
                handler.postDelayed(runnable, num*1000);
            }
        });
    }
}