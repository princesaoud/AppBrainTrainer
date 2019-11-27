package com.example.appbraintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    TextView tv_timer, tv_operation, tv_total_score, tv_result;
    Button bt_play_again;
    GridLayout m_gridlayout;
    Game_profile game_profile = new Game_profile();
    boolean timer = false;
    CountDownTimer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game_profile = new Game_profile();
        tv_total_score = findViewById(R.id.tv_total_score);
        tv_timer = findViewById(R.id.tv_timer);
        tv_operation = findViewById(R.id.tv_operation);
        m_gridlayout = findViewById(R.id.grid_game_body);
        bt_play_again = findViewById(R.id.bt_playgain);
        tv_result = findViewById(R.id.tv_result);

        tv_result.setText(".");
        bt_play_again.setVisibility(View.INVISIBLE);
        bt_play_again.setOnClickListener(this);
        print_total_score(game_profile.getScore(), game_profile.getTotal());

        myTimer();
        count.start();
        start_playing();
    }

    public void print_total_score(int score, int total) {
        String temp = score + " / " + total;
        tv_total_score.setText(temp);
    }

    public int generateRandom_integers(int max) {
        Random r = new Random();
        int i1 = r.nextInt(max - 1) + 1;
        return i1;
    }

    public void set_result(int index, int value) {
        TextView text;
        switch (index) {
            case 1:
                text = findViewById(R.id.textView1);
                text.setText(String.valueOf(value));
                break;
            case 2:
                text = findViewById(R.id.textView2);
                text.setText(String.valueOf(value));
                break;
            case 3:
                text = findViewById(R.id.textView3);
                text.setText(String.valueOf(value));
                break;

            case 4:
                text = findViewById(R.id.textView4);
                text.setText(String.valueOf(value));
                break;
        }

    }

    public void start_playing() {
        findViewById(R.id.grid_game_body).setOnClickListener(this);
        print_total_score(game_profile.getScore(), game_profile.getTotal());

        game_profile.setTotal(1);
        int index = generateRandom_integers(4);
        for (int i = 1; i <= 4; i++) {
            set_result(i, generateRandom_integers(80));
        }

        ArrayList<Integer> operations_list = new ArrayList<>();
        operations_list.add(generateRandom_integers(30));
        operations_list.add(generateRandom_integers(33));


        tv_operation.setText(operations_list.get(0) + " + " + operations_list.get(1));
        game_profile.setSolution(operations_list.get(0) + operations_list.get(1));
        set_result(index, game_profile.getSolution());


    }

    public void myTimer() {

        count = new CountDownTimer(30000 + 100, 1000) {

            @Override
            public void onTick(long l) {
                Log.d(TAG, "onTick: "+game_profile.toString());
                timer = true;
                tv_timer.setText(String.valueOf(l / 1000)+" s");

            }

            @Override
            public void onFinish() {
                timer = false;
                tv_result.setVisibility(View.INVISIBLE);
                m_gridlayout.setVisibility(View.INVISIBLE);
                bt_play_again.setVisibility(View.VISIBLE);

            }
        };
    }

    @Override
    public void onClick(View view) {
        TextView text;

        switch (view.getId()) {

            case R.id.bt_playgain:
                tv_result.setText("...");
                m_gridlayout.setVisibility(View.VISIBLE);
                game_profile = new Game_profile();
                bt_play_again.setVisibility(View.INVISIBLE);
                tv_result.setVisibility(View.VISIBLE);
                start_playing();
                count.start();
                break;

            case R.id.textView1:

                text = findViewById(R.id.textView1);
                if (String.valueOf(game_profile.getSolution()).contentEquals(text.getText())) {
                    game_profile.setScore(1);
                    tv_result.setText("Correct :)");
                    start_playing();
                    break;
                }
                tv_result.setText("Sorry Wrong answer :(");
                start_playing();
                break;

            case R.id.textView2:
                text = findViewById(R.id.textView2);
                if (String.valueOf(game_profile.getSolution()).contentEquals(text.getText())) {
                    game_profile.setScore(1);
                    tv_result.animate().translationY(20);
                    tv_result.setText("Correct :)");
                    start_playing();
                    break;
                }
                tv_result.setText("Sorry Wrong answer :(");
                start_playing();
                break;

            case R.id.textView3:
                text = findViewById(R.id.textView3);
                if (String.valueOf(game_profile.getSolution()).contentEquals(text.getText())) {
                    game_profile.setScore(1);
                    tv_result.setText("Correct :)");
                    start_playing();
                    break;
                }
                tv_result.setText("Sorry Wrong answer :(");
                start_playing();
                break;

            case R.id.textView4:
                text = findViewById(R.id.textView4);
                if (String.valueOf(game_profile.getSolution()).contentEquals(text.getText())) {
                    game_profile.setScore(1);
                    tv_result.setText("Correct :)");
                    start_playing();
                    break;
                }
                tv_result.setText("Sorry Wrong answer :(");
                start_playing();
                break;

        }
    }
}
