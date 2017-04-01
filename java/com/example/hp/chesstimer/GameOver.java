package com.example.hp.chesstimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        String s = getIntent().getStringExtra("player");
        TextView tv=(TextView) findViewById(R.id.winner);
        tv.setText(s+" Loses");
    }
}
