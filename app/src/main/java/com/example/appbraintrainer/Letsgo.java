package com.example.appbraintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

public class Letsgo extends AppCompatActivity implements View.OnClickListener{

    Button letsgo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letsgo);

        letsgo = findViewById(R.id.button);
        letsgo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new CountDownTimer(1000, 1000){
            @Override
            public void onFinish() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }

            @Override
            public void onTick(long l) {
                letsgo.animate().rotation(36000).start();

            }
        }.start();
    }
}
